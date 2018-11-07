package hu.javagladiators.education.hoe.cataclysms.servlets;

import hu.javagladiators.education.hoe.cataclysms.view.CataclysmView;
import hu.javagladiators.education.hoe.cataclysms.entities.Cataclysm;
import hu.javagladiators.education.hoe.cataclysms.interfaces.CataclysmService;
import hu.javagladiators.education.hoe.cataclysms.services.CataclysmServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CataclysmServlet", urlPatterns = {"/cataclysm"})
public class CataclysmServlet extends HttpServlet {

    @Inject
    private CataclysmService catServ;
    private final String allCataclysmsAttributeName = "all";
    
    @Override
    public void init() throws ServletException {
        //catServ = new CataclysmService();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Cataclysm> all = new ArrayList<Cataclysm>();
        List<CataclysmView> allView = new ArrayList<CataclysmView>();
        all = catServ.getCataclysms();
        for (int i = 0; i < all.size(); i++) {
            //Cataclysm c = all.get(i);
            allView.add(new CataclysmView(all.get(i).getId(),all.get(i).getEmpireId(), all.get(i).getDescription(), all.get(i).getIntensity(), all.get(i).getDamage(), all.get(i).getDate(), all.get(i).getTime()));
        }
        getServletContext().setAttribute(allCataclysmsAttributeName, allView);
        getServletContext().getRequestDispatcher("/cataclysm.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("action").equals("update")){
            int id = Integer.valueOf(request.getParameter("id"));
            int empireId = Integer.valueOf(request.getParameter("empireId"));
            String description = request.getParameter("description");
            Short intensity = Short.valueOf(request.getParameter("intensity"));
            int damage = Integer.valueOf(request.getParameter("damage"));
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
            } catch (ParseException ex) {
                response.getWriter().write(":(");
                Logger.getLogger(CataclysmServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Time time = Time.valueOf(request.getParameter("time") + ":00");
            
            Cataclysm updatable = null;
            updatable = new Cataclysm(id, empireId, description, intensity, damage, date, time);           
            catServ.update(Integer.valueOf(id), updatable);
        }
        else if(request.getParameter("action").equals("add")){
            int empireId = Integer.valueOf(request.getParameter("empireId"));
            String description = request.getParameter("description");
            Short intensity = Short.valueOf(request.getParameter("intensity"));
            int damage = Integer.valueOf(request.getParameter("damage"));
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
            } catch (ParseException ex) {
                response.getWriter().write(":(");
                Logger.getLogger(CataclysmServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            Time time = Time.valueOf(request.getParameter("time")+ ":00");
            
            Cataclysm newCat = new Cataclysm(empireId, description, intensity, damage, date, time);
            catServ.addNew(newCat);
        }

        response.getWriter().write(":)");
    }

    @Override
    public String getServletInfo() {
        return "Nature will rise against you!";
    }
    
    @PreDestroy
    public void destruct()
    {
        catServ.close();
    }
}

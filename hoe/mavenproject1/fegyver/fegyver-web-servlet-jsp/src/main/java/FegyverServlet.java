
import hu.javagladiators.education.fegyver.dao.model.Fegyver;
import hu.javagladiators.education.fegyver.dao.model.FegyverDao;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import hu.javanetacademy.datamodel.Fegyver;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import hu.javanetacademy.dal.FegyverInterface;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tnyarsik
 */
@WebServlet(name = "FegyverServlet", urlPatterns = {"/fegyver"})
public class FegyverServlet extends HttpServlet {
     @Inject private FegyverDao fegyverdao;
       
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        long id = Long.parseLong(request.getParameter("id"));
        Fegyver fegyver = fegyverdao.keresFegyver(id);
        
        if (fegyver == null) {
            fegyverdao.ujFegyver(new Fegyver(request.getParameter("name"), request.getParameter("desc")));
        }
        else {           
            fegyverdao.szerkesztFegyver(fegyver, request.getParameter("name"), request.getParameter("desc"));
        }
        
        response.sendRedirect(request.getContextPath() + "/fegyverLista");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Fegyver fegyver = new Fegyver();
        
        if (id != null) {
            long fegyverId = Long.parseLong(id);
            fegyver = fegyverdao.keresFegyver(fegyverId);
        }
       
        req.setAttribute("fegyver", fegyver);
        getServletContext().getRequestDispatcher("/fegyver.jsp").include(req, resp);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Fegyver kezelése (mód, szerk, törl)";
    }// </editor-fold>
}

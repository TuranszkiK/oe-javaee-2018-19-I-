package hu.javagladiators.education.hoe.empire.web.controllers;

import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.empire.dao.models.Empire;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author krisztian
 */
@WebServlet(name = "EmpireModifyServlet", urlPatterns = {"/empire/modify"})
public class EmpireModifyServlet extends HttpServlet{
    private static final String MODIFYID="modifyempireid";

    @Inject
    private BaseService<Empire> service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        if(req.getParameter("id")!=null){
            long id=Long.parseLong(req.getParameter("id"));
            req.setAttribute("item",service.getById(id));
            req.getSession().setAttribute(MODIFYID,id);
        }
        getServletContext().getRequestDispatcher("/empire/modify.jsp").include(req, resp);
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        Empire empire = new Empire();
        empire.setName(req.getParameter("name"));
        empire.setDescription(req.getParameter("description"));
        try{
            service.modify(Long.parseLong(""+req.getSession().getAttribute(MODIFYID)),empire);
            req.setAttribute("items", service.getAll());
            getServletContext().getRequestDispatcher("/empire/index.jsp").include(req, resp);
        }
        catch(BusinessException e){
            e.printStackTrace();
            getServletContext().getRequestDispatcher("/empire/error/error.jsp").include(req, resp);
        }
        
    }
    
    
}

package hu.javagladiators.education.hoe.species.web.controllers;

import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.species.dao.models.Species;
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
@WebServlet(name = "SpeciesModifyServlet", urlPatterns = {"/species/modify"})
public class SpeciesModifyServlet extends HttpServlet{
    private static final String MODIFYID="modifyspeciesid";

    @Inject
    private BaseService<Species> service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        if(req.getParameter("id")!=null){
            long id=Long.parseLong(req.getParameter("id"));
            req.setAttribute("item",service.getById(id));
            req.getSession().setAttribute(MODIFYID,id);
        }
        getServletContext().getRequestDispatcher("/species/modify.jsp").include(req, resp);
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        Species species = new Species();
        species.setName(req.getParameter("name"));
        species.setDescription(req.getParameter("description"));
        try{
            service.modify(Long.parseLong(""+req.getSession().getAttribute(MODIFYID)),species);
            req.setAttribute("items", service.getAll());
            getServletContext().getRequestDispatcher("/species/index.jsp").include(req, resp);
        }
        catch(BusinessException e){
            e.printStackTrace();
            getServletContext().getRequestDispatcher("/species/error/error.jsp").include(req, resp);
        }
        
    }
    
    
}

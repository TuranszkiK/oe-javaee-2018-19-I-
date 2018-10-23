package hu.javagladiators.education.hoe.species.web.controllers;

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
@WebServlet(name = "SpeciesDeleteServlet", urlPatterns = {"/species/delete"})
public class SpeciesDeleteServlet extends HttpServlet{

    @Inject
    private BaseService<Species> service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        if(req.getParameter("id")!=null){
            long id=Long.parseLong(req.getParameter("id"));
            service.delete(id);
        }
        getServletContext().getRequestDispatcher("/species/main").include(req, resp);
    }
    
    
    
}

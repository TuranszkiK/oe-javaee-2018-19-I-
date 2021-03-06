package hu.javagladiators.education.hoe.defensivebuilding.web.controllers;

import hu.javagladiators.education.hoe.defensivebuilding.service.cdi.DefensiveBuildingServiceImpl;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mnagy
 */
@WebServlet(name = "DefensiveBuildingDeleteServlet", urlPatterns = {"/defensivebuilding/delete"})
public class DefensiveBuildingDeleteServlet extends HttpServlet {
 
    @Inject
    private DefensiveBuildingServiceImpl service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        if(req.getParameter("id")!=null){
            long id=Long.parseLong(req.getParameter("id"));
            service.delete(id);
        }
        getServletContext().getRequestDispatcher("/defensivebuilding/main").include(req, resp);
    }
    
    
}

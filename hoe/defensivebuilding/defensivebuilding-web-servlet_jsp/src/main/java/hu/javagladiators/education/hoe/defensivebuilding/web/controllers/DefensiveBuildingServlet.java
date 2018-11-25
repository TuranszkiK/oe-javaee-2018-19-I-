package hu.javagladiators.education.hoe.defensivebuilding.web.controllers;

import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.defensivebuilding.dao.models.DefensiveBuilding;
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
@WebServlet(name = "DefensiveBuildingServlet", urlPatterns = {"/defensivebuilding/main"})
public class DefensiveBuildingServlet extends HttpServlet {
    
    @Inject
    private DefensiveBuildingServiceImpl service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setAttribute("items", service.getAll());
        getServletContext().getRequestDispatcher("/defensivebuilding/index.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DefensiveBuilding defensiveBuilding = new DefensiveBuilding();
        defensiveBuilding.setHealth(Integer.parseInt(req.getParameter("health")));
        defensiveBuilding.setLevel(Integer.parseInt(req.getParameter("level")));
        defensiveBuilding.setAttackPoint(Integer.parseInt(req.getParameter("ap")));
        defensiveBuilding.setDefensePoint(Integer.parseInt(req.getParameter("dp")));
        
        try{
            service.create(defensiveBuilding);
            doGet(req, resp);
        }catch(BusinessException e){
            getServletContext().getRequestDispatcher("/defensivebuilding/error/error.jsp").include(req, resp);
        }
    }
    
    
    
}

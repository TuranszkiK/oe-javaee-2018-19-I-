/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@WebServlet(name = "DefensiveBuildingModifyServlet", urlPatterns = {"/defensivebuilding/modify"})
public class DefensiveBuildingModifyServlet extends HttpServlet {
    
    private static final String MODIFYID="modifydefensivebuildingid";

    @Inject
    private DefensiveBuildingServiceImpl service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        if(req.getParameter("id")!=null){
            long id=Long.parseLong(req.getParameter("id"));
            req.setAttribute("item",service.getById(id));
            req.getSession().setAttribute(MODIFYID,id);
        }
        getServletContext().getRequestDispatcher("/defensivebuilding/modify.jsp").include(req, resp);
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        DefensiveBuilding defensiveBuilding = new DefensiveBuilding();
        defensiveBuilding.setHealth(Integer.parseInt(req.getParameter("health")));
        defensiveBuilding.setLevel(Integer.parseInt(req.getParameter("level")));
        defensiveBuilding.setAttackPoint(Integer.parseInt(req.getParameter("ap")));
        defensiveBuilding.setDefensePoint(Integer.parseInt(req.getParameter("dp")));
        try{
            service.modify(Long.parseLong(""+req.getSession().getAttribute(MODIFYID)),defensiveBuilding);
            req.setAttribute("items", service.getAll());
            getServletContext().getRequestDispatcher("/defensivebuilding/index.jsp").include(req, resp);
        }
        catch(BusinessException e){
            e.printStackTrace();
            getServletContext().getRequestDispatcher("/defensivebuilding/error/error.jsp").include(req, resp);
        }
        
    }
    
}

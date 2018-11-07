/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.species.web.controllers;

import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.technology.dao.models.Technology;
import hu.javagladiators.education.hoe.technology.service.exception.TechnologyServiceException;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author krisztian
 */
@WebServlet(name = "TechnologyServlet", urlPatterns = {"/technology/main"})
public class TechnologyServlet extends HttpServlet {
    
    @Inject
    private BaseService<Technology> service;
    
        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        req.setAttribute("items", service.getAll());
        getServletContext().getRequestDispatcher("/technology/index.jsp").include(req, resp);
    }
    
        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Technology technology = new Technology();
        technology.setName(req.getParameter("name"));
        technology.setDescription(req.getParameter("description"));
        technology.setEmpireLevel(Integer.parseInt(req.getParameter("level")));
        try{
            service.create(technology);
            doGet(req, resp);
        }
        catch(TechnologyServiceException e){
            getServletContext().getRequestDispatcher("/technology/error/error.jsp").include(req, resp);
        }

    }
}

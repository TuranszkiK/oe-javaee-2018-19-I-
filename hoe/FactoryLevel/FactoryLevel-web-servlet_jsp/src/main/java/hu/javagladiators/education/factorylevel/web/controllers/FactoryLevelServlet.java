/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.factorylevel.web.controllers;

import hu.javagladiators.education.factorylevel.dao.models.FactoryLevel;
import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author I341314
 */
@WebServlet(name = "FactoryLevelServlet", urlPatterns = {"/factorylevel/main"})
public class FactoryLevelServlet extends HttpServlet{

    @Inject
    private BaseService<FactoryLevel> service;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        req.setAttribute("items", service.getAll());
        getServletContext().getRequestDispatcher("/factorylevel/index.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FactoryLevel fLevel = new FactoryLevel();
        fLevel.setName(req.getParameter("name"));
        fLevel.setDescription(req.getParameter("description"));
        fLevel.setLevel(req.getParameter("level"));
        fLevel.setExtra(req.getParameter("extra"));
        try{
            service.create(fLevel);
            doGet(req, resp);
        }
        catch(BusinessException e){
            getServletContext().getRequestDispatcher("/factorylevel/error/error.jsp").include(req, resp);
        }

    }
    
    
}
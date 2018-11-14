/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.species.web.controllers;

import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.technology.dao.models.Technology;
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
@WebServlet(name = "TechnologyModifyServlet", urlPatterns = {"/technology/modify"})
public class TechnologyModifyServlet extends HttpServlet {
    
    private static final String MODIFYID="modifytechnologyid";
    
    @Inject
    private BaseService<Technology> service;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        if(req.getParameter("id")!=null){
            long id=Long.parseLong(req.getParameter("id"));
            req.setAttribute("item",service.getById(id));
            req.getSession().setAttribute(MODIFYID,id);
        }
        getServletContext().getRequestDispatcher("/technology/modify.jsp").include(req, resp);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        Technology technology = new Technology();
        technology.setName(req.getParameter("name"));
        technology.setDescription(req.getParameter("description"));
        technology.setEmpireLevel(Integer.parseInt(req.getParameter("level")));
        try{
            service.modify(Long.parseLong(""+req.getSession().getAttribute(MODIFYID)),technology);
            req.setAttribute("items", service.getAll());
            getServletContext().getRequestDispatcher("/technology/index.jsp").include(req, resp);
        }
        catch(BusinessException e){
            e.printStackTrace();
            getServletContext().getRequestDispatcher("/technology/error/error.jsp").include(req, resp);
        }
        
    }
}

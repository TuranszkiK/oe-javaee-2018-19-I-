/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.magic.web.controllers;

import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.magic.dao.models.Magic;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Boldi
 */
@WebServlet(name = "MagicModifyServlet", urlPatterns = {"/magic/modify"})
public class MagicModifyServlet extends HttpServlet{
    private static final String MODIFYID="modifymagicid";

    @Inject
    private BaseService<Magic> service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        if(req.getParameter("id")!=null){
            long id=Long.parseLong(req.getParameter("id"));
            req.setAttribute("item",service.getById(id));
            req.getSession().setAttribute(MODIFYID,id);
        }
        getServletContext().getRequestDispatcher("/magic/modify.jsp").include(req, resp);
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        Magic magic = new Magic();
        magic.setName(req.getParameter("name"));
        magic.setDescription(req.getParameter("description"));
        magic.setDamage(Integer.parseInt(req.getParameter("damage")));
        magic.setCost(Integer.parseInt(req.getParameter("cost")));
        try{
            service.modify(Long.parseLong(""+req.getSession().getAttribute(MODIFYID)),magic);
            req.setAttribute("items", service.getAll());
            getServletContext().getRequestDispatcher("/magic/index.jsp").include(req, resp);
        }
        catch(BusinessException e){
            e.printStackTrace();
            getServletContext().getRequestDispatcher("/magic/error/error.jsp").include(req, resp);
        }
        
    }
    
    
}

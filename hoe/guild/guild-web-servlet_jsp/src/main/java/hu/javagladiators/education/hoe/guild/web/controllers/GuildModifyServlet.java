/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.guild.web.controllers;

import hu.javagladiators.education.guild.dao.models.Guild;
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
 * @author krisztian
 */

@WebServlet(name = "GuildModifyServlet", urlPatterns = {"/guild/modify"})
public class GuildModifyServlet extends HttpServlet{
     private static final String MODIFYID="modifyspeciesid";

    @Inject
    private BaseService<Guild> service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        if(req.getParameter("id")!=null){
            long id=Long.parseLong(req.getParameter("id"));
            req.setAttribute("item",service.getById(id));
            req.getSession().setAttribute(MODIFYID,id);
        }
        getServletContext().getRequestDispatcher("/guild/modify.jsp").include(req, resp);
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        Guild guild = new Guild();
        guild.setName(req.getParameter("name"));
        guild.setDescription(req.getParameter("description"));
        try{
            service.modify(Long.parseLong(""+req.getSession().getAttribute(MODIFYID)),guild);
            req.setAttribute("items", service.getAll());
            getServletContext().getRequestDispatcher("/guild/index.jsp").include(req, resp);
        }
        catch(BusinessException e){
            e.printStackTrace();
            getServletContext().getRequestDispatcher("/guild/error/error.jsp").include(req, resp);
        }
        
    }
    
    
}

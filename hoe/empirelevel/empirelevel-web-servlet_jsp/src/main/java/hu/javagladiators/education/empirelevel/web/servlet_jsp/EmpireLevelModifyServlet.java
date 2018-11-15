/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.empirelevel.web.controllers;

import hu.javagladiators.education.empirelevel.dao.models.EmpireLevel;
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
 * @author Kesztike95
 */
@WebServlet(name = "EmpireLevelModifyServlet", urlPatterns = {"/empirelevel/modify"})
public class EmpireLevelModifyServlet extends HttpServlet {
    private static final String MODIFYID="modifyvlid";

    @Inject
    private BaseService<EmpireLevel> service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        if(req.getParameter("id")!=null){
            long id=Long.parseLong(req.getParameter("id"));
            req.setAttribute("item",service.getById(id));
            req.getSession().setAttribute(MODIFYID,id);
        }
        getServletContext().getRequestDispatcher("/empirelevel/modify.jsp").include(req, resp);
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        EmpireLevel vehiclelevel = new EmpireLevel();
        vehiclelevel.setName(req.getParameter("name"));
        vehiclelevel.setDesc(req.getParameter("description"));
        try{
            service.modify(Long.parseLong(""+req.getSession().getAttribute(MODIFYID)),vehiclelevel);
            req.setAttribute("items", service.getAll());
            getServletContext().getRequestDispatcher("/empirelevels/index.jsp").include(req, resp);
        }
        catch(BusinessException e){
            e.printStackTrace();
            getServletContext().getRequestDispatcher("/empirelevels/error/error.jsp").include(req, resp);
        }
        
    }
}

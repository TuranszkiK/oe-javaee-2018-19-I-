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


@WebServlet(name = "EmpireLevelServlet", urlPatterns = {"/empirelevel/main"})
public class EmpireLevelServlet extends HttpServlet{
    @Inject
    private BaseService<EmpireLevel> service;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        req.setAttribute("items", service.getAll());
        getServletContext().getRequestDispatcher("/empirelevel/index.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmpireLevel vl = new EmpireLevel();
        vl.setName(req.getParameter("name"));
        vl.setDesc(req.getParameter("description"));
        try{
            service.create(vl);
            doGet(req, resp);
        }
        catch(BusinessException e){
            getServletContext().getRequestDispatcher("/empirelevel/error/error.jsp").include(req, resp);
        }

    }
}

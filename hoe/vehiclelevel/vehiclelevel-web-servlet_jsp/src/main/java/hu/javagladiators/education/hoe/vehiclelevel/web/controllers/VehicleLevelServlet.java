/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.vehiclelevel.web.controllers;
import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.vehiclelevel.dao.models.VehicleLevel;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KTengely
 */
@WebServlet(name = "VehicleLevelServlet", urlPatterns = {"/vehiclelevel/main"})
public class VehicleLevelServlet extends HttpServlet{
    @Inject
    private BaseService<VehicleLevel> service;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        req.setAttribute("items", service.getAll());
        getServletContext().getRequestDispatcher("/vehiclelevel/index.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VehicleLevel vl = new VehicleLevel();
        vl.setName(req.getParameter("name"));
        vl.setDesc(req.getParameter("description"));
        try{
            service.create(vl);
            doGet(req, resp);
        }
        catch(BusinessException e){
            getServletContext().getRequestDispatcher("/vehiclelevel/error/error.jsp").include(req, resp);
        }

    }
}

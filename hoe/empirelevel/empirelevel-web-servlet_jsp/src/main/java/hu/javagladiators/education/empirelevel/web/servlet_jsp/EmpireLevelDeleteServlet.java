/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.empirelevel.web.controllers;

import hu.javagladiators.education.empirelevel.dao.models.EmpireLevel;
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
@WebServlet(name = "VehicleLevelDeleteServlet", urlPatterns = {"/vehiclelevels/delete"})
public class EmpireLevelDeleteServlet extends HttpServlet{
     @Inject
    private BaseService<EmpireLevel> service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        if(req.getParameter("id")!=null){
            long id=Long.parseLong(req.getParameter("id"));
            service.delete(id);
        }
        getServletContext().getRequestDispatcher("/empirelevel/main").include(req, resp);
    }
}

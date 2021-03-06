/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.vehicleaccessory.web.controllers;

import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.vehicleaccessory.dao.models.VehicleAccessory;
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
@WebServlet(name = "VehicleAccessoryModifyServlet", urlPatterns = {"/vehicleaccessory/modify"})
public class VehicleAccessoryModifyServlet extends HttpServlet{
    private static final String MODIFYID="modifyvehicleaccessoryid";

    @Inject
    private BaseService<VehicleAccessory> service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        if(req.getParameter("id")!=null){
            long id=Long.parseLong(req.getParameter("id"));
            req.setAttribute("item",service.getById(id));
            req.getSession().setAttribute(MODIFYID,id);
        }
        getServletContext().getRequestDispatcher("/vehicleaccessory/modify.jsp").include(req, resp);
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        VehicleAccessory vehicleaccessory = new VehicleAccessory();
        vehicleaccessory.setName(req.getParameter("name"));
        vehicleaccessory.setDescription(req.getParameter("description"));
        vehicleaccessory.setAddedDamage(Integer.parseInt(req.getParameter("addeddamage")));
        vehicleaccessory.setAddedShield(Integer.parseInt(req.getParameter("addedshield")));
        vehicleaccessory.setPrice(Integer.parseInt(req.getParameter("price")));
        try{
            service.modify(Long.parseLong(""+req.getSession().getAttribute(MODIFYID)),vehicleaccessory);
            req.setAttribute("items", service.getAll());
            getServletContext().getRequestDispatcher("/vehicleaccessory/index.jsp").include(req, resp);
        }
        catch(BusinessException e){
            e.printStackTrace();
            getServletContext().getRequestDispatcher("/vehicleaccessory/error/error.jsp").include(req, resp);
        }
        
    }
    
    
}

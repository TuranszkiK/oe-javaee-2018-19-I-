/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.building.web.controller;

import hu.javagladiators.education.hoe.building.dao.model.models.Building;
import hu.javagladiators.education.hoe.building.service.BuildingServiceImpl;


import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cserof
 */
@WebServlet(name = "BuildingServlet", urlPatterns = {"/building/edit"})
public class BuildingServlet extends HttpServlet {

    @Inject private BuildingServiceImpl service;
       
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        long id = Long.parseLong(request.getParameter("id"));
        Building building = service.getById(id);
        
        if (building == null) {
            service.create(new Building(request.getParameter("name"), request.getParameter("desc")));
        }
        else {           
            service.tryModify(id, request.getParameter("name"), request.getParameter("desc"));
        }
        
        response.sendRedirect(request.getContextPath() + "/building/buildingList");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Building building = new Building();
        
        if (id != null) {
            long buildingId = Long.parseLong(id);
            building = service.getById(buildingId);
        }
       
        req.setAttribute("building", building);
        getServletContext().getRequestDispatcher("/building/building.jsp").include(req, resp);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Épületek kezelésére";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.building.web.controller;

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
@WebServlet(name = "BuildingListServlet", urlPatterns = {"/buildingList"})
public class BuildingListServlet extends HttpServlet {

    @Inject private BuildingServiceImpl service;
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        
        response.setContentType("text/html;charset=UTF-8");  
        request.setAttribute("buildings", service.getAll());
        
        getServletContext().getRequestDispatcher("/buildingList.jsp").include(request, response);
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Épületek listázása";
    }// </editor-fold>

}

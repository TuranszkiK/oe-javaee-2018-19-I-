/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.petlevel.controllers;

import hu.javagladiators.education.hoe.petlevel.dao.PetLevel;
import hu.javagladiators.education.hoe.petlevel.dao.PetLevelException;
import hu.javagladiators.education.hoe.petlevel.services.PetLevelResource;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PetLevel", urlPatterns = {"/PetLevel"})
public class GetAll extends HttpServlet {

    @Inject
    PetLevelResource resource ;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            List<PetLevel> all = this.resource.getAll();
            request.setAttribute("dbus", all);
            request.getRequestDispatcher("/petLevel.jsp").include(request, response);
        } catch (PetLevelException e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("/error.jsp").include(request, response);
        }    
    }
}
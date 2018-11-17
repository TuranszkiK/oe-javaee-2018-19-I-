/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.petiem.controllers;

import hu.javagladiators.education.hoe.petitem.dao.PetItem;
import hu.javagladiators.education.hoe.petitem.dao.PetItemException;
import hu.javagladiators.education.hoe.petitem.services.PetItemResource;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PetItem", urlPatterns = {"/petitem/main"})
public class PetItemServlet extends HttpServlet
{
    @Inject
    PetItemResource resource;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {        
        try
        {
            List<PetItem> items = resource.getAll();
            request.setAttribute("items", items);
            request.getRequestDispatcher("/PetItem.jsp").include(request, response);
        }
        catch(PetItemException e)
        {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("/Error.jsp").include(request, response);
        }    
    }
}
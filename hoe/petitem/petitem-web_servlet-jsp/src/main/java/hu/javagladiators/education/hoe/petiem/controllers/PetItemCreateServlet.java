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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PetItemCreate", urlPatterns = {"/petitem/create"})
public class PetItemCreateServlet extends HttpServlet
{
    @Inject
    PetItemResource resource;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (!missingParameters(request.getParameterMap()).isEmpty())
        {
            String errorMessage = "The following parameters are missing " + String.join(",", missingParameters(request.getParameterMap()));
            request.setAttribute("message", errorMessage);
            request.getRequestDispatcher("/Error.jsp").forward(request, response);
        } 
        else
        {
            try
            {
                PetItem d = new PetItem();
                d.setName(request.getParameter("ItemName"));
                d.setDescription(request.getParameter("ItemDescription"));
                
                resource.create(d);
                response.sendRedirect("/petitem/main");                
            }
            catch (PetItemException ex)
            {
                request.setAttribute("message", ex.getMessage());
                request.getRequestDispatcher("/Error.jsp").forward(request, response);
            }            
        }
    }

    private List<String> missingParameters(Map<String, String[]> params)
    {
        List<String> missingParams = new ArrayList<>();
        if (!params.containsKey("ItemName") || params.get("ItemName")[0]==null || params.get("ItemName")[0].trim().isEmpty())
        {
            missingParams.add("ItemName");
        }
        if (!params.containsKey("ItemDescription") || params.get("ItemDescription")[0]==null || params.get("ItemDescription")[0].trim().isEmpty())
        {
            missingParams.add("ItemDescription");
        }
        return missingParams;
    }
}

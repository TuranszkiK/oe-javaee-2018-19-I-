/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.petiem.controllers;

import hu.javagladiators.education.hoe.petitem.dao.PetItemException;
import hu.javagladiators.education.hoe.petitem.services.PetItemResource;
import java.io.IOException;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PetItemDelete", urlPatterns = {"/petitem/delete"})
public class PetItemDeleteServlet extends HttpServlet
{    
    @Inject
    PetItemResource resource;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if(validate(request.getParameterMap()))
        {
            try
            {                    
                long id = Long.parseLong(request.getParameter("id"));
                resource.delete(id);
                response.sendRedirect("/petitem/main");
            }
            catch (PetItemException e)
            {
                request.setAttribute("message", e.getMessage());
                request.getRequestDispatcher("/Error.jsp").forward(request, response);
            }
        }
        else
        {
            request.setAttribute("message", "Missing identifier!");
            request.getRequestDispatcher("/Error.jsp").forward(request, response);
        }
    }
    
    private boolean validate(Map<String,String[]> paramMap)
    {
        return paramMap.containsKey("id") && Utils.isNumber(paramMap.get("id")[0]);
    }    
}
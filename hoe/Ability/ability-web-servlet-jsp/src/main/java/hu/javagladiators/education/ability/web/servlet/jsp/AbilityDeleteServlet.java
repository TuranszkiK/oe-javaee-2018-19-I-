/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.ability.web.servlet.jsp;

import hu.javagladiators.education.ability.service.cdi.AbilityServiceImpl;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kristóf
 */
public class AbilityDeleteServlet extends HttpServlet {
    
    @Inject
    private AbilityServiceImpl service;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        service.deleteAbility(Long.parseLong(request.getParameter("id")));
        
        response.sendRedirect(request.getContextPath() + "/ability/abilityList");
    }

    @Override
    public String getServletInfo() {
        return "Deleting a specific ability";
    }
}

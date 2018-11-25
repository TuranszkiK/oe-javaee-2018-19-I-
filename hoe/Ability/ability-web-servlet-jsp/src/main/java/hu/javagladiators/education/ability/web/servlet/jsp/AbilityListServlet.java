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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kristóf
 */
@WebServlet(name = "AbilityListServlet", urlPatterns = {"/ability/abilityList"})
public class AbilityListServlet extends HttpServlet{
    
    @Inject
    private AbilityServiceImpl service;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        
        response.setContentType("text/html;charset=UTF-8");  
        request.setAttribute("abilities", service.getAll());
        
        getServletContext().getRequestDispatcher("/ability/abilityList.jsp").include(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Listing abilities";
    }// </editor-fold>
}

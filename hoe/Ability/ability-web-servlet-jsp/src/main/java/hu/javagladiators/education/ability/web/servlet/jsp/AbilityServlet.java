/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.ability.web.servlet.jsp;

import hu.javagladiators.education.ability.dao.model.Ability;
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
@WebServlet(name = "AbilityServlet", urlPatterns= {"ability/edit"})
public class AbilityServlet extends HttpServlet{
    @Inject
    private AbilityServiceImpl service;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        long id = Long.parseLong(req.getParameter("id"));
        Ability ability = service.getById(id);
        
        if (ability == null) {
            service.create(new Ability(req.getParameter("name"),req.getParameter("desc"),req.getParameter("type"), Integer.parseInt(req.getParameter("value")), Integer.parseInt(req.getParameter("coolDown"))));
        }else{
            service.tryModify(id, req.getParameter("name"),req.getParameter("desc"),req.getParameter("type"), Integer.parseInt(req.getParameter("value")), Integer.parseInt(req.getParameter("coolDown")));
        }
        
        res.sendRedirect(req.getContextPath() + "ability/abilityList");
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        String id = req.getParameter("id");
        Ability ability = new Ability();
        
        if (id != null) {
            long abilityId = Long.parseLong(id);
            ability = service.getById(abilityId);
        }
        
        req.setAttribute("ability", ability);
        getServletContext().getRequestDispatcher("ability/ability.jsp").include(req, res);
    }
    
    
    @Override
    public String getServletInfo() {
        return "Ability control";
    }// </editor-fold>
}

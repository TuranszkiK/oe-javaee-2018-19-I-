package hu.javagladiators.education.hoe.pets.web.controllers;

import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.pets.dao.models.Pets;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SpeciesModifyServlet", urlPatterns = {"/pets/modify"})
public class PetsModifyServlet extends HttpServlet{
    private static final String MODIFYID="modifypetsid";

    @Inject
    private BaseService<Pets> service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        if(req.getParameter("id")!=null){
            long id=Long.parseLong(req.getParameter("id"));
            req.setAttribute("item",service.getById(id));
            req.getSession().setAttribute(MODIFYID,id);
        }
        getServletContext().getRequestDispatcher("/pets/modify.jsp").include(req, resp);
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        Pets pets = new Pets();
        pets.setName(req.getParameter("name"));
        pets.setType(req.getParameter("type"));
        pets.setStrength(req.getParameter("strength"));
        try{
            service.modify(Long.parseLong(""+req.getSession().getAttribute(MODIFYID)),pets);
            req.setAttribute("items", service.getAll());
            getServletContext().getRequestDispatcher("/pets/index.jsp").include(req, resp);
        }
        catch(BusinessException e){
            e.printStackTrace();
            getServletContext().getRequestDispatcher("/pets/error/error.jsp").include(req, resp);
        }
    } 
}

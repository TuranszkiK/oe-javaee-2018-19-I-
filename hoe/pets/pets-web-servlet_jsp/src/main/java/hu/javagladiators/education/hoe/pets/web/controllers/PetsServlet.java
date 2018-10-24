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

@WebServlet(name = "PetsServlet", urlPatterns = {"/pets/main"})
public class PetsServlet extends HttpServlet{

    @Inject
    private BaseService<Pets> service;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        req.setAttribute("items", service.getAll());
        getServletContext().getRequestDispatcher("/pets/getall.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pets pets = new Pets();
        pets.setName(req.getParameter("name"));
        pets.setType(req.getParameter("type"));
        pets.setStrength(req.getParameter("strength"));
        try{
            service.create(pets);
            doGet(req, resp);
        }
        catch(BusinessException e){
            getServletContext().getRequestDispatcher("/pets/error/error.jsp").include(req, resp);
        }
    }
}

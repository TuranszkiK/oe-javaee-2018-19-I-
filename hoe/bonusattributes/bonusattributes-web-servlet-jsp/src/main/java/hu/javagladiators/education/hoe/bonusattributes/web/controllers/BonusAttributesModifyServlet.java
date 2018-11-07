package hu.javagladiators.education.hoe.bonusattributes.web.controllers;

import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.bonusattributes.dao.models.BonusAttributes;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BonusAttributesModifyServlet", urlPatterns = {"/bonusattributes/modify"})
public class BonusAttributesModifyServlet extends HttpServlet{
    private static final String MODIFYID="modifybonusattributesid";

    @Inject
    private BaseService<BonusAttributes> service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        if(req.getParameter("id")!=null){
            long id=Long.parseLong(req.getParameter("id"));
            req.setAttribute("item",service.getById(id));
            req.getSession().setAttribute(MODIFYID,id);
        }
        getServletContext().getRequestDispatcher("/bonusattributes/modify.jsp").include(req, resp);
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8"); 
        BonusAttributes bonusattributes = new BonusAttributes();
        bonusattributes.setName(req.getParameter("name"));
        bonusattributes.setDescription(req.getParameter("description"));
        bonusattributes.setValue(Integer.parseInt(req.getParameter("value")));
        try{
            service.modify(Long.parseLong(""+req.getSession().getAttribute(MODIFYID)),bonusattributes);
            req.setAttribute("items", service.getAll());
            getServletContext().getRequestDispatcher("/bonusattributes/index.jsp").include(req, resp);
        }
        catch(BusinessException e){
            e.printStackTrace();
            getServletContext().getRequestDispatcher("/bonusattributes/error/error.jsp").include(req, resp);
        }
        
    }
    
    
}

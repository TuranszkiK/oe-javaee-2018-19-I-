/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oe.hoe.heroarmor.services;

import hu.oe.hoe.heroarmor.utils.enums.ArmorPart;
import hu.oe.hoe.heroarmor.utils.enums.ArmorType;
import hu.oe.hoe.heroarmor.utils.enums.Durability;
import hu.oe.hoe.heroarmor.datamodel.HeroArmor;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author szark
 */
//@WebServlet(loadOnStartup = 1)
public class ModifyServlet extends HttpServlet {
    private final static String AllHeroArmors = "heroarmors";
    @Inject ArmorCRUDService crud;
    //private final static ArmorCRUDService crud = new ArmorCRUDService();
//    @Override
//    public void init() throws ServletException {
//        getServletContext().setAttribute(AllHeroArmors,crud.getAllHeroArmor());
//        
//    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getSession().setAttribute(AllHeroArmors,crud.getAllHeroArmor());
        getServletContext().getRequestDispatcher("/index.jsp").include(request,response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("delete")){
            doDelete(request,response);
            return;
        }
        else if(request.getParameterMap().containsKey("update"))
        {
            doPut(request,response);
            return;
        }

        HeroArmor newArmor = new HeroArmor(
                request.getParameter("editArmorName"),
                request.getParameter("editArmorDescription"),
                Integer.valueOf(request.getParameter("editArmor")),
                Enum.valueOf(ArmorType.class,request.getParameter("editArmorType")),
                Enum.valueOf(ArmorPart.class,request.getParameter("editArmorPart")),
                Enum.valueOf(Durability.class,request.getParameter("editArmorDurability"))
        );

        crud.addNew(newArmor);
        doGet(request,response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("editArmorId"));
        String name = req.getParameter("editArmorName");
        String description = req.getParameter("editArmorDescription");
        int armor = Integer.valueOf(req.getParameter("editArmor"));
        ArmorType armorType = Enum.valueOf(ArmorType.class,req.getParameter("editArmorType"));
        ArmorPart armorPart = Enum.valueOf(ArmorPart.class, req.getParameter("editArmorPart"));
        Durability durability = Enum.valueOf(Durability.class,req.getParameter("editArmorDurability"));
        boolean active = Boolean.valueOf(req.getParameter("active"));

        HeroArmor editArmor = new HeroArmor(
                name,
                description,
                armor,
                armorType,
                armorPart,
                durability
        );
        editArmor.setActive(active);

        crud.Update(id, editArmor);
        doGet(req,resp);
    }
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id  = Long.parseLong(req.getParameter("deleteSelected"));
        crud.DeleteById(id);
        doGet(req,resp);
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

package hu.javagladiators.education.hoe.amulett.controllers;

import hu.javagladiators.education.hoe.amulett.dao.interfaces.AmulettDao;
import hu.javagladiators.education.hoe.amulett.dao.models.Amulett;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kbitter
 */
@WebServlet(name = "AmulettDeleteServlet", urlPatterns = {"/amulett/delete"})
public class AmulettDeleteServlet extends HttpServlet {

    @Inject private AmulettDao dao;
       
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Amulett b = dao.findAmulett(Long.parseLong(request.getParameter("id")));
        dao.removeAmulett(b);
        
        response.sendRedirect(request.getContextPath() + "/amulettList");
    }

 
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Deleting a specific amulett";
    }// </editor-fold>

}

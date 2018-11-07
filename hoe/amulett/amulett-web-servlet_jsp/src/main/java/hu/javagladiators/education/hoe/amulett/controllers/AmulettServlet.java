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
@WebServlet(name = "AmulettServlet", urlPatterns = {"/amulett"})
public class AmulettServlet extends HttpServlet {

    @Inject private AmulettDao dao;
       
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        long id = Long.parseLong(request.getParameter("id"));
        Amulett amulett = dao.findAmulett(id);
        
        if (amulett == null) {
            dao.insertAmulett(new Amulett(request.getParameter("name"), request.getParameter("desc")));
        }
        else {           
            dao.updateAmulett(amulett, request.getParameter("name"), request.getParameter("desc"));
        }
        
        response.sendRedirect(request.getContextPath() + "/amulettList");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Amulett amulett = new Amulett();
        
        if (id != null) {
            long amulettId = Long.parseLong(id);
            amulett = dao.findAmulett(amulettId);
        }
       
        req.setAttribute("amulett", amulett);
        getServletContext().getRequestDispatcher("/amulett.jsp").include(req, resp);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servelet for Amuletts";
    }// </editor-fold>

}

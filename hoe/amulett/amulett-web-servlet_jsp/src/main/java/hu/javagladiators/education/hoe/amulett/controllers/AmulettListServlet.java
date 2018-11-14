package hu.javagladiators.education.hoe.amulett.controllers;

import hu.javagladiators.education.hoe.amulett.dao.interfaces.AmulettDao;
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
@WebServlet(name = "AmulettListServlet", urlPatterns = {"/amulettList"})
public class AmulettListServlet extends HttpServlet {

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
        
        response.setContentType("text/html;charset=UTF-8");  
        request.setAttribute("amuletts", dao.getAmuletts());
        
        getServletContext().getRequestDispatcher("/amulettList.jsp").include(request, response);
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servelet for Amulett List";
    }// </editor-fold>

}

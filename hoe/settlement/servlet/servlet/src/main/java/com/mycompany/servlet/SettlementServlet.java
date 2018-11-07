/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import bean.SettlementBean;
import datamodel.Settlement;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tata
 */
@WebServlet(name = "SettlementServlet", urlPatterns = {"/settlement"})
public class SettlementServlet extends HttpServlet {
    
    @Inject
    SettlementBean settlementbean;
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String message)
            throws ServletException, IOException {
        

        
        //Settlement asd = em.find(Settlement.class, (long)1);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SettlementServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet SettlementServlet at " + request.getContextPath() + "</h1>");
            //out.println("<h1>Servlet SettlementServlet at " + request.getAttribute("name") + "</h1>");
            //out.println("<h1>Servlet SettlementServlet at " + request.getAttribute("descr") + "</h1>");
            //out.println("<h1>Servlet SettlementServlet at " + request.getContextPath() + "</h1>");
            //out.println("<h1>Servlet SettlementServlet at " + asd.getDescription()+ "</h1>");
            out.println("<h1>"+message+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        //Settlement sett = em.find(Settlement.class, Long.parseLong(request.getParameter("id")));
        settlementbean = new SettlementBean();
        try {
            settlementbean.getbyId(Long.parseLong(request.getParameter("id")));
        } catch (Exception ex) {
            Logger.getLogger(SettlementServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //String name = sett.getName();
        String name = settlementbean.getCurrentSettlement().getName();
        //String descr = sett.getDescription();
        String descr = settlementbean.getCurrentSettlement().getDescription();
        
        request.setAttribute("name", name);
        request.setAttribute("descr", descr);
        processRequest(request, response, "Fetched settlement:"+name+" "+descr);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        settlementbean = new SettlementBean();
        switch (request.getParameter("method"))
        {
            case "upload": upload(request,response);
            break;
            
            case "delete": {
            try {
                delete(request,response);
            } catch (Exception ex) {
                Logger.getLogger(SettlementServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            break;
            
            case "modify": {
            try {
                modify(request,response);
            } catch (Exception ex) {
                Logger.getLogger(SettlementServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            break;
            
        }

    }
    
    protected void upload(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //Settlement newsett = new Settlement(request.getParameter("name"), request.getParameter("description"));
        settlementbean.getCurrentSettlement().setName(request.getParameter("name"));
        settlementbean.getCurrentSettlement().setDescription(request.getParameter("description"));
        
        
        settlementbean.saveSettlement(settlementbean.getCurrentSettlement());
        processRequest(request, response, "Uploaded: "+request.getParameter("name")+" "+request.getParameter("description"));
    }
    
    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception
    {
        settlementbean.getbyId(Long.parseLong(request.getParameter("id")));
        settlementbean.deleteSettlement(settlementbean.getCurrentSettlement());
        processRequest(request, response, "Deleted this ID: "+request.getParameter("id"));
    }
    
    protected void modify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception
    {
         settlementbean.getbyId(Long.parseLong(request.getParameter("id")));
        settlementbean.getCurrentSettlement().setName(request.getParameter("name"));
        settlementbean.getCurrentSettlement().setDescription(request.getParameter("description"));
        settlementbean.saveSettlement(settlementbean.getCurrentSettlement());
        processRequest(request, response, "Modified this ID: "+request.getParameter("id")+"with: "+request.getParameter("name")+" "+request.getParameter("description"));
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

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}

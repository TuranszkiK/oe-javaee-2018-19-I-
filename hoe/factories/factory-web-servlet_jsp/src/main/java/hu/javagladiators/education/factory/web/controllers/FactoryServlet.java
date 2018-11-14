/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.factory.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;
import hu.javagladiators.education.factory.service.FactoryServiceImpl;
import hu.javagladiators.education.factory.dao.models.Factory;

/**
 *
 * @author Lóci
 */

@WebServlet(name ="FactoryServlet", urlPatterns = {"/factories/factory"}, loadOnStartup = 1)
public class FactoryServlet extends HttpServlet {

    @Inject private FactoryServiceImpl fsi;
    public static final String APPContextName ="factories";
    
    @Override
    public void init() throws ServletException {        
        super.init(); 
        getServletContext().setAttribute(APPContextName,new ArrayList<Factory>());
    }
    
   // @Override
   //public void destroy() {
   //   emf.close();
   //}

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FactoryServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FactoryServlet at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8"); 
        request.setAttribute("factories",fsi.getSystemFactories());
        
        getServletContext().getRequestDispatcher("/factory.jsp").include(request, response);
        
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
        
        if(request.getParameter("sel") != null){
            if((request.getParameter("deletemod")).equals("DELETE")){ //törlés
                List<Factory> fs = fsi.getSystemFactories();
                Factory toDelete = null;
                for(int i=0; i< fs.size(); i++){
                    String a = "a";
                    if(new String(request.getParameter("dropdown")).equals(new String(fs.get(i).getName()))){
                        toDelete = fsi.findFactory(fs.get(i).getId());
                    }
                }
                fsi.removeFactory(toDelete);
            }
            else{ //módosítás
                List<Factory> fs = fsi.getSystemFactories();
                Factory toMod = null;
                for(Factory f : fs){
                    if(request.getParameter("dropdown").equals(f.getName())){
                        toMod = f;
                    }
                }
                Factory ff = fsi.findFactory(toMod.getId());
                
                ff.setName(request.getParameter("modname"));
                if(!request.getParameter("moddesc").equals(""))
                    ff.setDescription(request.getParameter("moddesc"));
                if(!request.getParameter("modprod").equals(""))
                    ff.setProduct(request.getParameter("modprod"));
                if(!request.getParameter("modfrom").equals(""))
                    ff.setFrom(request.getParameter("modfrom"));
                fsi.modifyFactory(ff);
            }
        }
        else if(request.getParameter("new") != null){
            Factory fact = new Factory(request.getParameter("fname"), request.getParameter("fdesc"), request.getParameter("fprod"), request.getParameter("ffrom"));
            fsi.insertFactory(fact);
        }
        
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Factory servlet to manage factories";
    }// </editor-fold>

}

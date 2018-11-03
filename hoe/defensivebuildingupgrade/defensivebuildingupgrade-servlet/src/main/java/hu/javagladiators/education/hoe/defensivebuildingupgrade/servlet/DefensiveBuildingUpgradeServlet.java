package hu.javagladiators.education.hoe.defensivebuildingupgrade.servlet;

import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.defensivebuildingupgrade.model.DefensiveBuildingUpgrade;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DefensiveBuildingUpgradeServlet", urlPatterns = {"/defensivebuildingupgrade/main"})
public class DefensiveBuildingUpgradeServlet extends HttpServlet {
 
    @Inject
    private BaseService<DefensiveBuildingUpgrade> service;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<DefensiveBuildingUpgrade> all = this.service.getAll();
            request.setAttribute("dbus", all);
            request.getRequestDispatcher("/defensivebuildingupgrade/defensiveBuildingUpgrade.jsp").include(request, response);
        } catch (BusinessException e) {
            request.setAttribute("message", "The request was unsuccessful.");
            request.getRequestDispatcher("/defensivebuildingupgrade/error/error.jsp").include(request, response);
        }   
    }   
}

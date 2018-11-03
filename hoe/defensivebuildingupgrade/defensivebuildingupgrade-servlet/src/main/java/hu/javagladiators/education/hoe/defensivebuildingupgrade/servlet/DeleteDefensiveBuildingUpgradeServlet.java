package hu.javagladiators.education.hoe.defensivebuildingupgrade.servlet;

import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.defensivebuildingupgrade.model.DefensiveBuildingUpgrade;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteDefensiveBuildingUpgradeServlet", urlPatterns = {"/defensivebuildingupgrade/delete"})
public class DeleteDefensiveBuildingUpgradeServlet extends HttpServlet {

    @Inject
    private BaseService<DefensiveBuildingUpgrade> service;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            long id = Long.parseLong(request.getParameter("id"));
            service.delete(id);
            response.sendRedirect("/hoe/defensivebuildingupgrade/main");
        } catch (BusinessException e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("/defensivebuildingupgrade/error/error.jsp").forward(request, response);
        }
    }
}

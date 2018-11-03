package hu.javagladiators.education.hoe.defensivebuildingupgrade.servlet;

import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.defensivebuildingupgrade.model.DefensiveBuildingUpgrade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UpdateDefensiveBuildingUpgradeServlet", urlPatterns = {"/defensivebuildingupgrade/update"})
public class UpdateDefensiveBuildingUpgradeServlet extends HttpServlet {
    
    @Inject
    private BaseService<DefensiveBuildingUpgrade> service;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            try {
                DefensiveBuildingUpgrade dbu = service.getById(Long.parseLong(request.getParameter("id")));
                request.setAttribute("dbu", dbu);
                request.getRequestDispatcher("/defensivebuildingupgrade/defensiveBuildingUpgradeEditor.jsp").forward(request, response);
            } catch (BusinessException ex) {
                request.setAttribute("message", "Unsuccessful request.");
                request.getRequestDispatcher("/defensivebuildingupgrade/error/error.jsp").forward(request, response);
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            if (!missingParameters(request.getParameterMap()).isEmpty()) {
                String errorMessage = "The following parameters are missing " + String.join(",", missingParameters(request.getParameterMap()));
                request.setAttribute("message", errorMessage);
                request.getRequestDispatcher("/defensivebuildingupgrade/error/error.jsp").forward(request, response);
            } else {
                try {
                    DefensiveBuildingUpgrade d = new DefensiveBuildingUpgrade();
                    d.setId(Long.parseLong(request.getParameter("id")));
                    d.setName(request.getParameter("name"));
                    d.setHp(Integer.parseInt(request.getParameter("hp")));
                    d.setAttack(Integer.parseInt(request.getParameter("attack")));
                    d.setDefense(Integer.parseInt(request.getParameter("defense")));

                    service.modify(d.getId(),d);
                    response.sendRedirect("/hoe/defensivebuildingupgrade/main");

                } catch (BusinessException e) {
                    request.setAttribute("message", "Unsuccessful modification.");
                    request.getRequestDispatcher("/defensivebuildingupgrade/error/error.jsp").forward(request, response);
                }

            }
    }

    private List<String> missingParameters(Map<String, String[]> params) {
        List<String> missingParams = new ArrayList<>();

        if (!params.containsKey("name") || params.get("name")[0] == null || params.get("name")[0].trim().isEmpty()) {
            missingParams.add("name");
        }
        if (!params.containsKey("hp") || !Utils.isNumber(params.get("hp")[0])) {
            missingParams.add("hp");
        }
        if (!params.containsKey("attack") || !Utils.isNumber(params.get("attack")[0])) {
            missingParams.add("attack");
        }
        if (!params.containsKey("defense") || !Utils.isNumber(params.get("defense")[0])) {
            missingParams.add("defense");
        }

        return missingParams;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.petlevel.controllers;

import hu.javagladiators.education.hoe.petlevel.dao.PetLevel;
import hu.javagladiators.education.hoe.petlevel.dao.PetLevelException;
import hu.javagladiators.education.hoe.petlevel.services.PetLevelResource;
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

@WebServlet(name = "Update", urlPatterns = {"/Update"})
public class Update extends HttpServlet {
    
    @Inject
    PetLevelResource resource;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (validateId(request.getParameterMap())) {
            try {
                PetLevel dbu = resource.getById(Long.parseLong(request.getParameter("id")));
                request.setAttribute("dbu", dbu);
                request.getRequestDispatcher("/petLevelEditor.jsp").forward(request, response);
            } catch (PetLevelException ex) {
                request.setAttribute("message", ex.getMessage());
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "Missing identifier.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (validateId(request.getParameterMap())) {
            if (!missingParameters(request.getParameterMap()).isEmpty()) {
                String errorMessage = "The following parameters are missing " + String.join(",", missingParameters(request.getParameterMap()));
                request.setAttribute("message", errorMessage);
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            } else {
                try {
                    PetLevel d = new PetLevel();
                    d.setId(Long.parseLong(request.getParameter("id")));
                    d.setLevelName(request.getParameter("levelName"));
                    d.setFromLevel(Integer.parseInt(request.getParameter("fromLevel")));
                    d.setUntilLevel(Integer.parseInt(request.getParameter("untilLevel")));

                    resource.update(d);
                    response.sendRedirect("/PetLevel");

                } catch (PetLevelException e) {
                    request.setAttribute("message", e.getMessage());
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }

            }
        } else {
            request.setAttribute("message", "Missing identifier.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }

    }

    private boolean validateId(Map<String, String[]> paramMap) {
        return paramMap.containsKey("id") && Utils.isNumber(paramMap.get("id")[0]);
    }

    private List<String> missingParameters(Map<String, String[]> params) {
        List<String> missingParams = new ArrayList<>();

        if (!params.containsKey("levelName") || params.get("levelName")[0] == null || params.get("levelName")[0].trim().isEmpty()) {
            missingParams.add("levelName");
        }
        if (!params.containsKey("fromLevel") || !Utils.isNumber(params.get("fromLevel")[0])) {
            missingParams.add("fromLevel");
        }
        if (!params.containsKey("untilLevel") || !Utils.isNumber(params.get("untilLevel")[0])) {
            missingParams.add("untilLevel");
        }

        return missingParams;
    }
}
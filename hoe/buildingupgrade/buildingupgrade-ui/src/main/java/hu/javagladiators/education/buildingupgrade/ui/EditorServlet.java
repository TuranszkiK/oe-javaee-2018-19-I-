/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.buildingupgrade.ui;

import hu.javagladiators.education.buildingupgrade.dto.BuildingUpgradeDto;
import hu.javagladiators.education.buildingupgrade.service.BuildingUpgradeService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mfrohlich
 */
@WebServlet(name="BuildingUpgradeEditorServlet", urlPatterns = {"/buildingupgrade"})
public class EditorServlet extends HttpServlet {
    private final static String AllBuildingUpgrades = "buildingupgrades";
    @Inject private BuildingUpgradeService bus;

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute(AllBuildingUpgrades, bus.getBuildingUpgrades());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameterMap().containsKey("delete"))
        {
            doDelete(req,resp);
            return;
        }
        
        if(req.getParameterMap().containsKey("update")){
            doPut(req,resp);
            return;
        }
        
        BuildingUpgradeDto upgrade = new BuildingUpgradeDto();
        upgrade.setCost(Long.parseLong(req.getParameter("newUpgradeCost")));
        upgrade.setName(req.getParameter("newUpgradeName"));
        upgrade.setDescription(req.getParameter("newUpgradeDescription"));
        upgrade.setBonusAttribute(req.getParameter("newUpgradeBonusAttribute"));
        upgrade.setBonusAttributeValue(Integer.parseInt(req.getParameter("newUpgradeBonusAttributeValue")));

        bus.addNew(upgrade);
        doGet(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        long id = Long.parseLong(req.getParameter("editUpgradeId"));
        String name = req.getParameter("editUpgradeName");
        String desc = req.getParameter("editUpgradeDescription");
        long cost = Long.parseLong(req.getParameter("editUpgradeCost"));
        String attr = req.getParameter("editUpgradeBonusAttribute");
        int attrVal = Integer.parseInt(req.getParameter("editUpgradeBonusAttributeValue"));
        
        BuildingUpgradeDto upgrade = new BuildingUpgradeDto();
        upgrade.setName(name);
        upgrade.setDescription(desc);
        upgrade.setCost(cost);
        upgrade.setBonusAttribute(attr);
        upgrade.setBonusAttributeValue(attrVal);
        
        bus.updateBuildingUpgrade(id, upgrade);
        doGet(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("deleteSelector"));
        System.out.println("ID:" + id);
        bus.deleteById(id);
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.getSession().setAttribute(AllBuildingUpgrades, bus.getBuildingUpgrades());
        getServletContext().getRequestDispatcher("/editor.jsp").include(req, resp);
    }
}


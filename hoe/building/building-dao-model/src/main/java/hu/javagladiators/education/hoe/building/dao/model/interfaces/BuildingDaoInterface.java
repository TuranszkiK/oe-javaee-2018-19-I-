/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.building.dao.model.interfaces;

import hu.javagladiators.education.hoe.building.dao.model.models.Building;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author Feco
 */
public interface BuildingDaoInterface {

    Building findBuilding(long id);
    
    Building findBuildingByName(String name) throws NoResultException;

    List<Building> getBuildings();

    void insertBuilding(Building building);

    void removeBuilding(Building building);

    void updateBuilding(Building building, String name, String desc);
    
}

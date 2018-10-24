/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.building.service;

import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.building.dao.model.interfaces.BuildingDaoInterface;
import hu.javagladiators.education.hoe.building.dao.model.models.Building;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 *
 * @author Feco
 */
@ApplicationScoped
public class BuildingServiceImpl {
    @Inject
    protected BuildingDaoInterface dao;
    
    private static final Logger log = Logger.getLogger("SpeciesDaoImpl");

    public List<Building> getAll() {return dao.getBuildings();}

    public Building getById(long pId) {return dao.findBuilding(pId);}

    public void create(Building pData) throws BusinessException {

        try {
            dao.findBuildingByName(pData.getName());
        } catch (NoResultException e) {
            dao.insertBuilding(pData);
        }
        throw new BusinessException();
    }

    public void modify(long pId, String name, String desc) throws BusinessException {
        try {
            dao.findBuildingByName(name);
        }
        catch(NoResultException e) {
            Building b  = dao.findBuilding(pId);
            if(name!=null && desc !=null){ 
                dao.updateBuilding(b, name, desc);
            }
        }
        throw new BusinessException();
    }

    public void delete(long pId) {
        try{
            Building b = dao.findBuilding(pId);
            dao.removeBuilding(b);
        }
        catch(NoResultException e){
            log.info("Nincs ilyen epulet. Id: " + pId);
        }
    }
}

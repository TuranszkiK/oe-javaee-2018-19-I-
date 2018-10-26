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

    public Building getById(long pId) {return dao.findBuildingById(pId);}

    public void create(Building pData) throws BusinessException {
        try {
            dao.findBuildingByName(pData.getName());
            throw new BusinessException();
        } catch (NoResultException e) {
            dao.insertBuilding(pData);
        }
    }

    public void tryModify(long pId, String name, String desc) throws BusinessException {
        try {
            Building nameMatching = dao.findBuildingByName(name);
            if (nameMatching.getId() == pId) {
                modify(pId, name, desc);
            } else {
                throw new BusinessException();
            }
        }
        catch(NoResultException e) {
            modify(pId, name, desc);
        }
    }
    
    private void modify(long pId, String name, String desc) {
        if(name!=null && desc !=null){ 
                Building b = new Building();
                b.setName(name);
                b.setDescription(desc);
                dao.updateBuilding(pId, b);
            }
    }

    public void delete(long pId) {
        try{
            dao.removeBuilding(pId);
        }
        catch(NoResultException e){
            log.info("Nincs ilyen epulet. Id: " + pId);
        }
    }
}

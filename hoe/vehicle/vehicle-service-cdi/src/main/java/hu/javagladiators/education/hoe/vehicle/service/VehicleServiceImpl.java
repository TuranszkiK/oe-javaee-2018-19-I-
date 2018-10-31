/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.vehicle.service;

import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.vehicle.dao.models.Vehicle;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

@ApplicationScoped
public class VehicleServiceImpl implements BaseService<Vehicle>{
    private static final Logger log = Logger.getLogger("VehicleServiceImpl");

    @Inject
    protected BaseDao<Vehicle> dao;

    public VehicleServiceImpl() {log.info("create new instance");}
   
    @Override
    public List<Vehicle> getAll() {return dao.getAll();}

    @Override
    public Vehicle getById(long pId) {return dao.getById(pId);}


    @Override
    public Vehicle create(Vehicle pData) throws BusinessException {
        try{dao.getByName(pData.getName());}
        catch(NoResultException e){return dao.create(pData);}
        throw new BusinessException();
    }

    @Override
    public Vehicle modify(long pId, Vehicle pData) throws BusinessException {
        try{
            dao.getByName(pData.getName());
            throw new BusinessException();
        }
        catch(NoResultException e){
            Vehicle vehicle = dao.getById(pId);
            if(pData.getName()!=null) vehicle.setName(pData.getName());
            if(pData.getDescription()!=null) vehicle.setDescription(pData.getDescription());
            return dao.modify(vehicle);
        }
    }

    @Override
    public Vehicle delete(long pId) {
        return dao.delete(pId);
    }
    
}

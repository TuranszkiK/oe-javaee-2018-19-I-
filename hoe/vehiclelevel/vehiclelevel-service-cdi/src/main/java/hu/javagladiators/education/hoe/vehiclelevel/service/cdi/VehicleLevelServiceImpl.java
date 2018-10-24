/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.vehiclelevel.service.cdi;

import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.vehiclelevel.dao.models.VehicleLevel;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 *
 * @author KTengely
 */
@ApplicationScoped
public class VehicleLevelServiceImpl implements BaseService<VehicleLevel> {
    private static final Logger log = Logger.getLogger("SpeciesDaoImpl");

    @Inject
    protected BaseDao<VehicleLevel> dao;

    public VehicleLevelServiceImpl() {log.info("create new instance");}
   
    @Override
    public List<VehicleLevel> getAll() {return dao.getAll();}

    @Override
    public VehicleLevel getById(long pId) {return dao.getById(pId);}


    @Override
    public VehicleLevel create(VehicleLevel pData) throws BusinessException {
        try{dao.getByName(pData.getName());}
        catch(NoResultException e){return dao.create(pData);}
        throw new BusinessException();
    }

    @Override
    public VehicleLevel modify(long pId, VehicleLevel pData) throws BusinessException {
        try{
            dao.getByName(pData.getName());
            throw new BusinessException();
        }
        catch(NoResultException e){
            VehicleLevel species = dao.getById(pId);
            if(pData.getName()!=null) species.setName(pData.getName());
            if(pData.getDesc()!=null) species.setDesc(pData.getDesc());
            return dao.modify(species);
        }
    }

    @Override
    public VehicleLevel delete(long pId) {
        return dao.delete(pId);
    }
    
}

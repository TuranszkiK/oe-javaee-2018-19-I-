package hu.javagladiators.education.hoe.vehicleaccessory.service;

import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.vehicleaccessory.dao.models.VehicleAccessory;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 * @author Boldi
 */
@ApplicationScoped
public class VehicleAccessoryServiceImpl implements BaseService<VehicleAccessory>{
    private static final Logger log = Logger.getLogger("VehicleAccessoryDaoImpl");

    @Inject
    protected BaseDao<VehicleAccessory> dao;

    public VehicleAccessoryServiceImpl() {log.info("create new instance");}
   
    @Override
    public List<VehicleAccessory> getAll() {return dao.getAll();}

    @Override
    public VehicleAccessory getById(long pId) {return dao.getById(pId);}


    @Override
    public VehicleAccessory create(VehicleAccessory pData) throws BusinessException {
        try{dao.getByName(pData.getName());}
        catch(NoResultException e){return dao.create(pData);}
        throw new BusinessException();
    }

    @Override
    public VehicleAccessory modify(long pId, VehicleAccessory pData) throws BusinessException {
        try{
            dao.getByName(pData.getName());
            throw new BusinessException();
        }
        catch(NoResultException e){
            VehicleAccessory species = dao.getById(pId);
            if(pData.getName()!=null) species.setName(pData.getName());
            if(pData.getDescription()!=null) species.setDescription(pData.getDescription());
            return dao.modify(species);
        }
    }

    @Override
    public VehicleAccessory delete(long pId) {
        return dao.delete(pId);
    }
    
}

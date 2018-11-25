package hu.javagladiators.education.hoe.defensivebuilding.service.cdi;

import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.defensivebuilding.dao.interfaces.DefensiveBuildingDao;
import hu.javagladiators.education.hoe.defensivebuilding.dao.models.DefensiveBuilding;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author nagym
 */
@ApplicationScoped
public class DefensiveBuildingServiceImpl implements BaseService<DefensiveBuilding>{

    private static final Logger log = Logger.getLogger("DefensiveBuildingServiceImpl");
    
    @Inject
    protected DefensiveBuildingDao dao;
    
    public DefensiveBuildingServiceImpl() {log.info("create new instance");}
    
    @Override
    public List<DefensiveBuilding> getAll() {
        return dao.getAll();
    }

    @Override
    public DefensiveBuilding getById(long pId) {
        return dao.getById(pId);
    }

    @Override
    public DefensiveBuilding create(DefensiveBuilding pData) throws BusinessException {
        //ToDo: Exception handling
        return dao.create(pData);
    }

    @Override
    public DefensiveBuilding modify(long pId, DefensiveBuilding pData) throws BusinessException {
        
        //ToDo: Exception handling
        //ToDo: use pId param
        return dao.modify(pData);
    }

    @Override
    public DefensiveBuilding delete(long pId) {
        //ToDo: Exception handling
        return dao.delete(pId);
    }
    
}

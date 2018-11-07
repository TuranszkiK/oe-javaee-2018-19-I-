package hu.javagladiators.education.hoe.empire.service;

import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.empire.dao.models.Empire;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 * @author krisztian
 */
@ApplicationScoped
public class EmpireServiceImpl implements BaseService<Empire>{
    private static final Logger log = Logger.getLogger("EmpireDaoImpl");

    @Inject
    protected BaseDao<Empire> dao;

    public EmpireServiceImpl() {log.info("create new instance");}
   
    @Override
    public List<Empire> getAll() {return dao.getAll();}

    @Override
    public Empire getById(long pId) {return dao.getById(pId);}


    @Override
    public Empire create(Empire pData) throws BusinessException {
        try{dao.getByName(pData.getName());}
        catch(NoResultException e){return dao.create(pData);}
        throw new BusinessException();
    }

    @Override
    public Empire modify(long pId, Empire pData) throws BusinessException {
        try{
            dao.getByName(pData.getName());
            throw new BusinessException();
        }
        catch(NoResultException e){
            Empire empire = dao.getById(pId);
            if(pData.getName()!=null) empire.setName(pData.getName());
            if(pData.getDescription()!=null) empire.setDescription(pData.getDescription());
            return dao.modify(empire);
        }
    }

    @Override
    public Empire delete(long pId) {
        return dao.delete(pId);
    }
    
}

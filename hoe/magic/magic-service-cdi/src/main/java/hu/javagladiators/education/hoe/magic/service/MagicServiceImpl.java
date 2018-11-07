package hu.javagladiators.education.hoe.magic.service;

import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.magic.dao.models.Magic;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 * @author Boldi
 */
@ApplicationScoped
public class MagicServiceImpl implements BaseService<Magic>{
    private static final Logger log = Logger.getLogger("MagicDaoImpl");

    @Inject
    protected BaseDao<Magic> dao;

    public MagicServiceImpl() {log.info("create new instance");}
   
    @Override
    public List<Magic> getAll() {return dao.getAll();}

    @Override
    public Magic getById(long pId) {return dao.getById(pId);}


    @Override
    public Magic create(Magic pData) throws BusinessException {
        try{dao.getByName(pData.getName());}
        catch(NoResultException e){return dao.create(pData);}
        throw new BusinessException();
    }

    @Override
    public Magic modify(long pId, Magic pData) throws BusinessException {
        try{
            dao.getByName(pData.getName());
            throw new BusinessException();
        }
        catch(NoResultException e){
            Magic magic = dao.getById(pId);
            if(pData.getName()!=null) magic.setName(pData.getName());
            if(pData.getDescription()!=null) magic.setDescription(pData.getDescription());
            return dao.modify(magic);
        }
    }

    @Override
    public Magic delete(long pId) {
        return dao.delete(pId);
    }
    
}

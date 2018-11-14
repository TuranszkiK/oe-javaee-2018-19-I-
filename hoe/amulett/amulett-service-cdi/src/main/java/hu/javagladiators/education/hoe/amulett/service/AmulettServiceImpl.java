package hu.javagladiators.education.hoe.amulett.service;

import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.amulett.dao.models.Amulett;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 *
 * @author kbitter
 */

@ApplicationScoped
public class AmulettServiceImpl  implements BaseService<Amulett> {
    
    private static final Logger log = Logger.getLogger("AmulettDaoImpl");

    @Inject
    protected BaseDao<Amulett> dao;

    public AmulettServiceImpl() {log.info("create new instance");}
   
    @Override
    public List<Amulett> getAll() {return dao.getAll();}

    @Override
    public Amulett getById(long pId) {return dao.getById(pId);}


    @Override
    public Amulett create(Amulett pData) throws BusinessException {
        try{dao.getByName(pData.getName());}
        catch(NoResultException e){return dao.create(pData);}
        throw new BusinessException();
    }

    @Override
    public Amulett modify(long pId, Amulett pData) throws BusinessException {
        try{
            dao.getByName(pData.getName());
            throw new BusinessException();
        }
        catch(NoResultException e){
            Amulett amulett = dao.getById(pId);
            if(pData.getName()!=null) amulett.setName(pData.getName());
            if(pData.getDescription()!=null) amulett.setDescription(pData.getDescription());
            return dao.modify(amulett);
        }
    }

    @Override
    public Amulett delete(long pId) {
        return dao.delete(pId);
    }
}

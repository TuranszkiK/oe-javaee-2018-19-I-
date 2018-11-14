/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.factorylevel.service.cdi;

import hu.javagladiators.education.factorylevel.dao.models.FactoryLevel;
import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 *
 * @author I341314
 */
@ApplicationScoped
public class FactoryLevelServiceImpl implements BaseService<FactoryLevel>{
    private static final Logger log = Logger.getLogger("FactoryLevelDaoImpl");

    @Inject
    protected BaseDao<FactoryLevel> dao;

    public FactoryLevelServiceImpl() {log.info("create new instance");}
   
    @Override
    public List<FactoryLevel> getAll() {return dao.getAll();}

    @Override
    public FactoryLevel getById(long pId) {return dao.getById(pId);}


    @Override
    public FactoryLevel create(FactoryLevel pData) throws BusinessException {
        try{dao.getByName(pData.getName());}
        catch(NoResultException e){return dao.create(pData);}
        throw new BusinessException();
    }

    @Override
    public FactoryLevel modify(long pId, FactoryLevel pData) throws BusinessException {
        try{
            dao.getByName(pData.getName());
            throw new BusinessException();
        }
        catch(NoResultException e){
            FactoryLevel fLevel = dao.getById(pId);
            if(pData.getName()!=null) fLevel.setName(pData.getName());
            if(pData.getDescription()!=null) fLevel.setDescription(pData.getDescription());
            return dao.modify(fLevel);
        }
    }

    @Override
    public FactoryLevel delete(long pId) {
        return dao.delete(pId);
    }
    
}

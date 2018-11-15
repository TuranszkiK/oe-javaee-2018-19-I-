package hu.javagladiators.education.hoe.profession.service;

import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.profession.dao.models.Profession;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 * @author krisztian
 */
@ApplicationScoped
public class ProfessionServiceImpl implements BaseService<Profession>{
    private static final Logger log = Logger.getLogger("ProfessionDaoImpl");

    @Inject
    protected BaseDao<Profession> dao;

    public ProfessionServiceImpl() {log.info("create new instance");}
   
    @Override
    public List<Profession> getAll() {return dao.getAll();}

    @Override
    public Profession getById(long pId) {return dao.getById(pId);}


    @Override
    public Profession create(Profession pData) throws BusinessException {
        try{dao.getByName(pData.getName());}
        catch(NoResultException e){return dao.create(pData);}
        throw new BusinessException();
    }

    @Override
    public Profession modify(long pId, Profession pData) throws BusinessException {
        try{
            dao.getByName(pData.getName());
            throw new BusinessException();
        }
        catch(NoResultException e){
            Profession prof = dao.getById(pId);
            if(pData.getName()!=null) prof.setName(pData.getName());
            if(pData.getDescription()!=null) prof.setDescription(pData.getDescription());
            return dao.modify(prof);
        }
    }

    @Override
    public Profession delete(long pId) {
        return dao.delete(pId);
    }
    
}

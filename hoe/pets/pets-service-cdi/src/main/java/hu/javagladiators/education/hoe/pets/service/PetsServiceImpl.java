package hu.javagladiators.education.hoe.pets.service;

import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.pets.dao.models.Pets;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

@ApplicationScoped
public class PetsServiceImpl implements BaseService<Pets>{
    private static final Logger log = Logger.getLogger("SpeciesDaoImpl");

    @Inject
    protected BaseDao<Pets> dao;

    public PetsServiceImpl() {log.info("create new instance");}
   
    @Override
    public List<Pets> getAll() {return dao.getAll();}

    @Override
    public Pets getById(long pId) {return dao.getById(pId);}


    @Override
    public Pets create(Pets pData) throws BusinessException {
        try{dao.getByName(pData.getName());}
        catch(NoResultException e){return dao.create(pData);}
        throw new BusinessException();
    }

    @Override
    public Pets modify(long pId, Pets pData) throws BusinessException {
        try{
            dao.getByName(pData.getName());
            throw new BusinessException();
        }
        catch(NoResultException e){
            Pets pets = dao.getById(pId);
            if(pData.getName()!=null) pets.setName(pData.getName());
            if(pData.getType()!=null) pets.setType(pData.getType());
            if(pData.getStrength()!=null) pets.setStrength(pData.getStrength());
            return dao.modify(pets);
        }
    }

    @Override
    public Pets delete(long pId) {
        return dao.delete(pId);
    }
    
}

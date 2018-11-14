package hu.javagladiators.education.hoe.bonusattributes.service;

import hu.javagladiators.education.hoe.bonusattributes.dao.models.BonusAttributes;
import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

@ApplicationScoped
public class BonusAttributesServiceImpl implements BaseService<BonusAttributes>{
    private static final Logger log = Logger.getLogger("BonusAttributesDaoImpl");

    @Inject
    protected BaseDao<BonusAttributes> dao;

    public BonusAttributesServiceImpl() {log.info("create new instance");}
   
    @Override
    public List<BonusAttributes> getAll() {return dao.getAll();}

    @Override
    public BonusAttributes getById(long pId) {return dao.getById(pId);}


    @Override
    public BonusAttributes create(BonusAttributes pData) throws BusinessException {
        try{dao.getByName(pData.getName());}
        catch(NoResultException e){return dao.create(pData);}
        throw new BusinessException();
    }

    @Override
    public BonusAttributes modify(long pId, BonusAttributes pData) throws BusinessException {
        try{
            dao.getByName(pData.getName());
            throw new BusinessException();
        }
        catch(NoResultException e){
            BonusAttributes bonusattributes = dao.getById(pId);
            if(pData.getName()!=null) bonusattributes.setName(pData.getName());
            if(pData.getDescription()!=null) bonusattributes.setDescription(pData.getDescription());
            return dao.modify(bonusattributes);
        }
    }

    @Override
    public BonusAttributes delete(long pId) {
        return dao.delete(pId);
    }
    
}

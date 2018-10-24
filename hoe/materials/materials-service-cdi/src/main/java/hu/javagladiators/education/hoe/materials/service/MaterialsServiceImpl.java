/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.materials.service;

import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.materials.dao.models.Materials;
import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 *
 * @author krisztian
 */
@ApplicationScoped
public class MaterialsServiceImpl implements BaseService<Materials>{
    private static final Logger log = Logger.getLogger("MaterialsDaoImpl");

    @Inject
    protected BaseDao<Materials> dao;

    public MaterialsServiceImpl() {log.info("create new instance");}
   
    @Override
    public List<Materials> getAll() {return dao.getAll();}

    @Override
    public Materials getById(long pId) {return dao.getById(pId);}


    @Override
    public Materials create(Materials pData) throws BusinessException {
        try{dao.getByName(pData.getName());}
        catch(NoResultException e){return dao.create(pData);}
        throw new BusinessException();
    }

    @Override
    public Materials modify(long pId, Materials pData) throws BusinessException {
        try{
            dao.getByName(pData.getName());
            throw new BusinessException();
        }
        catch(NoResultException e){
            Materials materials = dao.getById(pId);
            if(pData.getName()!=null) materials.setName(pData.getName());
            if(pData.getDescription()!=null) materials.setDescription(pData.getDescription());
            return dao.modify(materials);
        }
    }

    @Override
    public Materials delete(long pId) {
        return dao.delete(pId);
    }
    
}

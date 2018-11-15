/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.empirelevel.service.cdi;

import hu.javagladiators.education.empirelevel.dao.models.EmpireLevel;
import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

@ApplicationScoped
public class EmpireLevelServiceImpl implements BaseService<EmpireLevel>{
    private static final Logger log = Logger.getLogger("SpeciesDaoImpl");

    @Inject
    protected BaseDao<EmpireLevel> dao;

    public EmpireLevelServiceImpl() {log.info("create new instance");}
   
    @Override
    public List<EmpireLevel> getAll() {return dao.getAll();}

    @Override
    public EmpireLevel getById(long pId) {return dao.getById(pId);}


    @Override
    public EmpireLevel create(EmpireLevel pData) throws BusinessException {
        try{dao.getByName(pData.getName());}
        catch(NoResultException e){return dao.create(pData);}
        throw new BusinessException();
    }

    @Override
    public EmpireLevel modify(long pId, EmpireLevel pData) throws BusinessException {
        try{
            dao.getByName(pData.getName());
            throw new BusinessException();
        }
        catch(NoResultException e){
            EmpireLevel empireLevel = dao.getById(pId);
            if(pData.getName()!=null) empireLevel.setName(pData.getName());
            if(pData.getDesc()!=null) empireLevel.setDesc(pData.getDesc());
            return dao.modify(empireLevel);
        }
    }

    @Override
    public EmpireLevel delete(long pId) {
        return dao.delete(pId);
    }
}

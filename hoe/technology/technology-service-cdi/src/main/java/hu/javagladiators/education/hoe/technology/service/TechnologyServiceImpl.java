/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.technology.service;

import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.technology.dao.interfaces.TechnologyDao;
import hu.javagladiators.education.hoe.technology.dao.models.Technology;
import hu.javagladiators.education.hoe.technology.service.exception.TechnologyServiceException;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author krisztian
 */
@ApplicationScoped
public class TechnologyServiceImpl implements BaseService<Technology>{

    @Inject
    private TechnologyDao technologyDao;
    
    @Override
    public List<Technology> getAll() {
        return technologyDao.listTechnologies();
    }

    @Override
    public Technology getById(long pId) {
        try{
            return technologyDao.getById(pId);
        } catch(Exception e) {
            throw new TechnologyServiceException(e.getMessage());
        }
    }

    @Override
    public Technology create(Technology pData) throws BusinessException {
        try {
            return technologyDao.createTechnology(pData);
        } catch (Exception e) {
            throw new TechnologyServiceException(e.getMessage());
        }
    }

    @Override
    public Technology modify(long pId, Technology pData) throws BusinessException {
        try {
            return technologyDao.updateTechnology(pId, pData);
        } catch (Exception e) {
            throw new TechnologyServiceException(e.getMessage());
        }
    }

    
    public void deleteTechnology(long pId) {
        try {
            technologyDao.deleteTechnology(pId);
        } catch (Exception e) {
            throw new TechnologyServiceException(e.getMessage());
        }
    }

    @Override
    public Technology delete(long pId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

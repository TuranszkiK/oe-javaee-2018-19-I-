/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.guild.service;

import hu.javagladiators.education.guild.dao.models.Guild;
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
 * @author krisztian
 */
@ApplicationScoped
public class GuildServiceImpl implements BaseService<Guild>{
     private static final Logger log = Logger.getLogger("GuildDaoImpl");

    @Inject
    protected BaseDao<Guild> dao;

    public GuildServiceImpl() {log.info("create new instance");}
   
    @Override
    public List<Guild> getAll() {return dao.getAll();}

    @Override
    public Guild getById(long pId) {return dao.getById(pId);}


    @Override
    public Guild create(Guild pData) throws BusinessException {
        try{dao.getByName(pData.getName());}
        catch(NoResultException e){return dao.create(pData);}
        throw new BusinessException();
    }

    @Override
    public Guild modify(long pId, Guild pData) throws BusinessException {
        try{
            dao.getByName(pData.getName());
            throw new BusinessException();
        }
        catch(NoResultException e){
            Guild guild = dao.getById(pId);
            if(pData.getName()!=null) guild.setName(pData.getName());
            if(pData.getDescription()!=null) guild.setDescription(pData.getDescription());
            return dao.modify(guild);
        }
    }

    @Override
    public Guild delete(long pId) {
        return dao.delete(pId);
    }
    
}

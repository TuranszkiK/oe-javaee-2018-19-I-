/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.species.dao;

import hu.javagladiators.education.hoe.technology.dao.interfaces.TechnologyDao;
import hu.javagladiators.education.hoe.technology.dao.models.Technology;
import hu.javagladiators.education.hoe.technology.dao.utils.QueryUtils;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author krisztian
 */
@RequestScoped
public class TechnologyDaoImpl implements TechnologyDao {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("hoe").createEntityManager();
    
    @Override
    public List<Technology> listTechnologies() {
                return entityManager.createNamedQuery(QueryUtils.TECHNOLOGY_LIST_ALL, Technology.class)
                .getResultList();
    }

    @Override
    public Technology getById(long pId) {
        return entityManager.createNamedQuery(QueryUtils.TECHNOLOGY_FIND_BY_ID, Technology.class)
                .setParameter("id", pId).getSingleResult();
    }

    @Override
    public Technology createTechnology(Technology pData) {
        entityManager.getTransaction().begin();
        entityManager.persist(pData);
        entityManager.getTransaction().commit();
        return pData;
    }

    @Override
    public Technology updateTechnology(long pId, Technology pData) {
        Technology updatedTechnology = updateTechnologyEntity(pId, pData);
        entityManager.getTransaction().begin();
        entityManager.merge(updatedTechnology);
        entityManager.getTransaction().commit();
        return updatedTechnology;
    }
    
    
    private Technology updateTechnologyEntity(long pId, Technology technology) {
        Technology updatedTechnology = entityManager
                .createNamedQuery(QueryUtils.TECHNOLOGY_FIND_BY_ID, Technology.class)
                .setParameter("id", pId).getSingleResult();
        updatedTechnology.setDescription(technology.getDescription());
        updatedTechnology.setEmpireLevel(technology.getEmpireLevel());
        updatedTechnology.setName(technology.getName());
        return updatedTechnology;
    }

    @Override
    public void deleteTechnology(long pId) {
        entityManager.getTransaction().begin();
        entityManager.createNamedQuery(QueryUtils.TECHNOLOGY_DELETE_BY_ID).setParameter("id", pId).executeUpdate();
        entityManager.getTransaction().commit();
    }

}

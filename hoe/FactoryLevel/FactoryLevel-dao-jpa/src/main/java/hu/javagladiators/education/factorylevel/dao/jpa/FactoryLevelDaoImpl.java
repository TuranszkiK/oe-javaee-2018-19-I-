/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.factorylevel.dao.jpa;

import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.factorylevel.dao.interfaces.FactoryLevelDaoInterface;
import hu.javagladiators.education.factorylevel.dao.models.FactoryLevel;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
/**
 *
 * @author I341314
 */
@RequestScoped
public class FactoryLevelDaoImpl implements BaseDao<FactoryLevel>{
    private static final Logger log = Logger.getLogger("FactoryLevelDaoImpl");

    private EntityManager em = Persistence.createEntityManagerFactory("hoe").createEntityManager();

    public FactoryLevelDaoImpl() {log.info("create new instance");}

    
    
    @Override
    public List<FactoryLevel> getAll() {
        return em.createNamedQuery("FactoryLevel.all").getResultList();
    }

    @Override
    public FactoryLevel getById(long pId) {
        return em.find(FactoryLevel.class, pId);
    }

    @Override
    public FactoryLevel getByName(String pName) {
        return em.createNamedQuery("FactoryLevel.name",FactoryLevel.class)
                .setParameter("name", pName)
                .getSingleResult();
    }

    @Override
    public FactoryLevel create(FactoryLevel pData) {
        em.getTransaction().begin();
        em.persist(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public FactoryLevel modify(FactoryLevel pData) {
        em.getTransaction().begin();
        em.merge(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public FactoryLevel delete(long pId) {
        FactoryLevel species = getById(pId);
        em.getTransaction().begin();
        em.remove(species);
        em.getTransaction().commit();
        return species;
    }
    
}

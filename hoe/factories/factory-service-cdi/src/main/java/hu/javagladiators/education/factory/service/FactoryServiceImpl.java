/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.factory.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import hu.javagladiators.education.factory.dao.models.Factory;
import hu.javagladiators.education.factory.dao.interfaces.FactoryService;

/**
 *
 * @author Lóci
 */
@ApplicationScoped
public class FactoryServiceImpl implements FactoryService{
    
    private EntityManager  em;
    
    @PostConstruct
    private void init() {
        em = javax.persistence.Persistence.createEntityManagerFactory("blabla").createEntityManager();
    }
    
    @Override
    public List<Factory> getSystemFactories() {
        List<Factory> all_factories = em.createQuery("SELECT a FROM Factory a", Factory.class).getResultList();
        return all_factories;
    }

    @Override
    public void insertFactory(Factory fact) {
        em.getTransaction().begin();
        em.persist(fact);
        em.getTransaction().commit();
    }

    @Override
    public void removeFactory(Factory fact) {
        em.getTransaction().begin();
        em.remove(fact);
        em.getTransaction().commit();
    }

    @Override
    public Factory findFactory(long id) {
        return em.find(Factory.class, id);
    }

    @Override
    public void modifyFactory(Factory f) {
        em.getTransaction().begin();
        em.merge(f);
        em.getTransaction().commit();
    }
    
}

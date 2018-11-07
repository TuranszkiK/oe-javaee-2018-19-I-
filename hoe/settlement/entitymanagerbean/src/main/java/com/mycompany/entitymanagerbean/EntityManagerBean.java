/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entitymanagerbean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author krisztian
 */
@Named(value = "entityManagerBean")
@ApplicationScoped
public class EntityManagerBean {

    EntityManagerFactory emf;
    EntityManager em;
    
    /**
     * Creates a new instance of EntityManagerBean
     */
    public EntityManagerBean() {
            emf = Persistence.createEntityManagerFactory("settlement");
            em = emf.createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }
    
    
    
}

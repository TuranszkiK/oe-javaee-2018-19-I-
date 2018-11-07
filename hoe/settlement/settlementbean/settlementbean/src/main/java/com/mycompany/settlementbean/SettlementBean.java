/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.settlementbean;

import datamodel.Settlement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Tata
 */
@Named(value = "settlementBean")
@RequestScoped
public class SettlementBean implements SettlementDao {

    private Settlement currentSettlement = new Settlement();
    //EntityManagerFactory emf = Persistence.createEntityManagerFactory("settlement");
    //EntityManager em = emf.createEntityManager();
    @Inject
    EntityManagerBean entitymanagerbean;
    
    
    /**
     * Creates a new instance of SettlementBean
     */
    public SettlementBean() {
        entitymanagerbean = new EntityManagerBean();
    }

    @Override
    public Settlement getCurrentSettlement() {
        return currentSettlement;
    }
    
    @Override
    public Settlement getbyId(long id) throws Exception
    {
        currentSettlement = entitymanagerbean.getEm().find(Settlement.class, id);
        if(currentSettlement==null)
        {
            throw new Exception("Not a good ID: "+id);
        }
        return currentSettlement;
    }
    
    @Override
    public void saveSettlement(Settlement newsett)
    {
        entitymanagerbean.getEm().getTransaction().begin();
        entitymanagerbean.getEm().persist(newsett);
        entitymanagerbean.getEm().getTransaction().commit();
    }
    
    @Override
    public void deleteSettlement(Settlement sett)
    {
        entitymanagerbean.getEm().getTransaction().begin();
        entitymanagerbean.getEm().remove(sett);
        entitymanagerbean.getEm().getTransaction().commit();
    }
    
    
    
}

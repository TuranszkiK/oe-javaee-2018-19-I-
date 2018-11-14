/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.endowment.dao.jpa;

import hu.javagladiators.education.endowment.dao.model.Endowment;
import hu.javagladiators.education.endowment.dao.model.EndowmentDao;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author krisztian
 */
@RequestScoped
public class EndowmentDaoImpl implements EndowmentDao{
    private static final Logger log = Logger.getLogger("EndowmentDaoImpl");

    private EntityManager em = Persistence.createEntityManagerFactory("hoe").createEntityManager();

    public EndowmentDaoImpl() {log.info("create new instance");}

    @Override
    public Endowment create(Endowment pEndowment) {
        em.getTransaction().begin();
        em.persist(pEndowment);
        em.getTransaction().commit();
        return pEndowment;
    }
    
    @Override
    public Endowment getByType(String pType){
        return em.createNamedQuery("Endowment.type", Endowment.class)
            .setParameter("type", pType)
            .getSingleResult();
    }
}

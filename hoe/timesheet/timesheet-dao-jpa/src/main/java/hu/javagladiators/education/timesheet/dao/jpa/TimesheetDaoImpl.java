/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.timesheet.dao.jpa;

import hu.javagladiators.education.timesheet.dao.model.Timesheet;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author xpowerfullx
 */
public class TimesheetDaoImpl implements TimesheetDao{

    private static final Logger log = Logger.getLogger("TimesheetDaoImpl");

    private EntityManager em = Persistence.createEntityManagerFactory("hoe").createEntityManager();

    public TimesheetDaoImpl(){
    log.info("create new instance");
    }
    
    @Override
    public List<Timesheet> getAll() {
        return em.createNamedQuery("timesheet.all").getResultList();
    }

    @Override
    public Timesheet getById(long pId) {
        return em.find(Timesheet.class, pId);
    }

    @Override
    public Timesheet create(Timesheet pData) {
        em.getTransaction().begin();
        em.persist(pData);
        em.getTransaction().commit();
        return pData;    
    }

    @Override
    public Timesheet modify(long pId, Timesheet pData) {
        em.getTransaction().begin();
        em.merge(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public Timesheet delete(long pId) {
        Timesheet timesheet = getById(pId);
        em.getTransaction().begin();
        em.remove(timesheet);
        em.getTransaction().commit();
        return timesheet;
    }

    @Override
    public long getNextId() {
       return em.createNamedQuery("timesheet.nextId").getFirstResult();
    }
}

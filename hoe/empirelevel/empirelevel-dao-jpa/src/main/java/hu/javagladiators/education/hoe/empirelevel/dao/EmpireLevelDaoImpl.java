/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.empirelevel.dao;

import hu.javagladiators.education.empirelevel.dao.models.EmpireLevel;
import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@RequestScoped
public class EmpireLevelDaoImpl implements BaseDao<EmpireLevel>{
    private static final Logger log = Logger.getLogger("VehicleLevelDaoImpl");

    private EntityManager em = Persistence.createEntityManagerFactory("hoe").createEntityManager();

    public EmpireLevelDaoImpl() {log.info("create new instance");}

    
    
    @Override
    public List<EmpireLevel> getAll() {
        return em.createNamedQuery("EmpireLevel.all").getResultList();
    }

    @Override
    public EmpireLevel getById(long pId) {
        return em.find(EmpireLevel.class, pId);
    }

    @Override
    public EmpireLevel getByName(String pName) {
        return em.createNamedQuery("EmpireLevel.name",EmpireLevel.class)
                .setParameter("name", pName)
                .getSingleResult();
    }

    @Override
    public EmpireLevel create(EmpireLevel pData) {
        em.getTransaction().begin();
        em.persist(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public EmpireLevel modify(EmpireLevel pData) {
        em.getTransaction().begin();
        em.merge(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public EmpireLevel delete(long pId) {
        EmpireLevel empireLevel = getById(pId);
        em.getTransaction().begin();
        em.remove(empireLevel);
        em.getTransaction().commit();
        return empireLevel;
    }
}

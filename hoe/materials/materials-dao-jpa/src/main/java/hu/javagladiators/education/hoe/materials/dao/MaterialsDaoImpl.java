/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.materials.dao;

import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.materials.dao.models.Materials;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Roltown
 */
@RequestScoped
public class MaterialsDaoImpl implements BaseDao<Materials>{
    private static final Logger log = Logger.getLogger("MaterialsDaoImpl");

    private EntityManager em = Persistence.createEntityManagerFactory("hoe").createEntityManager();

    public MaterialsDaoImpl() {log.info("create new instance");}

    
    
    @Override
    public List<Materials> getAll() {
        return em.createNamedQuery("Materials.all").getResultList();
    }

    @Override
    public Materials getById(long pId) {
        return em.find(Materials.class, pId);
    }

    @Override
    public Materials getByName(String pName) {
        return em.createNamedQuery("Materials.name",Materials.class)
                .setParameter("name", pName)
                .getSingleResult();
    }

    @Override
    public Materials create(Materials pData) {
        em.getTransaction().begin();
        em.persist(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public Materials modify(Materials pData) {
        em.getTransaction().begin();
        em.merge(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public Materials delete(long pId) {
        Materials materials = getById(pId);
        em.getTransaction().begin();
        em.remove(materials);
        em.getTransaction().commit();
        return materials;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.vehiclelevel.dao;
import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.vehiclelevel.dao.interfaces.VehicleLevelDao;
import hu.javagladiators.education.hoe.vehiclelevel.dao.models.VehicleLevel;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author KTengely
 */
@RequestScoped
public class VehicleLevelDaoImpl implements BaseDao<VehicleLevel>{
    private static final Logger log = Logger.getLogger("VehicleLevelDaoImpl");

    private EntityManager em = Persistence.createEntityManagerFactory("hoe").createEntityManager();

    public VehicleLevelDaoImpl() {log.info("create new instance");}

    
    
    @Override
    public List<VehicleLevel> getAll() {
        return em.createNamedQuery("VehicleLevel.all").getResultList();
    }

    @Override
    public VehicleLevel getById(long pId) {
        return em.find(VehicleLevel.class, pId);
    }

    @Override
    public VehicleLevel getByName(String pName) {
        return em.createNamedQuery("VehicleLevel.name",VehicleLevel.class)
                .setParameter("name", pName)
                .getSingleResult();
    }

    @Override
    public VehicleLevel create(VehicleLevel pData) {
        em.getTransaction().begin();
        em.persist(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public VehicleLevel modify(VehicleLevel pData) {
        em.getTransaction().begin();
        em.merge(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public VehicleLevel delete(long pId) {
        VehicleLevel species = getById(pId);
        em.getTransaction().begin();
        em.remove(species);
        em.getTransaction().commit();
        return species;
    }
}

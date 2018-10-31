/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.vehicle.dao;

import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.vehicle.dao.models.Vehicle;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@RequestScoped
public class VehicleDaoImpl implements BaseDao<Vehicle>{
    private static final Logger log = Logger.getLogger("VehicleDaoImpl");

    private EntityManager em = Persistence.createEntityManagerFactory("hoe").createEntityManager();

    public VehicleDaoImpl() {log.info("create new instance");}

    
    
    @Override
    public List<Vehicle> getAll() {
        return em.createNamedQuery("Vehicle.all").getResultList();
    }

    @Override
    public Vehicle getById(long pId) {
        return em.find(Vehicle.class, pId);
    }

    @Override
    public Vehicle getByName(String pName) {
        return em.createNamedQuery("Vehicle.name",Vehicle.class)
                .setParameter("name", pName)
                .getSingleResult();
    }

    @Override
    public Vehicle create(Vehicle pData) {
        em.getTransaction().begin();
        em.persist(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public Vehicle modify(Vehicle pData) {
        em.getTransaction().begin();
        em.merge(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public Vehicle delete(long pId) {
        Vehicle vehicle = getById(pId);
        em.getTransaction().begin();
        em.remove(vehicle);
        em.getTransaction().commit();
        return vehicle;
    }
    
}

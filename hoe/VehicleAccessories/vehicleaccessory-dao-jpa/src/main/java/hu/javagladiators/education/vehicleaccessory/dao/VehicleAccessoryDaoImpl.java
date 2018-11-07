package hu.javagladiators.education.vehicleaccessory.dao;

import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.vehicleaccessory.dao.models.VehicleAccessory;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import hu.javagladiators.education.hoe.vehicleaccessory.dao.interfaces.VehicleAccessoryDao;

/**
 * @author Boldi
 */
@RequestScoped
public class VehicleAccessoryDaoImpl implements BaseDao<VehicleAccessory>{
    private static final Logger log = Logger.getLogger("VehicleAccessoryDaoImpl");

    private EntityManager em = Persistence.createEntityManagerFactory("hoe").createEntityManager();

    public VehicleAccessoryDaoImpl() {log.info("create new instance");}

    
    
    @Override
    public List<VehicleAccessory> getAll() {
        return em.createNamedQuery("VehicleAccessory.all").getResultList();
    }

    @Override
    public VehicleAccessory getById(long pId) {
        return em.find(VehicleAccessory.class, pId);
    }

    @Override
    public VehicleAccessory getByName(String pName) {
        return em.createNamedQuery("VehicleAccessory.name",VehicleAccessory.class)
                .setParameter("name", pName)
                .getSingleResult();
    }

    @Override
    public VehicleAccessory create(VehicleAccessory pData) {
        em.getTransaction().begin();
        em.persist(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public VehicleAccessory modify(VehicleAccessory pData) {
        em.getTransaction().begin();
        em.merge(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public VehicleAccessory delete(long pId) {
        VehicleAccessory vehicleaccessory = getById(pId);
        em.getTransaction().begin();
        em.remove(vehicleaccessory);
        em.getTransaction().commit();
        return vehicleaccessory;
    }
    
}

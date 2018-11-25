package hu.javagladiators.education.hoe.defensivebuilding.dao.jpa;

import hu.javagladiators.education.hoe.defensivebuilding.dao.interfaces.DefensiveBuildingDao;
import hu.javagladiators.education.hoe.defensivebuilding.dao.models.DefensiveBuilding;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author nagym
 */
@RequestScoped
public class DefensiveBuildingDaoImpl implements DefensiveBuildingDao{

    private static final Logger log = Logger.getLogger("DefensiveBuildingDaoImpl");
    
    private EntityManager em = Persistence.createEntityManagerFactory("hoe").createEntityManager();
    
    public DefensiveBuildingDaoImpl() {log.info("create new instance");}
    
    @Override
    public List<DefensiveBuilding> getAll() {
        return em.createNamedQuery("DefensiveBuildings.all").getResultList();
    }

    @Override
    public DefensiveBuilding getById(long pId) {
        return em.find(DefensiveBuilding.class, pId);
    }

    @Override
    public DefensiveBuilding create(DefensiveBuilding pData) {
        em.getTransaction().begin();
        em.persist(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public DefensiveBuilding modify(DefensiveBuilding pData) {
        em.getTransaction().begin();
        em.merge(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public DefensiveBuilding delete(long pId) {
        DefensiveBuilding defBuilding = getById(pId);
        em.getTransaction().begin();
        em.remove(defBuilding);
        em.getTransaction().commit();
        return defBuilding;
    }
    
}

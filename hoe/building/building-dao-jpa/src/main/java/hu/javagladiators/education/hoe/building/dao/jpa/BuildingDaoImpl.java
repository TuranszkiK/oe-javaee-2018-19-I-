package hu.javagladiators.education.hoe.building.dao.jpa;

import hu.javagladiators.education.hoe.building.dao.model.interfaces.BuildingDaoInterface;
import hu.javagladiators.education.hoe.building.dao.model.models.Building;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


/**
 *
 * @author krisztian
 */
@ApplicationScoped
public class BuildingDaoImpl implements BuildingDaoInterface {
    
    private EntityManager em;
    
    @PostConstruct
    private void init() {
        em = Persistence.createEntityManagerFactory("bikmakk").createEntityManager();
    }    
      
    @Override
    public List<Building> getBuildings(){
        List<Building> res = em.createQuery("SELECT a FROM Building a").getResultList();
        return res;
    }
    
    @Override
    public Building findBuilding(long id) {
        return em.find(Building.class, id);
    }
    
    @Override
    public void insertBuilding(Building building) {
        em.getTransaction().begin();
        em.persist(building);
        em.getTransaction().commit();
    }
    
    @Override
    public void updateBuilding(Building building, String name, String desc) {
        building.setName(name);
        building.setDescription(desc);
        
        em.getTransaction().begin();
        em.merge(building);
        em.getTransaction().commit();
    }
    
    @Override
    public void removeBuilding(Building building) {
        em.getTransaction().begin();   
        em.remove(building);
        em.getTransaction().commit();
    }

    @Override
    public Building findBuildingByName(String name) {
        return em.createNamedQuery("Building.name",Building.class)
                .setParameter("name", name)
                .getSingleResult();
    }
    
}

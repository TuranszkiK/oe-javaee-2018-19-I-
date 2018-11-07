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
        em = Persistence.createEntityManagerFactory("hoe").createEntityManager();
    }    
      
    @Override
    public List<Building> getBuildings(){
        List<Building> res = em.createQuery("SELECT a FROM Building a").getResultList();
        return res;
    }
    
    @Override
    public Building findBuildingById(long id) {
        return em.find(Building.class, id);
    }
    
    @Override
    public void insertBuilding(Building building) {
        em.getTransaction().begin();
        em.persist(building);
        em.getTransaction().commit();
    }
    
    @Override
    public void updateBuilding(long id, Building modifiedBuildingData) {
        Building b = findBuildingById(id);
        b.setName(modifiedBuildingData.getName());
        b.setDescription(modifiedBuildingData.getDescription());
        
        em.getTransaction().begin();
        em.merge(b);
        em.getTransaction().commit();
    }
    
    @Override
    public void removeBuilding(long id) {
        Building b = findBuildingById(id);
        
        em.getTransaction().begin();   
        em.remove(b);
        em.getTransaction().commit();
    }

    @Override
    public Building findBuildingByName(String name) {
        return em.createQuery("SELECT b from Building b where b.name = :name", Building.class)
                .setParameter("name", name)
                .getSingleResult();
    }
    
}

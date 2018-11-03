package hu.javagladiators.education.hoe.defensivebuildingupgrade.dao;

import hu.javagladiators.education.hoe.defensivebuildingupgrade.dao.interfaces.IDefensiveBuildingUpgradeDAO;
import hu.javagladiators.education.hoe.defensivebuildingupgrade.model.DefensiveBuildingUpgrade;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@RequestScoped
public class DefensiveBuildingUpgradeDAO implements IDefensiveBuildingUpgradeDAO {
    
    EntityManager em;

    public DefensiveBuildingUpgradeDAO() {
        this.em = Persistence.createEntityManagerFactory("hoe").createEntityManager();
    }
    
    @Override
    public DefensiveBuildingUpgrade create(DefensiveBuildingUpgrade d) {
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
        
        return d;
    }

    @Override
    public List<DefensiveBuildingUpgrade> getAll() {
        return em.createQuery("SELECT d FROM DefensiveBuildingUpgrade d").getResultList();
    }

    @Override
    public DefensiveBuildingUpgrade getById(long id) {
        return (DefensiveBuildingUpgrade) em.createQuery("SELECT d FROM DefensiveBuildingUpgrade d WHERE d.id="+id).getSingleResult();
    }

    @Override
    public DefensiveBuildingUpgrade update(DefensiveBuildingUpgrade d) {
        em.getTransaction().begin();
        em.merge(d);
        em.getTransaction().commit();
        
        return d;
    }

    @Override
    public void delete(long id) {
        DefensiveBuildingUpgrade d = getById(id);
        em.getTransaction().begin();
        em.remove(d);
        em.getTransaction().commit();
    }
    
}

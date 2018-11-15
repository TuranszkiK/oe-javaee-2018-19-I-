package hu.javagladiators.education.hoe.petlevel.jpa;

import hu.javagladiators.education.hoe.petlevel.dao.PetLevel;
import hu.javagladiators.education.hoe.petlevel.dao.PetLevelDAO;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@RequestScoped
public class PetLevelImpl implements PetLevelDAO {

    EntityManager em;
    
    public PetLevelImpl(){
        this.em = Persistence.createEntityManagerFactory("hoe").createEntityManager();
    }
    
    @Override
    public PetLevel create(PetLevel d) {
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
        
        return d;
    }

    @Override
    public List<PetLevel> getAll() {
        return em.createQuery("SELECT d FROM PetLevel d").getResultList();
    }

    @Override
    public PetLevel getById(long id) {
        return (PetLevel) em.createQuery("SELECT d FROM PetLevel d WHERE d.id="+id).getSingleResult();
    }

    @Override
    public PetLevel update(PetLevel d) {
        em.getTransaction().begin();
        em.merge(d);
        em.getTransaction().commit();
        
        return d;
    }

    @Override
    public void delete(long id) {
        PetLevel d = getById(id);
        em.getTransaction().begin();
        em.remove(d);
        em.getTransaction().commit();
    }
    
}
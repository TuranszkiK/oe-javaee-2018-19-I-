package hu.javagladiators.education.hoe.pets.dao;

import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.pets.dao.interfaces.PetsDao;
import hu.javagladiators.education.hoe.pets.dao.models.Pets;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@RequestScoped
public class PetsDaoImpl implements BaseDao<Pets>{
    private static final Logger log = Logger.getLogger("SpeciesDaoImpl");

    private EntityManager em = Persistence.createEntityManagerFactory("hoe").createEntityManager();

    public PetsDaoImpl() {log.info("create new instance");}
    
    @Override
    public List<Pets> getAll() {
        return em.createNamedQuery("Pets.all").getResultList();
    }

    @Override
    public Pets getById(long pId) {
        return em.find(Pets.class, pId);
    }

    @Override
    public Pets getByName(String pName) {
        return em.createNamedQuery("Pets.name",Pets.class)
                .setParameter("name", pName)
                .getSingleResult();
    }

    @Override
    public Pets create(Pets pData) {
        em.getTransaction().begin();
        em.persist(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public Pets modify(Pets pData) {
        em.getTransaction().begin();
        em.merge(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public Pets delete(long pId) {
        Pets species = getById(pId);
        em.getTransaction().begin();
        em.remove(species);
        em.getTransaction().commit();
        return species;
    }
}

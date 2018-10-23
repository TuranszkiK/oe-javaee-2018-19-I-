package hu.javagladiators.education.hoe.species.dao;

import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.species.dao.interfaces.SpeciesDao;
import hu.javagladiators.education.hoe.species.dao.models.Species;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author krisztian
 */
@RequestScoped
public class SpeciesDaoImpl implements BaseDao<Species>{
    private static final Logger log = Logger.getLogger("SpeciesDaoImpl");

    private EntityManager em = Persistence.createEntityManagerFactory("hoe").createEntityManager();

    public SpeciesDaoImpl() {log.info("create new instance");}

    
    
    @Override
    public List<Species> getAll() {
        return em.createNamedQuery("Species.all").getResultList();
    }

    @Override
    public Species getById(long pId) {
        return em.find(Species.class, pId);
    }

    @Override
    public Species getByName(String pName) {
        return em.createNamedQuery("Species.name",Species.class)
                .setParameter("name", pName)
                .getSingleResult();
    }

    @Override
    public Species create(Species pData) {
        em.getTransaction().begin();
        em.persist(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public Species modify(Species pData) {
        em.getTransaction().begin();
        em.merge(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public Species delete(long pId) {
        Species species = getById(pId);
        em.getTransaction().begin();
        em.remove(species);
        em.getTransaction().commit();
        return species;
    }
    
}

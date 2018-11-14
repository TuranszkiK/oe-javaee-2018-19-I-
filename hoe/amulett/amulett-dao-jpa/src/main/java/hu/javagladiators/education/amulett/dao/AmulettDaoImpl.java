package hu.javagladiators.education.amulett.dao;

import hu.javagladiators.education.hoe.amulett.dao.interfaces.AmulettDao;
import hu.javagladiators.education.hoe.amulett.dao.models.Amulett;
import java.util.List;
import javax.annotation.PostConstruct;

import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kbitter
 */

@RequestScoped
public class AmulettDaoImpl implements AmulettDao {
    
    private static final Logger log = Logger.getLogger("AmulettDaoImpl");

    private EntityManager em = Persistence.createEntityManagerFactory("hoe").createEntityManager();

    public AmulettDaoImpl() {log.info("create new instance");}

    @Override
    public Amulett findAmulett(long id) {
                return em.find(Amulett.class, id);
    }

    @Override
    public List<Amulett> getAmuletts() {
        List<Amulett> res = em.createQuery("SELECT a FROM Amulett a").getResultList();
        return res;
    }

    @Override
    public void insertAmulett(Amulett amulett) {
  em.getTransaction().begin();
        em.persist(amulett);
        em.getTransaction().commit();    }

    @Override
    public void removeAmulett(Amulett amulett) {
             em.getTransaction().begin();   
        em.remove(amulett);
        em.getTransaction().commit();
    }

    @Override
    public void updateAmulett(Amulett amulett, String name, String desc) {
  amulett.setName(name);
        amulett.setDescription(desc);
        
        em.getTransaction().begin();
        em.merge(amulett);
        em.getTransaction().commit();    }
    
}    

package hu.javagladiators.education.magic.dao;

import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.magic.dao.models.Magic;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import hu.javagladators.education.hoe.magic.dao.interfaces.MagicDao;

/**
 *
 * @author SólyomBenjámin
 */
public class MagicDaoImpl implements BaseDao<Magic>{
    private static final Logger log = Logger.getLogger("MagicImpl");

    private EntityManager em = Persistence.createEntityManagerFactory("hoe").createEntityManager();

    public MagicDaoImpl() {log.info("create new instance");}

    
    
    @Override
    public List<Magic> getAll() {
        return em.createNamedQuery("Magic.all").getResultList();
    }

    @Override
    public Magic getById(long pId) {
        return em.find(Magic.class, pId);
    }

    @Override
    public Magic getByName(String pName) {
        return em.createNamedQuery("Magic.name",Magic.class)
                .setParameter("name", pName)
                .getSingleResult();
    }

    @Override
    public Magic create(Magic pData) {
        em.getTransaction().begin();
        em.persist(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public Magic modify(Magic pData) {
        em.getTransaction().begin();
        em.merge(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public Magic delete(long pId) {
        Magic species = getById(pId);
        em.getTransaction().begin();
        em.remove(species);
        em.getTransaction().commit();
        return species;
    }
    
}

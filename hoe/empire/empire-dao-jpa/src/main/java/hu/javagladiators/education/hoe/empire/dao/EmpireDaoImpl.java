package hu.javagladiators.education.hoe.empire.dao;



import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.empire.dao.interfaces.EmpireDao;
import hu.javagladiators.education.hoe.empire.dao.models.Empire;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author krisztian
 */
@RequestScoped
public class EmpireDaoImpl implements BaseDao<Empire>{
    private static final Logger log = Logger.getLogger("EmpireDaoImpl");

    private EntityManager em = Persistence.createEntityManagerFactory("hoe").createEntityManager();

    public EmpireDaoImpl() {log.info("create new instance");}

    
    
    @Override
    public List<Empire> getAll() {
        return em.createNamedQuery("Empire.all").getResultList();
    }

    @Override
    public Empire getById(long pId) {
        return em.find(Empire.class, pId);
    }

    @Override
    public Empire getByName(String pName) {
        return em.createNamedQuery("Empire.name",Empire.class)
                .setParameter("name", pName)
                .getSingleResult();
    }

    @Override
    public Empire create(Empire pData) {
        em.getTransaction().begin();
        em.persist(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public Empire modify(Empire pData) {
        em.getTransaction().begin();
        em.merge(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public Empire delete(long pId) {
        Empire empire = getById(pId);
        em.getTransaction().begin();
        em.remove(empire);
        em.getTransaction().commit();
        return empire;
    }
    
}

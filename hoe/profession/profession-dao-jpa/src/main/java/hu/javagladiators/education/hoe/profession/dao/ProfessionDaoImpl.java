package hu.javagladiators.education.hoe.profession.dao;

import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import hu.javagladiators.education.hoe.profession.dao.interfaces.ProfessionDao;
import hu.javagladiators.education.hoe.profession.dao.models.Profession;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author krisztian
 */
@RequestScoped
public class ProfessionDaoImpl implements BaseDao<Profession>{
    private static final Logger log = Logger.getLogger("ProfessionDaoImpl");

    private EntityManager em = Persistence.createEntityManagerFactory("hoe").createEntityManager();

    public ProfessionDaoImpl() {log.info("create new instance");}

    
    
    @Override
    public List<Profession> getAll() {
        return em.createNamedQuery("Profession.all").getResultList();
    }

    @Override
    public Profession getById(long pId) {
        return em.find(Profession.class, pId);
    }

    @Override
    public Profession getByName(String pName) {
        return em.createNamedQuery("Profession.name",Profession.class)
                .setParameter("name", pName)
                .getSingleResult();
    }

    @Override
    public Profession create(Profession pData) {
        em.getTransaction().begin();
        em.persist(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public Profession modify(Profession pData) {
        em.getTransaction().begin();
        em.merge(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public Profession delete(long pId) {
        Profession prof = getById(pId);
        em.getTransaction().begin();
        em.remove(prof);
        em.getTransaction().commit();
        return prof;
    }
    
}

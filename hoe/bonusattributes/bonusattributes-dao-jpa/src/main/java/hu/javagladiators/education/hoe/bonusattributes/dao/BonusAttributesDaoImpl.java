package hu.javagladiators.education.hoe.bonusattributes.dao;

import hu.javagladiators.education.hoe.bonusattributes.dao.models.BonusAttributes;
import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author krisztian
 */
@RequestScoped
public class BonusAttributesDaoImpl implements BaseDao<BonusAttributes>{
    private static final Logger log = Logger.getLogger("BonusAttributesDaoImpl");

    private EntityManager em = Persistence.createEntityManagerFactory("hoe").createEntityManager();

    public BonusAttributesDaoImpl() {log.info("create new instance");}

    
    
    @Override
    public List<BonusAttributes> getAll() {
        return em.createNamedQuery("BonusAttributes.all").getResultList();
    }

    @Override
    public BonusAttributes getById(long pId) {
        return em.find(BonusAttributes.class, pId);
    }

    @Override
    public BonusAttributes getByName(String pName) {
        return em.createNamedQuery("BonusAttributes.name",BonusAttributes.class)
                .setParameter("name", pName)
                .getSingleResult();
    }

    @Override
    public BonusAttributes create(BonusAttributes pData) {
        em.getTransaction().begin();
        em.persist(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public BonusAttributes modify(BonusAttributes pData) {
        em.getTransaction().begin();
        em.merge(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public BonusAttributes delete(long pId) {
        BonusAttributes species = getById(pId);
        em.getTransaction().begin();
        em.remove(species);
        em.getTransaction().commit();
        return species;
    }
    
}

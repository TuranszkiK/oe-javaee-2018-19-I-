package hu.javagladiators.education.hoe.user.dao;

import hu.javagladiators.education.hoe.user.dao.model.User;
import hu.javagladiators.education.hoe.user.dao.model.UserDao;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author krisztian
 */
@RequestScoped
public class UserDaoImpl implements UserDao{
    private static final Logger log = Logger.getLogger("UserDaoImpl");

    private EntityManager em = Persistence.createEntityManagerFactory("hoe").createEntityManager();

    public UserDaoImpl() {log.info("create new instance");}

    
    @Override
    public User getByNamePassword(String pname, String pPassword) {
        return em.createNamedQuery("User.login", User.class)
            .setParameter("name", pname)
            .setParameter("password", pPassword)
            .getSingleResult();
    }

    @Override
    public User create(User pUser) {
        em.getTransaction().begin();
        em.persist(pUser);
        em.getTransaction().commit();
        return pUser;
    }
    
    @Override
    public User getByName(String pName){
        return em.createNamedQuery("User.name", User.class)
            .setParameter("name", pName)
            .getSingleResult();
    }

    @Override
    public User getById(long pId) {
        return em.find(User.class, pId);
    }
    
}

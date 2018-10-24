package hu.javagladiators.education.fegyver.dao.jpa;


import java.util.List;
import javax.annotation.PostConstruct;
import hu.javagladiators.education.fegyver.dao.model.FegyverDao;
import hu.javagladiators.education.fegyver.dao.model.Fegyver;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tnyarsik
 */
@ApplicationScoped
public class FegyverDaoImplementation  implements FegyverDao {
    private EntityManager em;
    
    @PostConstruct
    private void init() {
        em = Persistence.createEntityManagerFactory("bikmakk").createEntityManager();
    }    
      
   // @Override
    public List<Fegyver> getFegyver(){
        List<Fegyver> res = em.createQuery("SELECT a FROM Fegyver a").getResultList();
        return res;
    }
    
    //@Override
    public Fegyver keresFegyver(long id) {
        return em.find(Fegyver.class, id);
    }
    
    //@Override
    public void ujFegyver(Fegyver fegyver) {
        em.getTransaction().begin();
        em.persist(fegyver);
        em.getTransaction().commit();
    }
    
    //@Override
    public void szerkesztFegyver(Fegyver fegyver, String name, String desc) {
        fegyver.setName(name);
        fegyver.setDescription(desc);
        
        em.getTransaction().begin();
        em.merge(fegyver);
        em.getTransaction().commit();
    }
    
   // @Override
    public void torolFegyver(Fegyver fegyver) {
        em.getTransaction().begin();   
        em.remove(fegyver);
        em.getTransaction().commit();
    }
}

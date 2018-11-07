package hu.javagladiators.education.hoe.cataclysms.services;

import hu.javagladiators.education.hoe.cataclysms.entities.Cataclysm;
import hu.javagladiators.education.hoe.cataclysms.interfaces.CataclysmService;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@RequestScoped
public class CataclysmServiceImpl implements CataclysmService{
    
    private EntityManager entityManager;
    
    public CataclysmServiceImpl() {
        entityManager = Persistence.createEntityManagerFactory("CataclysmWebPU").createEntityManager();
    }
    
    public List<Cataclysm> getCataclysms(){
        return entityManager.createQuery("SELECT c FROM Cataclysm c").getResultList();
    }
    
    public Cataclysm getCataclysmById(int id){
        for(Cataclysm cat : getCataclysms()) {
            if(cat.getId() == id) {
                return cat;
                
            }
        }
        return null;
    }
    
    public List<Cataclysm> getCataclysmsByEmpireId(int empireId) {
        List<Cataclysm> catsOfEmp = new ArrayList<Cataclysm>();
        
        for(Cataclysm cat : getCataclysms()) {
            if(cat.getEmpireId() == empireId) {
                catsOfEmp.add(cat);
            }
        }
        return catsOfEmp;
    }

    public Cataclysm addNew(Cataclysm root){
        root.setId(getNextId());
        entityManager.getTransaction().begin();
        entityManager.persist(root);
        entityManager.getTransaction().commit();
        return root;
    }

    public Cataclysm update(int id, Cataclysm updatable){
        entityManager.getTransaction().begin();
        
        Cataclysm cat = entityManager.find(Cataclysm.class, id);
        cat.setEmpireId(updatable.getEmpireId());
        cat.setDescription(updatable.getDescription());
        cat.setDamage(updatable.getDamage());
        cat.setIntensity(updatable.getIntensity());
        cat.setDate(updatable.getDate());
        cat.setTime(updatable.getTime());
        entityManager.merge(cat);
        entityManager.getTransaction().commit();
        return entityManager.find(Cataclysm.class, updatable.getId());
    }

    public void deleteById(int id){
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Cataclysm.class, id));
        entityManager.getTransaction().commit();
    }
    
    public void close() {
        entityManager.close();
    }
    
    public int getNextId(){
        return entityManager.createQuery("SELECT MAX(c.ID) FROM CATACLYSM c", Integer.class).getSingleResult() + 1;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.user.dao.jpa;

import hu.javagladiators.education.ability.dao.model.Ability;
import hu.javagladiators.education.hoe.ability.dao.model.interfaces.AbilityDaoInterface;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
/**
 *
 * @author Kristóf
 */
public class AbilityDaoImpl implements AbilityDaoInterface{
    
    private EntityManager em;
    
    @PostConstruct
    private void init(){
        em = Persistence.createEntityManagerFactory("hoe").createEntityManager();
    }
    
    @Override
    public Ability findAbilityById(long id) {
        return em.find(Ability.class, id);
    }

    @Override
    public Ability findAbilityByName(String name) {
        return em.createQuery("SELECT A from Ability a where a.name = :name", Ability.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public List<Ability> getAllAbilities() {
        List<Ability> back = em.createQuery("select a from Ability a").getResultList();
        return back;
    }

    @Override
    public void addAbility(Ability ability) {
        em.getTransaction().begin();
        em.persist(ability);
        em.getTransaction().commit();
    }

    @Override
    public void removeAbility(long id) {
        Ability a = findAbilityById(id);
        
        em.getTransaction().begin();   
        em.remove(a);
        em.getTransaction().commit();
    }

    @Override
    public void updateAbility(Ability ability) {
        Ability a = findAbilityById(ability.getId());
        a.setName(ability.getName());
        a.setDesc(ability.getDesc());
        a.setType(ability.getType());
        a.setValue(ability.getValue());
        a.setCoolDown(ability.getCoolDown());
        
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.oe.hoe.heroarmor.services;

import hu.oe.hoe.heroarmor.datamodel.HeroArmor;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author szark
 */
@RequestScoped
public class ArmorCRUDService {
    private EntityManager entityManager = Persistence
            .createEntityManagerFactory("heroArmor")
            .createEntityManager();

    //Create
    public boolean addNew(HeroArmor armor) {
        if (armor == null) return false;

        entityManager.getTransaction().begin();
        entityManager.persist(armor);
        entityManager.getTransaction().commit();

        return true;
    }

    //Read
    public List<HeroArmor> getAllHeroArmor() {
        return entityManager.createQuery("SELECT a FROM HeroArmor a").getResultList();
    }

    //Read
    public HeroArmor getHeroArmorById(long id) {
        for (HeroArmor ha : getAllHeroArmor()) {
            if (ha.getId() == id) {
                return ha;
            }
        }
        return null;
    }

    //Update
    public boolean Update(long id, HeroArmor editArmor) {
        entityManager.getTransaction().begin();

        HeroArmor ha = entityManager.find(HeroArmor.class, id);
        if (ha == null || editArmor == null) return false;

        ha.setName(editArmor.getName());
        ha.setDescription((editArmor.getDescription()));
        ha.setArmor(editArmor.getArmor());
        ha.setArmorType(editArmor.getArmorType());
        ha.setArmorPart(editArmor.getArmorPart());
        ha.setDurability(editArmor.getDurability());
        ha.setActive(editArmor.isActive());

        entityManager.merge(ha);
        entityManager.getTransaction().commit();
        return true;
    }

    //Delete
    public boolean DeleteById(long id) {
        if (entityManager.find(HeroArmor.class, id) == null) return false;

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(HeroArmor.class, id));
        entityManager.getTransaction().commit();
        return true;
    }

}
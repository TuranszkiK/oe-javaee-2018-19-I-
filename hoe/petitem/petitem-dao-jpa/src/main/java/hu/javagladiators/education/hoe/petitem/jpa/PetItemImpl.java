/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.petitem.jpa;

import hu.javagladiators.education.hoe.petitem.dao.PetItem;
import hu.javagladiators.education.hoe.petitem.dao.PetItemDAO;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@RequestScoped
public class PetItemImpl implements PetItemDAO
{
    EntityManager em;
    
    public PetItemImpl()
    {
        this.em = Persistence.createEntityManagerFactory("hoe").createEntityManager();
    }

    @Override
    public List<PetItem> getAll()
    {
        List<PetItem> items = (List<PetItem>)em.createNamedQuery("PetItem.all").getResultList();
        return items;
    }

    @Override
    public PetItem getById(long id)
    {
        PetItem item = (PetItem)em.find(PetItem.class, id);
        return item;
    }

    @Override
    public void create(PetItem item)
    {
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
    }
    
    @Override
    public void update(PetItem item)
    {
        em.getTransaction().begin();
        em.merge(item);
        em.getTransaction().commit();
    }

    @Override
    public void delete(long id)
    {
        PetItem item = getById(id);
        em.getTransaction().begin();
        em.remove(item);
        em.getTransaction().commit();
    }
}

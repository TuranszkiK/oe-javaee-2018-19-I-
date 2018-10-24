/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.guild.dao;


import hu.javagladiators.education.guild.dao.models.Guild;
import hu.javagladiators.education.hoe.base.dao.interfaces.BaseDao;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author krisztian
 */
@RequestScoped
public class GuildDaoImpl implements BaseDao<Guild> {
        private static final Logger log = Logger.getLogger("SpeciesDaoImpl");

    private EntityManager em = Persistence.createEntityManagerFactory("hoe").createEntityManager();

    public GuildDaoImpl() {log.info("create new instance");}

    
    
    @Override
    public List<Guild> getAll() {
        return em.createNamedQuery("Guild.all").getResultList();
    }

    @Override
    public Guild getById(long pId) {
        return em.find(Guild.class, pId);
    }

    @Override
    public Guild getByName(String pName) {
        return em.createNamedQuery("Guild.name",Guild.class)
                .setParameter("name", pName)
                .getSingleResult();
    }

    @Override
    public Guild create(Guild pData) {
        em.getTransaction().begin();
        em.persist(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public Guild modify(Guild pData) {
        em.getTransaction().begin();
        em.merge(pData);
        em.getTransaction().commit();
        return pData;
    }

    @Override
    public Guild delete(long pId) {
        Guild species = getById(pId);
        em.getTransaction().begin();
        em.remove(species);
        em.getTransaction().commit();
        return species;
    }
}

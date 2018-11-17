/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.petitem.services;

import hu.javagladiators.education.hoe.petitem.dao.PetItem;
import hu.javagladiators.education.hoe.petitem.dao.PetItemDAO;
import hu.javagladiators.education.hoe.petitem.dao.PetItemException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

@RequestScoped
public class PetItemResourceImpl implements PetItemResource
{
    @Inject
    PetItemDAO dao;
    
    public PetItemResourceImpl() {}

    @Override
    public List<PetItem> getAll() throws PetItemException
    {
        try
        {
            return dao.getAll();
        }
        catch (Exception e)
        {
            throw new PetItemException("Query to request all existing PetItems failed.");
        }
    }

    @Override
    public PetItem getById(long id) throws PetItemException
    {
        try
        {
            return dao.getById(id);
        }
        catch (NoResultException e)
        {
            throw new PetItemException("PetItem with id = " + id + " cannot be found.");
        }
        catch (Exception e)
        {
            throw new PetItemException("Error with query for PetItem with id = " + id + ".");
        }
    }

    @Override
    public void create(PetItem item) throws PetItemException
    {
        try
        {
            validate(item);
            dao.create(item);
        }
        catch (PetItemException e)
        {
            throw e;
        }
        catch (Exception e)
        {
            throw new PetItemException("Error when saving the new PetItem.");
        }
    }
    
    @Override
    public void update(PetItem item) throws PetItemException
    {
        try
        {
            validate(item);
            dao.update(item);
        }
        catch (PetItemException e)
        {
            throw e;
        }
        catch (NoResultException e)
        {
            throw new PetItemException("PetItem with id = " + item.getId() + " cannot be found.");
        }
        catch (Exception e)
        {
            throw new PetItemException("Error when updating PetItem with id = " + item.getId() + ".");
        }
    }

    @Override
    public void delete(long id) throws PetItemException
    {
        try
        {
            dao.delete(id);
        }
        catch (NoResultException e)
        {
            throw new PetItemException("PetItem with id = " + id + " cannot be found.");
        }
        catch (Exception e)
        {
            throw new PetItemException("PetItem with id = " + id + " couldn't be deleted.");
        } 
    }
    
    private void validate(PetItem item) throws PetItemException
    {        
        List<PetItem> items = dao.getAll();
        for (PetItem d : items)
        {
            if (item.getName().equals(d.getName()) && item.getId()!=d.getId())
            {
                throw new PetItemException("A PetItem entity with this name already exists.");
            }
        }
    }
}

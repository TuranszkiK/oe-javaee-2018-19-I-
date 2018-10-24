/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.petlevel.services;

import hu.javagladiators.education.hoe.petlevel.dao.PetLevel;
import hu.javagladiators.education.hoe.petlevel.dao.PetLevelDAO;
import hu.javagladiators.education.hoe.petlevel.dao.PetLevelException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 *
 * @author user
 */
@RequestScoped
public class PetLevelResourceImpl implements PetLevelResource {

    @Inject
    PetLevelDAO dao;
    
    public PetLevelResourceImpl(){
        
    }
    
    @Override
    public PetLevel create(PetLevel d) throws PetLevelException {
        try {
            validate(d);
            dao.create(d);
            return d;
        } catch (PetLevelException e) {
            throw e;
        } catch (Exception e) {
            throw new PetLevelException("Error when saving the new instance");
        }
    }

    @Override
    public List<PetLevel> getAll() throws PetLevelException {
        try {
            return dao.getAll();
        } catch (Exception e) {
            throw new PetLevelException("Query failed.");
        }
    }

    @Override
    public PetLevel getById(long id) throws PetLevelException {
        try {
            return dao.getById(id);
        } catch (NoResultException e) {
            throw new PetLevelException(id + " cannot be found.");
        } catch (Exception e) {
            throw new PetLevelException("Error with query for " + id);
        }
    }

    @Override
    public PetLevel update(PetLevel d) throws PetLevelException {
        try {
            validate(d);
            
            dao.update(d);

            return d;
            
        } catch (PetLevelException e) {
            throw e;
        } catch (NoResultException e) {
            throw new PetLevelException(d.getId() + " cannot be found.");
        } catch (Exception e) {
            throw new PetLevelException("Error when updating " + d.getId());
        }
    }

    @Override
    public void delete(long id) throws PetLevelException {
        try {
            dao.delete(id);
        } catch (NoResultException e) {
            throw new PetLevelException(id + " cannot be found.");
        } catch (Exception e) {
            throw new PetLevelException(id + " couldn't be deleted.");
        } 
    }
    
    private void validate(PetLevel dbu) throws PetLevelException {
        if(dbu.getFromLevel() > dbu.getUntilLevel())
            throw new PetLevelException("From level was grater than until level. ");
        if(dbu.getFromLevel() <= 0 || dbu.getUntilLevel() <= 0)
            throw new PetLevelException("Only positive levels allowed.");
        List<PetLevel> all = dao.getAll();
        for (PetLevel d : all) {
            if (dbu.getLevelName().equals(d.getLevelName()) && dbu.getId()!=d.getId())
                throw new PetLevelException("An instance with this name already exists. ");
            if(!notOverlappingRange(dbu, d))
                throw new PetLevelException("Overlapping levels for the descriptions. ");
        }
    }
    
    private boolean notOverlappingRange(PetLevel d, PetLevel other){
        return (d.getUntilLevel() <= other.getFromLevel() && d.getFromLevel() <= other.getFromLevel()) 
                || (d.getUntilLevel() >= other.getUntilLevel() && other.getFromLevel() >= other.getUntilLevel());
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.petlevel.services;

import java.util.List;
import hu.javagladiators.education.hoe.petlevel.dao.PetLevel;
import hu.javagladiators.education.hoe.petlevel.dao.PetLevelException;
/**
 *
 * @author user
 */
public interface PetLevelResource {
    PetLevel create(PetLevel d) throws PetLevelException;
    List<PetLevel> getAll() throws PetLevelException;
    PetLevel getById(long id) throws PetLevelException;
    PetLevel update(PetLevel d) throws PetLevelException;
    void delete(long id) throws PetLevelException;
}
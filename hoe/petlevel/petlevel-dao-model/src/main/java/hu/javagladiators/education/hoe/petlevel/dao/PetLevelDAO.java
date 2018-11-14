/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.petlevel.dao;

import java.util.List;

public interface PetLevelDAO {
    PetLevel create(PetLevel d);
    List<PetLevel> getAll();
    PetLevel getById(long id);
    PetLevel update(PetLevel d);
    void delete(long id);
}

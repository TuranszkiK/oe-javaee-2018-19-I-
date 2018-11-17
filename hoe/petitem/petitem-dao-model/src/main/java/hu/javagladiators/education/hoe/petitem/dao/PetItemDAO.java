/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.petitem.dao;

import java.util.List;

public interface PetItemDAO
{    
    List<PetItem> getAll();
    PetItem getById(long id);
    void create(PetItem item);
    void update(PetItem item);
    void delete(long id);
}

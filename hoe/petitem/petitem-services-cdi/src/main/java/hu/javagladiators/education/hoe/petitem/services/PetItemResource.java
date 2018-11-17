/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.petitem.services;

import hu.javagladiators.education.hoe.petitem.dao.PetItem;
import hu.javagladiators.education.hoe.petitem.dao.PetItemException;
import java.util.List;

public interface PetItemResource
{
    List<PetItem> getAll() throws PetItemException;
    PetItem getById(long id) throws PetItemException;
    void create(PetItem item) throws PetItemException;
    void update(PetItem item) throws PetItemException;
    void delete(long id) throws PetItemException;
}

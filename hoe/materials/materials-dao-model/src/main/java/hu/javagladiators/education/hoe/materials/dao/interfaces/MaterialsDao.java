/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.materials.dao.interfaces;

import hu.javagladiators.education.hoe.materials.dao.models.Materials;
import java.util.List;

/**
 *
 * @author Roltown
 */
public interface MaterialsDao {
    public List<Materials> getAll();
    public Materials getById(long pId);
    public Materials getByName(String pName);
    public Materials create(Materials pData);
    public Materials modify(long pId,Materials pData);
    public Materials delete(long pId);
}

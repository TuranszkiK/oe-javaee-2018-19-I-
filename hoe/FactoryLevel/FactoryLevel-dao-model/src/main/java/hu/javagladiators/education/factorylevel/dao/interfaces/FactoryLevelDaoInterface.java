/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.factorylevel.dao.interfaces;

import hu.javagladiators.education.factorylevel.dao.models.FactoryLevel;
import java.util.List;

/**
 *
 * @author I341314
 */
public interface FactoryLevelDaoInterface {
    public List<FactoryLevel> getAll();
    public FactoryLevel getById(long pId);
    public FactoryLevel getByName(String pName);
    public FactoryLevel create(FactoryLevel pData);
    public FactoryLevel modify(long pId,FactoryLevel pData);
    public FactoryLevel delete(long pId);
}

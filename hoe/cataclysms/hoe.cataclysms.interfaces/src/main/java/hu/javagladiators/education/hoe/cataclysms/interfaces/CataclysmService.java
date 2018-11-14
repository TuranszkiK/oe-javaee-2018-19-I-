/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.cataclysms.interfaces;

import hu.javagladiators.education.hoe.cataclysms.entities.Cataclysm;
import java.util.List;

public interface CataclysmService{
    
    public List<Cataclysm> getCataclysms();
    
    public Cataclysm getCataclysmById(int id);
    
    public List<Cataclysm> getCataclysmsByEmpireId(int empireId);

    public Cataclysm addNew(Cataclysm root);

    public Cataclysm update(int id, Cataclysm updatable);

    public void deleteById(int id);
    
    public void close();
    
    public int getNextId();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.amulett.dao.interfaces;

import hu.javagladiators.education.hoe.amulett.dao.models.Amulett;
import java.util.List;

/**
 *
 * @author kbitter
 */
public interface AmulettDao {
    Amulett findAmulett(long id);
    List<Amulett> getAmuletts();
    void insertAmulett(Amulett amulett);
    void removeAmulett(Amulett amulett);
    void updateAmulett(Amulett amulett, String name, String desc);      
}

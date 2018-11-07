/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.factory.dao.interfaces;

import java.io.Serializable;
import java.util.List;
import hu.javagladiators.education.factory.dao.models.Factory;
/**
 *
 * @author Lóci
 */
public interface FactoryService {
    List<Factory> getSystemFactories();
    void insertFactory(Factory f);
    void removeFactory(Factory f);
    void modifyFactory(Factory f);
    Factory findFactory(long id);
}

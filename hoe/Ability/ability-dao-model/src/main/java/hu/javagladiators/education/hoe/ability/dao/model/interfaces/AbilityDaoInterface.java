/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.hoe.ability.dao.model.interfaces;

import hu.javagladiators.education.ability.dao.model.Ability;
import java.util.List;
/**
 *
 * @author Kristóf
 */
public interface AbilityDaoInterface {
    
    Ability findAbilityById(long id);
    
    Ability findAbilityByName(String name);
    
    List<Ability> getAllAbilities();
    
    void addAbility(Ability ability);
    
    void removeAbility(long id);
    
    void updateAbility(Ability ability);
}

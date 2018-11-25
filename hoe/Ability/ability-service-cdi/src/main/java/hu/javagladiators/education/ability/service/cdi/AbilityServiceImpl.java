/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.ability.service.cdi;

import hu.javagladiators.education.ability.dao.model.Ability;
import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.ability.dao.model.interfaces.AbilityDaoInterface;

import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
/**
 *
 * @author Kristóf
 */
@ApplicationScoped
public class AbilityServiceImpl {
    @Inject
    protected AbilityDaoInterface abilityDaoInterface;
    
    private static final Logger log = Logger.getLogger("SpeciesDialogImpl");
    public List<Ability> getAll(){
        return abilityDaoInterface.getAllAbilities();
    }
    
    public Ability getById(long id){
        return abilityDaoInterface.findAbilityById(id);
    }
    
    public void create(Ability ability) throws BusinessException{
        try {
            abilityDaoInterface.findAbilityByName(ability.getName());
            throw new BusinessException();
        } catch (NoResultException e) {
            abilityDaoInterface.addAbility(ability);
        }
    }
    
    public void tryModify(long id, String name, String desc, String type, int value, int coolDown){
        try {
            Ability a = abilityDaoInterface.findAbilityById(id);
            a.setCoolDown(coolDown);
            a.setDesc(desc);
            a.setName(name);
            a.setType(type);
            a.setValue(value);
            abilityDaoInterface.updateAbility(a);
        } catch (NoResultException e) {
            throw new BusinessException();
        }
    }
    
    public void deleteAbility(long id){
        try {
            abilityDaoInterface.removeAbility(id);
        } catch (NoResultException e) {
            log.info("Ability can't be found.");
        }
    }
}

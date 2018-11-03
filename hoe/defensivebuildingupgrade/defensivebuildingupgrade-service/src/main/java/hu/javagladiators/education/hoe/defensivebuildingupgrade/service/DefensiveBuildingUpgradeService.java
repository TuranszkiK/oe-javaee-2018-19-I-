package hu.javagladiators.education.hoe.defensivebuildingupgrade.service;

import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import hu.javagladiators.education.hoe.base.service.interfaces.BaseService;
import hu.javagladiators.education.hoe.defensivebuildingupgrade.dao.interfaces.IDefensiveBuildingUpgradeDAO;
import hu.javagladiators.education.hoe.defensivebuildingupgrade.model.DefensiveBuildingUpgrade;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DefensiveBuildingUpgradeService implements BaseService<DefensiveBuildingUpgrade> {
    
    @Inject
    private IDefensiveBuildingUpgradeDAO dao;
    
    public DefensiveBuildingUpgradeService(){
        
    }
    
    @Override
    public List<DefensiveBuildingUpgrade> getAll() {
        try {
            return dao.getAll();
        } catch (Exception e) {
            throw new BusinessException();
        } 
    }

    @Override
    public DefensiveBuildingUpgrade getById(long id) {
        try {
            return dao.getById(id);
        } catch (Exception e) {
            throw new BusinessException();
        }
    }

    @Override
    public DefensiveBuildingUpgrade create(DefensiveBuildingUpgrade d) throws BusinessException {
        try {
            validate(d);
            dao.create(d);
            return d;
        } catch (Exception e) {
            throw new BusinessException();
        }    
    }

    @Override
    public DefensiveBuildingUpgrade modify(long id, DefensiveBuildingUpgrade d) throws BusinessException {
        try {
            validate(d);
            
            dao.update(d);

            return d;
        }catch(Exception e){
            throw new BusinessException();
        }
    }

    @Override
    public DefensiveBuildingUpgrade delete(long id) {
        try{
            dao.delete(id);
        }catch(Exception e){
            throw new BusinessException();
        }
        return null;
    }
    
    private void validate(DefensiveBuildingUpgrade dbu) {
        List<DefensiveBuildingUpgrade> all = dao.getAll();
        for(DefensiveBuildingUpgrade d : all) {
            if (dbu.getName().equals(d.getName()) && dbu.getId()!=d.getId()) {
                throw new BusinessException();
            }
        }
    }
}

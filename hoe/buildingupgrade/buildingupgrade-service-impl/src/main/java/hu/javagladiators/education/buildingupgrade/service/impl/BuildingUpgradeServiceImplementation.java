/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.buildingupgrade.service.impl;

import hu.javagladiators.education.buildingupgrade.dto.BuildingUpgradeDto;
import hu.javagladiators.education.buildingupgrade.service.BuildingUpgradeService;
import hu.javagladiators.education.buildingupgrade.entities.BuildingUpgrade;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class BuildingUpgradeServiceImplementation implements BuildingUpgradeService {
    private EntityManager entityManager = Persistence.createEntityManagerFactory("hoe").createEntityManager();

    @Override
    public List<BuildingUpgradeDto> getBuildingUpgrades(){
        List<BuildingUpgrade> entities = entityManager.createNamedQuery(BuildingUpgrade.AllBuildingUpgradesNamedQuery).getResultList();
        List<BuildingUpgradeDto> output = new ArrayList<>();
        for(BuildingUpgrade bu : entities)
            output.add(this.toDto(bu));
        return output;
        //return entityManager.createQuery("SELECT b FROM BuildingUpgrade b").getResultList();
        //return entityManager.createNamedQuery(BuildingUpgrade.AllBuildingUpgradesNamedQuery).getResultList();
    }
    
    @Override
    public BuildingUpgradeDto getBuildingUpgradeById(long id){
        for(BuildingUpgradeDto bu : getBuildingUpgrades())
            if(bu.getId() == id)
                return bu;
        return null;
    }

    @Override
    public BuildingUpgradeDto addNew(BuildingUpgradeDto root){
        entityManager.getTransaction().begin();
        entityManager.persist(root);
        entityManager.getTransaction().commit();
        return root;
    }

    @Override
    public BuildingUpgradeDto updateBuildingUpgrade(long id, BuildingUpgradeDto updated){
        entityManager.getTransaction().begin();
        
        BuildingUpgrade up = entityManager.find(BuildingUpgrade.class, id);
        up.setBonusAttribute(updated.getBonusAttribute());
        up.setBonusAttributeValue(updated.getBonusAttributeValue());
        up.setCost(updated.getCost());
        up.setName(updated.getName());
        up.setDescription(updated.getDescription());
        
        entityManager.merge(up);
        entityManager.getTransaction().commit();
        return this.toDto(entityManager.find(BuildingUpgrade.class, updated.getId()));
    }

    @Override
    public void deleteById(long id){
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(BuildingUpgrade.class, id));
        entityManager.getTransaction().commit();
    }
    
    private BuildingUpgrade toEntity(BuildingUpgradeDto dto){
        BuildingUpgrade output = new BuildingUpgrade(dto.getId());
        output.setCost(dto.getCost());
        output.setName(dto.getName());
        output.setBonusAttribute(dto.getBonusAttribute());
        output.setBonusAttributeValue(dto.getBonusAttributeValue());
        return output;
    }
    
    private BuildingUpgradeDto toDto(BuildingUpgrade entity){
        BuildingUpgradeDto output = new BuildingUpgradeDto(entity.getId());
        output.setCost(entity.getCost());
        output.setName(entity.getName());
        output.setBonusAttribute(entity.getBonusAttribute());
        output.setBonusAttributeValue(entity.getBonusAttributeValue());
        return output;
    }
}


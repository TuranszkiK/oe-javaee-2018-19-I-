/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.buildingupgrade.service;

import hu.javagladiators.education.buildingupgrade.dto.BuildingUpgradeDto;
import java.util.List;

/**
 *
 * @author mfrohlich
 */
public interface BuildingUpgradeService {
    BuildingUpgradeDto addNew(BuildingUpgradeDto buildingUpgrade);
    void deleteById(long id);
    BuildingUpgradeDto getBuildingUpgradeById(long id);
    List<BuildingUpgradeDto> getBuildingUpgrades();
    BuildingUpgradeDto updateBuildingUpgrade(long id, BuildingUpgradeDto updated);
}

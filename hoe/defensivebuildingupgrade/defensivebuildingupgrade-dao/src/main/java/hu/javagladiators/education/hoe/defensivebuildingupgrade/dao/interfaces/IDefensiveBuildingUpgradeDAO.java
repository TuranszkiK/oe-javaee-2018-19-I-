package hu.javagladiators.education.hoe.defensivebuildingupgrade.dao.interfaces;

import hu.javagladiators.education.hoe.defensivebuildingupgrade.model.DefensiveBuildingUpgrade;
import java.util.List;

public interface IDefensiveBuildingUpgradeDAO {
    DefensiveBuildingUpgrade create(DefensiveBuildingUpgrade d);
    List<DefensiveBuildingUpgrade> getAll();
    DefensiveBuildingUpgrade getById(long id);
    DefensiveBuildingUpgrade update(DefensiveBuildingUpgrade d);
    void delete(long id);
}

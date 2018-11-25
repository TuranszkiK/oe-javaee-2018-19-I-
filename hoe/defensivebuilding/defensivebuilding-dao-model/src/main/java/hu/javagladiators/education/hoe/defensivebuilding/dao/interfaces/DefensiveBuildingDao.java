package hu.javagladiators.education.hoe.defensivebuilding.dao.interfaces;

import hu.javagladiators.education.hoe.defensivebuilding.dao.models.DefensiveBuilding;
import java.util.List;

/**
 *
 * @author nagym
 */
public interface DefensiveBuildingDao {
    public List<DefensiveBuilding> getAll();
    public DefensiveBuilding getById(long pId);
    public DefensiveBuilding create(DefensiveBuilding pData);
    public DefensiveBuilding modify(DefensiveBuilding pData);
    public DefensiveBuilding delete(long pId);
}

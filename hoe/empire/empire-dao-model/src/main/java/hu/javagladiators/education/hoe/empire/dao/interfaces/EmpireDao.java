package hu.javagladiators.education.hoe.empire.dao.interfaces;

import hu.javagladiators.education.hoe.empire.dao.models.Empire;
import java.util.List;

/**
 * @author krisztian
 */
public interface EmpireDao {
    public List<Empire> getAll();
    public Empire getById(long pId);
    public Empire getByName(String pName);
    public Empire create(Empire pData);
    public Empire modify(long pId,Empire pData);
    public Empire delete(long pId);
}

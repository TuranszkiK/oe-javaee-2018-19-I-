package hu.javagladiators.education.empirelevel.dao.interfaces;

import hu.javagladiators.education.empirelevel.dao.models.EmpireLevel;
import java.util.List;


public interface EmpireLevelDao {
    public List<EmpireLevel> getAll();
    public EmpireLevel getById(long pId);
    public EmpireLevel create(EmpireLevel pEmpLev);
    public EmpireLevel modify(long pId, EmpireLevel pData);
    public EmpireLevel delete(long pId);
}

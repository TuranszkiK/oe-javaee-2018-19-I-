package hu.javagladiators.education.hoe.profession.dao.interfaces;

import hu.javagladiators.education.hoe.profession.dao.models.Profession;
import java.util.List;

/**
 * @author krisztian
 */
public interface ProfessionDao {
    public List<Profession> getAll();
    public Profession getById(long pId);
    public Profession getByName(String pName);
    public Profession create(Profession pData);
    public Profession modify(long pId,Profession pData);
    public Profession delete(long pId);
}

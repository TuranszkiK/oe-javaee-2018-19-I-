package hu.javagladiators.education.hoe.bonusattributes.dao.interfaces;


import hu.javagladiators.education.hoe.bonusattributes.dao.models.BonusAttributes;
import java.util.List;

/**
 * @author krisztian
 */
public interface BonusAttributesDao {
    public List<BonusAttributes> getAll();
    public BonusAttributes getById(long pId);
    public BonusAttributes getByName(String pName);
    public BonusAttributes create(BonusAttributes pData);
    public BonusAttributes modify(long pId,BonusAttributes pData);
    public BonusAttributes delete(long pId);
}

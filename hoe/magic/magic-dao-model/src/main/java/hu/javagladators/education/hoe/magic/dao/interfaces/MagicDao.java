package hu.javagladators.education.hoe.magic.dao.interfaces;

import hu.javagladiators.education.hoe.magic.dao.models.Magic;
import java.util.List;

/**
 *
 * @author SólyomBenjámin
 */
public interface MagicDao {
    public List<Magic> getAll();
    public Magic getById(long pId);
    public Magic getByName(String pName);
    public Magic create(Magic pData);
    public Magic modify(long pId,Magic pData);
    public Magic delete(long pId);
}

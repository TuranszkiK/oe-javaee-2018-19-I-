package hu.javagladiators.education.hoe.species.dao.interfaces;

import hu.javagladiators.education.hoe.species.dao.models.Species;
import java.util.List;

/**
 * @author krisztian
 */
public interface SpeciesDao {
    public List<Species> getAll();
    public Species getById(long pId);
    public Species getByName(String pName);
    public Species create(Species pData);
    public Species modify(long pId,Species pData);
    public Species delete(long pId);
}

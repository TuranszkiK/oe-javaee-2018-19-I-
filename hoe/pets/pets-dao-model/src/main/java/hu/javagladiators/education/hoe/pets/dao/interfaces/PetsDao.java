package hu.javagladiators.education.hoe.pets.dao.interfaces;

import hu.javagladiators.education.hoe.pets.dao.models.Pets;
import java.util.List;

public interface PetsDao {
    public List<Pets> getAll();
    public Pets getById(long pId);
    public Pets getByName(String pName);
    public Pets create(Pets pData);
    public Pets modify(long pId,Pets pData);
    public Pets delete(long pId);
}

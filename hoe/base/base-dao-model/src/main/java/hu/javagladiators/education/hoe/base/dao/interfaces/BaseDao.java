package hu.javagladiators.education.hoe.base.dao.interfaces;

import java.util.List;

/**
 *
 * @author krisztian
 */
public interface BaseDao<T> {
    public List<T> getAll();
    public T getById(long pId);
    public T getByName(String pName);
    public T create(T pData);
    public T modify(T pData);
    public T delete(long pId);    
    
}

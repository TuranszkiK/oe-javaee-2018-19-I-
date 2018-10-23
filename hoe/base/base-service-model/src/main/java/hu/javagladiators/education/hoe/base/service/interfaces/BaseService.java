package hu.javagladiators.education.hoe.base.service.interfaces;

import hu.javagladiators.education.hoe.base.service.exceptions.BusinessException;
import java.util.List;

/**
 *
 * @author krisztian
 */
public interface BaseService<T> {
    public List<T> getAll();
    public T getById(long pId);
    public T create(T pData) throws BusinessException;
    public T modify(long pId,T pData) throws BusinessException;
    public T delete(long pId);    
    
}

package hu.javagladiators.education.hoe.user.service.model;

import hu.javagladiators.education.hoe.user.dao.model.User;
import hu.javagladiators.education.hoe.user.service.exceptions.WrongLoginException;
import hu.javagladiators.education.hoe.user.service.exceptions.WrongRegistrationException;

/**
 * @author krisztian
 */
public interface UserService {
    public static final String USER_ROLE="user";
    public User login(String pName, String pPassword) throws WrongLoginException;    
    public User playerRegistration(String pName, String pPassword) throws WrongRegistrationException;    
}

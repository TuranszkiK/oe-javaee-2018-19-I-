package hu.javagladiators.education.hoe.user.service;

import hu.javagladiators.education.hoe.user.dao.model.User;
import hu.javagladiators.education.hoe.user.dao.model.UserDao;
import hu.javagladiators.education.hoe.user.service.exceptions.WrongLoginException;
import hu.javagladiators.education.hoe.user.service.exceptions.WrongRegistrationException;
import hu.javagladiators.education.hoe.user.service.model.UserService;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

/**
 * @author krisztian
 */
@ApplicationScoped
public class UserServiceImpl implements UserService{
    private static final Logger log = Logger.getLogger("UserServiceImpl");

    @Inject
    private UserDao dao;

    public UserServiceImpl() {log.info("create new instance");}
    
    
    
    @Override
    public User login(String pName, String pPassword) throws WrongLoginException{
        try{
            return dao.getByNamePassword(pName, pPassword);
        }
        catch(NoResultException | NonUniqueResultException e){
            throw new WrongLoginException();
        }
    }

    @Override
    public User playerRegistration(String pName, String pPassword) throws WrongRegistrationException {
        try{
            User user = dao.getByName(pName);
            log.info("+++"+user);
        }
        catch(NoResultException e){
            User user = new User();
            user.setName(pName);
            user.setPassword(pPassword);
            user.setRole(USER_ROLE);
            try{
            return dao.create(user);
            }
            catch(Exception e0){
                e.printStackTrace();
                throw new WrongRegistrationException();
            }
        }
        throw new WrongRegistrationException();
    }

    
}

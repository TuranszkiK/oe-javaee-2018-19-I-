package hu.javagladiators.education.hoe.user.dao.model;

/**
 * @author krisztian
 */
public interface UserDao {
    public User getByNamePassword(String pName, String pPassword);
    public User getById(long pId);
    public User getByName(String pName);
    public User create(User pUser);
}

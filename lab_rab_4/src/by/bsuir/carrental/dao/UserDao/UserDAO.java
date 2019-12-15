package by.bsuir.carrental.dao.UserDao;

import by.bsuir.carrental.dao.UserDB;
import by.bsuir.carrental.entity.User;

/**
 * The type User dao.
 */
public class UserDAO {
    /**
     * Gets user.
     *
     * @param name     the name
     * @param password the password
     * @return the user
     */
    public User getUser (String name, String password)
    {
        return UserDB.selectOne(name, password);
    }

    /**
     * Gets user by name.
     *
     * @param name the name
     * @return the user by name
     */
    public User getUserByName (String name)
    {
        return UserDB.selectOneByName(name);
    }

    /**
     * Add user.
     *
     * @param name     the name
     * @param password the password
     */
    public void addUser(String name, String password) {
        UserDB.insert(new User(name, password));
    }
}

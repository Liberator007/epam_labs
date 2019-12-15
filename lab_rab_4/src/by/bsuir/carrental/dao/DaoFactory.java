package by.bsuir.carrental.dao;

import by.bsuir.carrental.dao.UserDao.UserDAO;
import by.bsuir.carrental.dao.VehicleDao.CarDAO;

/**
 * The type Dao factory.
 */
public class DaoFactory {

    private static CarDAO carDAO = new CarDAO();
    private static UserDAO userDAO = new UserDAO();

    /**
     * Gets vehicle dao.
     *
     * @return the vehicle dao
     */
    public static CarDAO getCarDAO()
    {
        return carDAO;
    }

    /**
     * Gets user dao.
     *
     * @return the user dao
     */
    public static UserDAO getUserDAO()
    {
        return userDAO;
    }
}

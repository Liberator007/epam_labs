package by.bsuir.carrental.dao;

import by.bsuir.carrental.dao.CarDao.CarDAO;

public class DaoFactory {

    private static CarDAO carDAO = new CarDAO();

    public static CarDAO getCarDAO()
    {
        return carDAO;
    }
}

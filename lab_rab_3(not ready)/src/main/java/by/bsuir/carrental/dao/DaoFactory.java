package by.bsuir.carrental.dao;

import by.bsuir.carrental.dao.VehicleDao.VehicleDAO;

public class DaoFactory {

    private static VehicleDAO vehicleDAO = new VehicleDAO();

    public static VehicleDAO getVehicleDAO()
    {
        return vehicleDAO;
    }
}

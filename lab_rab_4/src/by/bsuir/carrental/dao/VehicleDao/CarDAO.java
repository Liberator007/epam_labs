package by.bsuir.carrental.dao.VehicleDao;

import by.bsuir.carrental.dao.CarDB;
import by.bsuir.carrental.entity.Car;

import java.util.ArrayList;

/**
 * The type Vehicle dao.
 */
public class CarDAO implements ICarDAO {

    public ArrayList<Car> getVehicles() {
        return CarDB.select();
    }

    public Car getVehicle (int idCar)
    {
        return CarDB.selectOne(idCar);
    }

    public void addVehicle(String model, int yearIssue, int price, int seats, int rent) {
        CarDB.insert(new Car(model, yearIssue, price, seats, rent));
    }

    public void editVehicle(String model, int idCar, int yearIssue, int price, int seats, int rent) {
        CarDB.update(new Car(model, idCar, yearIssue, price, seats, rent));
    }

    public void deleteVehicle(int idCar)
    {
        CarDB.delete(idCar);
    }

}

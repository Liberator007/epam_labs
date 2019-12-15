package by.bsuir.carrental.dao.VehicleDao;

import java.io.IOException;
import java.util.ArrayList;

import by.bsuir.carrental.entity.Car;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

/**
 * The interface Vehicle dao.
 */
public interface ICarDAO {

    /**
     * Gets vehicles.
     *
     * @return the vehicles
     * @throws ParserConfigurationException the parser configuration exception
     * @throws SAXException                 the sax exception
     * @throws IOException                  the io exception
     * @throws XMLStreamException           the xml stream exception
     */
    ArrayList<Car> getVehicles() throws ParserConfigurationException, SAXException, IOException, XMLStreamException;

    /**
     * Delete vehicle.
     *
     * @param idCar the idcar
     */
    void deleteVehicle(int idCar);

    /**
     * Edit vehicle.
     *
     * @param model           the model
     * @param idCar           the idcar
     * @param yearIssue       the yearIssue
     * @param price           the price
     * @param seats           the seats
     * @param rent            the rent
     */
    void editVehicle(String model, int idCar, int yearIssue, int price, int seats, int rent);

    /**
     * Gets vehicle.
     *
     * @param idCar the idcar
     * @return the vehicle
     */
    Car getVehicle (int idCar);

    /**
     * Add vehicle.
     *
     * @param model           the model
     * @param yearIssue       the yearIssue
     * @param price           the price
     * @param seats           the seats
     * @param rent            the rent
     */
    void addVehicle(String model, int yearIssue, int price, int seats, int rent);
}

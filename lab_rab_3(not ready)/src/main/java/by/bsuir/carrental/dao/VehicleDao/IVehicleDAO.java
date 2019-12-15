package by.bsuir.carrental.dao.VehicleDao;

import java.io.IOException;
import java.util.ArrayList;
import by.bsuir.carrental.entity.Car;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

public interface IVehicleDAO {

    ArrayList<Car> getVehicles() throws ParserConfigurationException, SAXException, IOException, XMLStreamException;
}

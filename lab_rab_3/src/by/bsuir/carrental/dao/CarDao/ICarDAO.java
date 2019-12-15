package by.bsuir.carrental.dao.CarDao;

import java.io.IOException;
import java.util.ArrayList;
import by.bsuir.carrental.entity.Car;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

public interface ICarDAO {

    ArrayList<Car> getCars() throws ParserConfigurationException, SAXException, IOException, XMLStreamException;
}

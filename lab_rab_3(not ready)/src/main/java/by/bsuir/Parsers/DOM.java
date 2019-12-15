package by.bsuir.Parsers;

import by.bsuir.carrental.entity.Fuel;
import by.bsuir.carrental.entity.Car;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class DOM {
    public static final String CAR = "car";
    private List<Car> listCar;
    private static Logger log = Logger.getLogger(String.valueOf(DOM.class));

    public List<Car> getResult(String XMLPath) throws ParserConfigurationException, IOException, SAXException {

        log.info("DOM: Parsing started");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(XMLPath));

        NodeList vehicleElements = document.getDocumentElement().getElementsByTagName(CAR);

        listCar = new ArrayList<>();
        for (int i = 0; i < vehicleElements.getLength(); i++) {

            Node nNode = vehicleElements.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                Car car = new Car();

                car.setModel(eElement.getElementsByTagName("model").item(0).getTextContent());
                car.setId(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()));
                car.setYearIssue(Integer.parseInt(eElement.getElementsByTagName("yearIssue").item(0).getTextContent()));
                car.setPrice(Integer.parseInt(eElement.getElementsByTagName("price").item(0).getTextContent()));
                car.setSeats(Integer.parseInt(eElement.getElementsByTagName("seats").item(0).getTextContent()));
                car.setRent(Integer.parseInt(eElement.getElementsByTagName("rent").item(0).getTextContent()));
                car.setFuel(Fuel.valueOf(eElement.getElementsByTagName("fuel").item(0).getTextContent()));

                listCar.add(car);
            }
        }
        log.info("DOM: Parsing completed");
        return listCar;
    }
}

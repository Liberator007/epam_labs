package by.bsuir.Parsers;

import by.bsuir.carrental.entity.Fuel;
import by.bsuir.carrental.entity.Car;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Logger;

public class StAX implements AutoCloseable {
    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();
    private static Logger log = Logger.getLogger(String.valueOf(StAX.class));
    private final XMLStreamReader reader;

    private ArrayList<Car> listCar = new ArrayList<>();

    public ArrayList<Car> getResult() throws XMLStreamException {

        boolean endOfVehicleElement;
        log.info("StAX: Parsing started");
        while (reader.hasNext()) {       // while not end of XML
            int event = reader.next();   // read next event
            if (event == XMLEvent.START_ELEMENT &&
                    "car".equals(reader.getLocalName())) {
                Car car = new Car();

                endOfVehicleElement = false;
                while (reader.hasNext())
                {
                    if (reader.next() == XMLEvent.START_ELEMENT)
                        switch (reader.getLocalName())
                        {
                            case "model":
                                car.setModel(reader.getElementText());
                                break;
                            case "id":
                                car.setId(Integer.parseInt(reader.getElementText()));
                                break;
                            case "yearIssue":
                                car.setYearIssue(Integer.parseInt(reader.getElementText()));
                                break;
                            case "price":
                                car.setPrice(Integer.parseInt(reader.getElementText()));
                                break;
                            case "seats":
                                car.setSeats(Integer.parseInt(reader.getElementText()));
                                break;
                            case "rent":
                                car.setRent(Integer.parseInt(reader.getElementText()));
                                break;
                            case "fuel":
                                car.setFuel(Fuel.valueOf(reader.getElementText()));
                                endOfVehicleElement = true;
                                break;
                        }
                    if (endOfVehicleElement)
                        break;
                }

                listCar.add(car);
            }
        }
        log.info("StAX: Parsing completed");
        return listCar;
    }

    public StAX(InputStream is) throws XMLStreamException {
        reader = FACTORY.createXMLStreamReader(is);
    }


    public XMLStreamReader getReader() {
        return reader;
    }


    @Override
    public void close() {
        if (reader != null) {
            try {
                reader.close();
            } catch (XMLStreamException e) { // empty
            }
        }
    }
}

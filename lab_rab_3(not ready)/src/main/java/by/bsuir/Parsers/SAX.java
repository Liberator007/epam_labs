package by.bsuir.Parsers;

import by.bsuir.carrental.entity.Fuel;
import by.bsuir.carrental.entity.Car;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.util.*;
import java.util.logging.Logger;

public class SAX extends DefaultHandler {
    private Car car;
    private String thisElement = "";
    private ArrayList<Car> listCar = new ArrayList<Car>();
    private static Logger log = Logger.getLogger(String.valueOf(SAX.class));

    public ArrayList<Car> getResult(){  return listCar;  }

    @Override
    public void startDocument() throws SAXException {
        log.info("SAX: Parsing started");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;

        if (qName.equals("car")){
            car = new Car();
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
        if (qName.equals("car")){
            listCar.add(car);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("model")) {
            car.setModel(new String(ch, start, length));
        }
        if (thisElement.equals("id")) {
            car.setId(Integer.parseInt(new String(ch, start, length)));
        }
        if (thisElement.equals("yearIssue")) {
            car.setYearIssue(Integer.parseInt(new String(ch, start, length)));
        }
        if (thisElement.equals("price")) {
            car.setPrice(Integer.parseInt(new String(ch, start, length)));
        }
        if (thisElement.equals("seats")) {
            car.setSeats(Integer.parseInt(new String(ch, start, length)));
        }
        if (thisElement.equals("rent")) {
            car.setRent(Integer.parseInt(new String(ch, start, length)));
        }
        if (thisElement.equals("fuel")) {
            car.setFuel(Fuel.valueOf(new String(ch, start, length)));
        }
    }

    @Override
    public void endDocument() {
        log.info("SAX: Parsing completed");
    }
}

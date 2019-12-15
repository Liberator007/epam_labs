package by.bsuir.carrental.dao.CarDao;

import by.bsuir.Parsers.DOM;
import by.bsuir.Parsers.SAX;
import by.bsuir.Parsers.StAX;
import by.bsuir.carrental.entity.Car;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.util.ArrayList;

public class CarDAO implements ICarDAO {

    public ArrayList<Car> getCars() throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
        ArrayList<Car> listCar = null;
        String filePath = "C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\labs\\lab_rab_3\\save\\cars.xml";


        // SAX Parser
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SAX saxParser = new SAX();
        parser.parse(new File(filePath), saxParser);
        listCar = saxParser.getResult();


        /*
        // StAX Parser
        InputStream inputStream = new FileInputStream(filePath);
        StAX staxParser = new StAX(inputStream);
        listCar = staxParser.getResult();
        */

        /*
        // DOM Parser
        DOM domParser = new DOM();
        listCar = domParser.getResult(filePath);
        */

        return listCar;
    }


    private static String getDatabasePath(){
        return new File("").getAbsolutePath()+"C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\labs\\lab_rab_3(2)\\save\\cars.xml";
    }

}

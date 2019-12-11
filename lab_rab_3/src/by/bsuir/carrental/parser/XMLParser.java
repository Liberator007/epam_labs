package by.bsuir.carrental.parser;

import by.bsuir.carrental.entity.Car;
import by.bsuir.carrental.entity.Company;
import by.bsuir.carrental.exceptions.SaveFailedException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public final class XMLParser {
    public static void pullData(Object obj, String fullPath) throws SaveFailedException {
        try(XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(fullPath))){
            xmlEncoder.writeObject(obj);
            xmlEncoder.flush();
        }
        catch(IndexOutOfBoundsException | IOException ex){
            throw new SaveFailedException();
        }
    }

    public static void pullSubscribers(Company company, String fullPath ) throws Exception {
        DocumentBuilderFactory documentBuilderFactory;
        DocumentBuilder documentBuilder;
        Document document;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        documentBuilder = factory.newDocumentBuilder();
        document = documentBuilder.newDocument();
        Node root = document.createElement("company");
        List<Car> subscribersList = company.getListCar();
        document.appendChild(root);

        int i = 0;
        for (Car sub : subscribersList) {
            i++;
            Element subTag =  document.createElement("subscriber");

            subTag.setAttribute("id", Integer.toString(i));
            Element model = document.createElement("model");
            model.setTextContent(sub.getModel());
            subTag.appendChild(model);

            Element id = document.createElement("id");
            id.setTextContent(String.valueOf(sub.getId()));
            subTag.appendChild(id);

            Element yearIssue = document.createElement("yearIssue");
            yearIssue.setTextContent(String.valueOf(sub.getYearIssue()));
            subTag.appendChild(yearIssue);

            Element price = document.createElement("price");
            price.setTextContent(String.valueOf(sub.getPrice()));
            subTag.appendChild(price);

            Element seats = document.createElement("seats");
            seats.setTextContent(String.valueOf(sub.getSeats()));
            subTag.appendChild(seats);

            Element rent = document.createElement("rent");
            rent.setTextContent(String.valueOf(sub.isRent()));
            subTag.appendChild(rent);

            root.appendChild(subTag);
        }


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(fullPath));
        transformer.transform(source, result);
    }

}

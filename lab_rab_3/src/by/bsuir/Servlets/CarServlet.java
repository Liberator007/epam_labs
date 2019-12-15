package by.bsuir.Servlets;

import by.bsuir.carrental.dao.DaoFactory;
import by.bsuir.carrental.entity.Car;
import org.xml.sax.SAXException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Logger;

public class CarServlet extends HttpServlet {

    private static Logger log = Logger.getLogger(String.valueOf(CarServlet.class));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Car> listCar = null;
        try {
            listCar = DaoFactory.getCarDAO().getCars();
        } catch (ParserConfigurationException | XMLStreamException | SAXException e) {
            log.info(e.getMessage());
        }

        req.setAttribute("listCar", listCar);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}

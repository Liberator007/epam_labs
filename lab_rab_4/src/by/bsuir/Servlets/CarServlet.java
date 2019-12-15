package by.bsuir.Servlets;

import by.bsuir.carrental.dao.DaoFactory;
import by.bsuir.carrental.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Vehicle servlet.
 */
public class CarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Car> vehicles = DaoFactory.getCarDAO().getVehicles();
        req.setAttribute("vehicleList", vehicles);

        getServletContext().getRequestDispatcher("/views/vehicle.jsp").forward(req, resp);

    }
}

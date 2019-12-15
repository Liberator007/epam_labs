package by.bsuir.Servlets;

import by.bsuir.carrental.dao.DaoFactory;
import by.bsuir.carrental.entity.Fuel;
import by.bsuir.carrental.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * The type Edit servlet.
 */
public class EditServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(String.valueOf(EditServlet.class));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Car car = DaoFactory.getCarDAO().getVehicle(id);
            if(car != null) {
                req.setAttribute("vehicle", car);
                getServletContext().getRequestDispatcher("/views/edit.jsp").forward(req, resp);
            }
            else {
                resp.sendRedirect(req.getContextPath()+"/vehicles");
            }
        }
        catch(Exception ex) {
            log.info(ex.getMessage());
            resp.sendRedirect(req.getContextPath()+"/vehicles");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            log.info("Editing routine started...");
            DaoFactory.getCarDAO().editVehicle(req.getParameter("model"), Integer.parseInt(req.getParameter("idCar")),
                    Integer.parseInt(req.getParameter("yearIssue")), Integer.parseInt(req.getParameter("price")),
                    Integer.parseInt(req.getParameter("seats")), Integer.parseInt(req.getParameter("rent")));
            log.info("Edit: Successful");
            resp.sendRedirect(req.getContextPath()+"/vehicles");
        }
        catch(Exception ex) {
            log.info(ex.getMessage());
            getServletContext().getRequestDispatcher("/views/edit.jsp").forward(req, resp);
        }
    }
}

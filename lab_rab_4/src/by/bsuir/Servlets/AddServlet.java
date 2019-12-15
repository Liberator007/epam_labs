package by.bsuir.Servlets;

import by.bsuir.carrental.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * The type Add servlet.
 */
public class AddServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(String.valueOf(AddServlet.class));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/views/add.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            log.info("Adding routine started...");
            DaoFactory.getCarDAO().addVehicle(req.getParameter("model"),
                    Integer.parseInt(req.getParameter("yearIssue")), Integer.parseInt(req.getParameter("price")),
                    Integer.parseInt(req.getParameter("seats")), Integer.parseInt(req.getParameter("rent")));
            log.info("Add: Successful");
            resp.sendRedirect(req.getContextPath()+"/vehicles");
        }
        catch(Exception ex) {
            log.info(ex.getMessage());
            getServletContext().getRequestDispatcher("/views/add.jsp").forward(req, resp);
        }
    }
}

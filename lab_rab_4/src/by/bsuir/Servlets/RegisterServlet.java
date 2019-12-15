package by.bsuir.Servlets;

import by.bsuir.carrental.dao.DaoFactory;
import by.bsuir.carrental.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * The type Register servlet.
 */
public class RegisterServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(String.valueOf(RegisterServlet.class));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/views/register.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            log.info("Register routine started...");
            User user = DaoFactory.getUserDAO().getUserByName(req.getParameter("name"));
            if(user != null) {
                req.setAttribute("message", "This name already exists");
                log.info("Register: Name already exists");
                getServletContext().getRequestDispatcher("/views/register.jsp").forward(req, resp);
            }
            else {
                DaoFactory.getUserDAO().addUser(req.getParameter("name"), req.getParameter("password"));
                log.info("Register: Successful");
                resp.sendRedirect(req.getContextPath()+"/login");
            }
        }
        catch(Exception ex) {
            log.info(ex.getMessage());
            req.setAttribute("message", "Error");
            getServletContext().getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }
    }
}

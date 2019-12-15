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
 * The type Login servlet.
 */
public class LoginServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(String.valueOf(AddServlet.class));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/views/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            log.info("Log in routine started...");
            User user = DaoFactory.getUserDAO().getUser(req.getParameter("name"), req.getParameter("password"));
            if(user != null) {
                log.info("Log in: Successful");
                resp.sendRedirect(req.getContextPath()+"/vehicles");
            }
            else {
                log.info("Log in: Wrong data input");
                resp.sendRedirect(req.getContextPath()+"/login");
            }
        }
        catch(Exception ex) {
            log.info(ex.getMessage());
            resp.sendRedirect(req.getContextPath()+"/login");
        }
    }
}

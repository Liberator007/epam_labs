package by.bsuir.carrental.dao;

import by.bsuir.carrental.entity.User;

import java.sql.*;
import java.util.logging.Logger;

/**
 * The type User db.
 */
public class UserDB {

    private static Logger log = Logger.getLogger(String.valueOf(UserDB.class));
    private static String url = "jdbc:mysql://localhost:3306/mysql?serverTimezone=Europe/Minsk&useSSL=false";
    private static String username = "root";
    private static String password = "root";

    /**
     * Select one user.
     *
     * @param _name     the name
     * @param _password the password
     * @return the user
     */
    public static User selectOne(String _name, String _password) {

        User user = null;
        try{
            log.info("DB selecting one routine started...");
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM users WHERE name=? AND password=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, _name);
                    preparedStatement.setString(2, _password);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        user = new User(_name, _password);
                    }
                    log.info("Select one: Successful");
                }
            }
        }
        catch(Exception ex){
            log.info(ex.getMessage());
        }
        return user;
    }

    /**
     * Select one by name user.
     *
     * @param _name the name
     * @return the user
     */
    public static User selectOneByName(String _name) {

        User user = null;
        try{
            log.info("DB selecting one routine started...");
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM users WHERE name=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, _name);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        user = new User(_name, resultSet.getString(2));
                    }
                    log.info("Select one by name: Successful");
                }
            }
        }
        catch(Exception ex){
            log.info(ex.getMessage());
        }
        return user;
    }

    /**
     * Insert int.
     *
     * @param user the user
     * @return the int
     */
    public static int insert(User user) {

        try{
            log.info("DB inserting routine started...");
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO users (name, password) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, user.getName());
                    preparedStatement.setString(2, user.getPassword());

                    log.info("Insert: Successful");
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            log.info(ex.getMessage());
        }
        return 0;
    }


}

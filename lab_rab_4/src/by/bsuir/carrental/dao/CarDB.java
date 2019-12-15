package by.bsuir.carrental.dao;

import by.bsuir.carrental.entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * The type Vehicle db.
 */
public class CarDB {

        private static Logger log = Logger.getLogger(String.valueOf(CarDB.class));
        private static String url = "jdbc:mysql://localhost:3306/mysql?serverTimezone=Europe/Minsk&useSSL=false";
        private static String username = "root";
        private static String password = "root";

    /**
     * Select array list.
     *
     * @return the array list
     */
    public static ArrayList<Car> select() {

            ArrayList<Car> listCar = new ArrayList<Car>();
            try{
                log.info("DB selecting routine started...");
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM carrental");
                    while(resultSet.next()){
                        String model = resultSet.getString(1);
                        int idCar = resultSet.getInt(2);
                        int yearIssue = resultSet.getInt(3);
                        int price = resultSet.getInt(4);
                        int seats = resultSet.getInt(5);
                        int rent = resultSet.getInt(6);
                        Car car = new Car(model, idCar, yearIssue, price, seats, rent);
                        listCar.add(car);
                    }
                    log.info("Select: Successful");
                }
            }
            catch(Exception ex){
                log.info(ex.getMessage());
            }
            return listCar;
        }

    /**
     * Select one car.
     *
     * @param idCar the idCar
     * @return the vehicle
     */
    public static Car selectOne(int idCar) {

            Car car = null;
            try{
                log.info("DB selecting one routine started...");
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    String sql = "SELECT * FROM carrental WHERE idcar=?";
                    try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                        preparedStatement.setInt(2, idCar);
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if(resultSet.next()){
                            String model = resultSet.getString(1);
                            int yearIssue = resultSet.getInt(3);
                            int price = resultSet.getInt(4);
                            int seats = resultSet.getInt(5);
                            int rent = resultSet.getInt(6);
                            car = new Car(model, idCar, yearIssue, price, seats, rent);
                        }
                        log.info("Select one: Successful");
                    }
                }
            }
            catch(Exception ex){
                log.info(ex.getMessage());
            }
            return car;
        }

    /**
     * Insert int.
     *
     * @param car the car
     * @return the int
     */
    public static int insert(Car car) {

            try{
                log.info("DB inserting routine started...");
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    String sql = "INSERT INTO carrental (model, idCar, yearIssue, price, seats, rent) Values (?, ?, ?, ?, ?, ?, ?)";
                    try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                        preparedStatement.setString(1, car.getModel());
                        preparedStatement.setInt(2, car.getId());
                        preparedStatement.setInt(3, car.getYearIssue());
                        preparedStatement.setInt(4, car.getPrice());
                        preparedStatement.setInt(5, car.getSeats());
                        preparedStatement.setInt(6, car.getRent());

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

    /**
     * Update int.
     *
     * @param car the car
     * @return the int
     */
    public static int update(Car car) {

            try{
                log.info("DB updating routine started...");
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    String sql = "UPDATE carrental SET model = ?, idCar = ?, yearIssue = ?, price = ?, seats = ?, rent = ? WHERE idCar = ?";
                    try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                        preparedStatement.setString(1, car.getModel());
                        preparedStatement.setInt(2, car.getId());
                        preparedStatement.setInt(3, car.getYearIssue());
                        preparedStatement.setInt(4, car.getPrice());
                        preparedStatement.setInt(5, car.getSeats());
                        preparedStatement.setInt(6, car.getRent());

                        log.info("Update: Successful");
                        return  preparedStatement.executeUpdate();
                    }
                }
            }
            catch(Exception ex){
                log.info(ex.getMessage());
            }
            return 0;
        }

    /**
     * Delete int.
     *
     * @param idCar the idCar
     * @return the int
     */
    public static int delete(int idCar) {

            try{
                log.info("DB deleting routine started...");
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    String sql = "DELETE FROM carrental WHERE idCar = ?";
                    try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                        preparedStatement.setInt(2, idCar);

                        log.info("Delete: Successful");
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

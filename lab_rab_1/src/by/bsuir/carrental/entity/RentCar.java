package by.bsuir.carrental.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RentCar implements Serializable {
    private Car car;
    private Date startDate;
    private Date endDate;
    private Address departurePoint;

    public RentCar(Car car, Date startDate, Date endDate, Address departurePoint) {
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.departurePoint = departurePoint;
    }

    public RentCar() {

    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setDeparturePoint(Address departurePoint) {
        this.departurePoint = departurePoint;
    }

    public Car getCar() {
        return car;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Address getDeparturePoint() {
        return departurePoint;
    }
/*
    public String writeRentCar(char l){
        return getCar().writeCar('|') + l + getStartDate() + "|" + getEndDate() + "|" + getDeparturePoint().writeAddress('|');
    }

    public void readRentCar(String str, char l) throws ParseException {
        int index;
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        car.readCar(str, l);

        index = str.indexOf(l);
        Date startDate = dateFormat.parse(str.substring(0, index));
        setStartDate(startDate);
        str.substring(index + 1);

        index = str.indexOf(l);
        Date endDate = dateFormat.parse(str.substring(0, index));
        setEndDate(endDate);
        str.substring(index + 1);

        departurePoint.readAddress(str, l);

    }

 */
}

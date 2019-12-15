package by.bsuir.carrental.entity;

import java.io.Serializable;

public class Car implements Serializable {
    private String model;
    private int idCar;
    private int yearIssue;
    private int price;
    private int seats;
    private int rent;

    public Car(String model, int idCar, int yearIssue, int price, int seats, int rent) {
        this.model = model;
        this.idCar = idCar;
        this.yearIssue = yearIssue;
        this.price = price;
        this.seats = seats;
        this.rent = rent;
    }

    public Car(String model, int yearIssue, int price, int seats, int rent) {
        this.model = model;
        this.yearIssue = yearIssue;
        this.price = price;
        this.seats = seats;
        this.rent = rent;
    }

    public Car() {

    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setId(int idCar) {
        this.idCar = idCar;
    }

    public void setYearIssue(int yearIssue) {
        this.yearIssue = yearIssue;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getModel() {
        return model;
    }

    public int getId() {
        return idCar;
    }

    public int getYearIssue() {
        return yearIssue;
    }

    public int getPrice() {
        return price;
    }

    public int getSeats() {
        return seats;
    }

    public int getRent() {
        return rent;
    }

}

package by.bsuir.carrental.entity;

import java.io.Serializable;

public class Car implements Serializable {
    private String model;
    private int id;
    private int yearIssue;
    private int price;
    private int seats;
    private int rent;
    private Fuel fuel;

    public Car(String model, int id, int yearIssue, int price, int seats, int rent, Fuel fuel) {
        this.model = model;
        this.id = id;
        this.yearIssue = yearIssue;
        this.price = price;
        this.seats = seats;
        this.rent = rent;
        this.fuel = fuel;
    }

    public Car() {

    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public String getModel() {
        return model;
    }

    public int getId() {
        return id;
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

    public Fuel getFuel() {
        return fuel;
    }

}

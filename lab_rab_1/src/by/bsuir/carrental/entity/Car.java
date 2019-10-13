package by.bsuir.carrental.entity;

import java.io.Serializable;

public class Car implements Serializable {
    private String model;
    private int id;
    private int yearIssue;
    private int price;
    private int seats;
    private boolean rent;

    public Car(String model, int id, int yearIssue, int price, int seats, boolean rent) {
        this.model = model;
        this.id = id;
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

    public void setRent(boolean rent) {
        this.rent = rent;
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

    public boolean isRent() {
        return rent;
    }
/*
    public String writeCar(char l){
        return getModel() + l + getId() + l + getYearIssue() + l + getPrice() + l + getSeats() + l + isRent();
    }

    public void readCar(String str, char l) {
        int index;

        index = str.indexOf(l);
        setModel(str.substring(0, index));
        str.substring(index + 1);

        index = str.indexOf(l);
        setId(Integer.parseInt(str.substring(0, index)));
        str.substring(index + 1);

        index = str.indexOf(l);
        setYearIssue(Integer.parseInt(str.substring(0, index)));
        str.substring(index + 1);

        index = str.indexOf(l);
        setPrice(Integer.parseInt(str.substring(0, index)));
        str.substring(index + 1);

        index = str.indexOf(l);
        setSeats(Integer.parseInt(str.substring(0, index)));
        str.substring(index + 1);

        index = str.indexOf(l);
        if (index != -1)
        {
            setRent(Boolean.parseBoolean(str.substring(0, index)));
            str.substring(index + 1);
        }
        else
        {
            setRent(Boolean.parseBoolean(str));
        }
    }

 */
}

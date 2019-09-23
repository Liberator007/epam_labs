package com.bsuir.autobase.entity;

public class Car{
    private String model;
    private int id;
    private int yearIssue;
    private int seats;
    private boolean rent;
    private Company company;

    public Car(String model, int id, int yearIssue, int seats, boolean rent, Company company) {
        this.model = model;
        this.id = id;
        this.yearIssue = yearIssue;
        this.seats = seats;
        this.rent = rent;
        this.company = company;
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

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    public int getSeats() {
        return seats;
    }

    public boolean isRent() {
        return rent;
    }

    public Company getCompany() {
        return company;
    }
}

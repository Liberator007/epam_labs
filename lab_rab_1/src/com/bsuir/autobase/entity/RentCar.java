package com.bsuir.autobase.entity;

import java.util.Date;

public class RentCar extends Car{
    private Client client;
    private Date startDate;
    private Date endDate;
    private Address departurePoint;

    public RentCar(String model, int id, int yearIssue, int seats, boolean rent, Company company, Client client, Date startDate, Date endDate, Address departurePoint) {
        super(model, id, yearIssue, seats, rent, company);
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.departurePoint = departurePoint;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public Client getClient() {
        return client;
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
}

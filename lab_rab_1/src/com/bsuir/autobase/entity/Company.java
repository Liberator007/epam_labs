package com.bsuir.autobase.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

public class Company implements Serializable {
    private String name;
    private Address address;
    private List<Car> listCar;

    public Company(String name, Address address, List<Car> listCar) {
        this.name = name;
        this.address = address;
        this.listCar = listCar;
    }

    public Company() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListCar(List<Car> listCar) {
        this.listCar = listCar;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<Car> getListCar() {
        return listCar;
    }

    public String writeCompany(char l){
        return getName() + l + getAddress().writeAddress('|');
    }

    public void readCompany(String str, char l) {
        int index;

        index = str.indexOf(l);
        setName(str.substring(0, index));
        str = str.substring(index + 1);


        getAddress().readAddress(str, l);

        setListCar(null);
    }
}

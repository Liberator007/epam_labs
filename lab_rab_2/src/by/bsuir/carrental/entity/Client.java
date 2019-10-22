package by.bsuir.carrental.entity;

import java.io.Serializable;
import java.text.ParseException;

public class Client implements Serializable {
    private String name;
    private String surname;
    private Address address;
    private int id;
    private RentCar rentCar;

    public Client(String name, String surname, Address address, int id, RentCar rentCar) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.id = id;
        this.rentCar = rentCar;
    }

    public Client() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCar(RentCar rentCar) {
        this.rentCar = rentCar;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Address getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public RentCar getCar() {
        return rentCar;
    }
/*
    public String writeClient(char l){
        return getName() + l + getSurname() + l + getAddress().writeAddress('|') + l + getId() + l + getCar().writeRentCar('|');
    }

    public void readClient(String str, char l) throws ParseException {
        int index;

        index = str.indexOf(l);
        setName(str.substring(0, index));
        str.substring(index + 1);

        index = str.indexOf(l);
        setSurname(str.substring(0, index));
        str.substring(index + 1);

        address.readAddress(str, l);

        index = str.indexOf(l);
        setId(Integer.parseInt(str.substring(0, index)));
        str.substring(index + 1);

        rentCar.readRentCar(str, l);
    }

 */
}

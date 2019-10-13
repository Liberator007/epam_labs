package by.bsuir.carrental.entity;

import java.io.Serializable;

public class Address implements Serializable {
    private String city;
    private String street;
    private int houseNumber;

    public Address(String city, String street, int houseNumber) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public Address() {

    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }
/*
    public String writeAddress(char l){
        return getCity() + l + getStreet() + l + getHouseNumber();
    }

    public void readAddress(String str, char l){
        int index;

        index = str.indexOf(l);
        setCity(str.substring(0, index));
        str = str.substring(index + 1);

        index = str.indexOf(l);
        setStreet(str.substring(0, index));
        str = str.substring(index + 1);

        index = str.indexOf(l);
        if (index != -1)
        {
            setHouseNumber(Integer.parseInt(str.substring(0, index)));
            str = str.substring(index + 1);
        }
        else
        {
            setHouseNumber(Integer.parseInt(str));
        }

    }

 */

}

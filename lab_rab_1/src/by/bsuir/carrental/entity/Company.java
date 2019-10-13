package by.bsuir.carrental.entity;

import java.io.Serializable;
import java.util.List;

public class Company implements Serializable {
    private String name;
    private Address address;
    private List<Car> listCar;
    private List<Client> listClient;

    public Company(String name, Address address, List<Car> listCar) {
        this.name = name;
        this.address = address;
        this.listCar = listCar;
    }

    public Company(String name, Address address, List<Car> listCar, List<Client> listClient) {
        this.name = name;
        this.address = address;
        this.listCar = listCar;
        this.listClient = listClient;
    }

    public Company() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListCar(List<Car> listCar) {
        this.listCar = listCar;
    }

    public void setListClient(List<Client> listClient) {
        this.listClient = listClient;
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

    public List<Client> getListClient() {
        return listClient;
    }
/*
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

 */
}

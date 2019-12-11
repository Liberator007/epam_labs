package by.bsuir.carrental.parser;

import by.bsuir.carrental.entity.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TXTParser {
    public String writeCompany(Company company, char l){
        return company.getName() + l + writeAddress(company.getAddress(), '|');
    }

    public Company readCompany(String str, char l) {
        int index;
        Company company = new Company();
        index = str.indexOf(l);
        company.setName(str.substring(0, index));
        str = str.substring(index + 1);

        company.setAddress(readAddress(str, l));

        company.setListCar(null);
        company.setListClient(null);

        return company;
    }

    private String writeAddress(Address address, char l){
        return address.getCity() + l + address.getStreet() + l + address.getHouseNumber();
    }

    private Address readAddress(String str, char l){
        int index;
        Address address = new Address();
        index = str.indexOf(l);
        address.setCity(str.substring(0, index));
        str = str.substring(index + 1);

        index = str.indexOf(l);
        address.setStreet(str.substring(0, index));
        str = str.substring(index + 1);

        index = str.indexOf(l);
        if (index != -1)
        {
            address.setHouseNumber(Integer.parseInt(str.substring(0, index)));
            str = str.substring(index + 1);
        }
        else
        {
            address.setHouseNumber(Integer.parseInt(str));
        }
        return address;
    }

    public String writeCar(Car car, char l){
        return car.getModel() + l + car.getId() + l + car.getYearIssue() + l + car.getPrice() + l + car.getSeats() + l + car.isRent();
    }

    public Car readCar(String str, char l) {
        int index;
        Car car = new Car();

        index = str.indexOf(l);
        car.setModel(str.substring(0, index));
        str = str.substring(index + 1);

        index = str.indexOf(l);
        car.setId(Integer.parseInt(str.substring(0, index)));
        str = str.substring(index + 1);

        index = str.indexOf(l);
        car.setYearIssue(Integer.parseInt(str.substring(0, index)));
        str = str.substring(index + 1);

        index = str.indexOf(l);
        car.setPrice(Integer.parseInt(str.substring(0, index)));
        str = str.substring(index + 1);

        index = str.indexOf(l);
        car.setSeats(Integer.parseInt(str.substring(0, index)));
        str.substring(index + 1);

        index = str.indexOf(l);
        if (index != -1)
        {
            car.setRent(Boolean.parseBoolean(str.substring(0, index)));
            str = str.substring(index + 1);
        }
        else
        {
            car.setRent(Boolean.parseBoolean(str));
        }

        return car;
    }

    private String writeRentCar(RentCar rentCar, char l){
        return writeCar(rentCar.getCar(),'|') + l + rentCar.getStartDate() + "|" + rentCar.getEndDate() + "|" + writeAddress(rentCar.getDeparturePoint(),'|');
    }

    private RentCar readRentCar(String str, char l) {
        int index;
        RentCar rentCar = new RentCar();

        SimpleDateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

        try {
            rentCar.setCar(readCar(str, l));
            for (int i=0; i<6; i++) {
                index = str.indexOf(l);
                str = str.substring(index + 1);
            }

            index = str.indexOf(l);
            Date startDate = dateFormat.parse(str.substring(0, index));
            rentCar.setStartDate(startDate);
            str = str.substring(index + 1);

            index = str.indexOf(l);
            Date endDate = dateFormat.parse(str.substring(0, index));
            rentCar.setEndDate(endDate);
            str = str.substring(index + 1);

            rentCar.setDeparturePoint(readAddress(str, l));
        }
        catch(ParseException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rentCar;
    }

    public String writeClient(Client client, char l){
        return client.getName() + l + client.getSurname() + l + writeAddress(client.getAddress(), '|') + l + client.getId() + l + writeRentCar(client.getCar(),'|');
    }

    public Client readClient(String str, char l) {
        int index;
        Client client = new Client();

        index = str.indexOf(l);
        client.setName(str.substring(0, index));
        str = str.substring(index + 1);

        index = str.indexOf(l);
        client.setSurname(str.substring(0, index));
        str = str.substring(index + 1);

        client.setAddress(readAddress(str, l));
        // str ссылкой не передается, значение остается такое же, вручную здесь обрезать из строки часть Адреса
        //
        //
        //
        for (int i=0; i<3; i++) {
            index = str.indexOf(l);
            str = str.substring(index + 1);
        }
        /*
        index = str.indexOf(l);
        str = str.substring(index + 1);
         */

        index = str.indexOf(l);
        client.setId(Integer.parseInt(str.substring(0, index)));
        str = str.substring(index + 1);

        client.setCar(readRentCar(str, l));

        return client;
    }
}

package by.bsuir.carrental.implementation;

import by.bsuir.carrental.entity.*;
import by.bsuir.carrental.parser.TXTParser;
import by.bsuir.carrental.service.*;

import java.util.*;
import java.io.IOException;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        int number;

        Company company = null;

        // Read ListCar
        company = readObject();   // Load data from *.txt file

        // Screen ListCar
        for(Car  c : company.getListCar()){
            System.out.println(c.getModel() + " " + c.getYearIssue());
        }
        System.out.println();

        // Sort by Year of Issue car
        Collections.sort(company.getListCar(), new CarYearIssueComparator());
        for(Car  c : company.getListCar()){
            System.out.println(c.getModel() + " " + c.getYearIssue());
        }
        System.out.println();

        // Delete Object
        company = deleteObject(company, 751);  // Delete object

        // Create Object
        Car car2 = new Car("Audi",751,2019,400,2,true);
        company.getListCar().add(car2);
        Car car3 = new Car("Volvo",1031,2014,40,5,true);
        company.getListCar().add(car3);

        // Screen ListCar
        for(Car  c : company.getListCar()){
            System.out.println(c.getModel() + " " + c.getYearIssue());
        }

        // Search ListCar
        System.out.println();
        searchObject(company, car3);
        System.out.println();

        // Update Object
        Car car = new Car("Lada", 7731, 2006,20, 5,false);
        car.setModel("Grob");
        updateObject(company, car);   // Update object

        // Sort by model car
        Collections.sort(company.getListCar(), new CarModelComparator());
        for(Car  c : company.getListCar()){
            System.out.println(c.getModel() + " " + c.getYearIssue());
        }

        // Save ListCar
        saveObject(company);  // Save data in *.txt file
    }

    // Save data in *.txt file
    public static void saveObject(Company company){
        String path = "C:/Users/Антон/Documents/GitHub/epam_labs/lab_rab_1/src/save/";
        String filename = "";
        String info = "";
        TXTParser txtParser = new TXTParser();

        if (company != null)
        {
            filename = "Company";
            info = txtParser.writeCompany(company,'|');

            try(FileWriter file = new FileWriter(path + filename + ".txt", false))
            {
                file.write(info);
                file.append('\n');
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }

        if (company.getListClient() != null)
        {
            filename = "Client";

            try(FileWriter file = new FileWriter(path + filename + ".txt", false))
            {
                for (int i=0; i < company.getListClient().size(); i++)
                {
                    file.write(txtParser.writeClient(company.getListClient().get(i),'|'));
                    file.append('\n');
                }
                file.flush();
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }

        if (company.getListCar() != null)
        {
            filename = "Car";

            try(FileWriter file = new FileWriter(path + filename + ".txt", false))
            {
                for (int i=0; i < company.getListCar().size(); i++)
                {
                    file.write(txtParser.writeCar(company.getListCar().get(i),'|'));
                    file.append('\n');
                }
                file.flush();
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }

    // Load data from *.txt file
    public static Company readObject(){
        String path = "C:/Users/Антон/Documents/GitHub/epam_labs/lab_rab_1/src/save/";
        String filename = "";
        String info = "";
        Company company = new Company();

        TXTParser txtParser = new TXTParser();

        if (company != null)
        {
            filename = "Company";

            try(FileReader file = new FileReader (path + filename + ".txt"))
            {

                String word = "";
                int c;

                while((c = file.read()) != -1)
                {
                    if ((char)c != '\r')
                    {
                        if ((char)c != '\n')
                            word += (char) c;
                        else {
                            company = txtParser.readCompany(word, '|');
                            word = "";
                        }
                    }

                }
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }

        }

        if (company.getListClient() == null)
        {
            filename = "Client";
            List<Client> listClient = new ArrayList<>();

            try(FileReader file = new FileReader(path + filename + ".txt"))
            {
                String word = "";
                int c;

                while((c = file.read()) != -1)
                {
                    if ((char)c != '\r')
                    {
                        if ((char)c != '\n')
                            word += (char) c;
                        else {
                            Client client = null;
                            client = txtParser.readClient(word, '|');
                            listClient.add(client);
                            word = "";
                        }
                    }
                }
                company.setListClient(listClient);
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }

        if (company.getListCar() == null)
        {
            filename = "Car";
            List<Car> listCar = new ArrayList<>();

            try(FileReader file = new FileReader(path + filename + ".txt"))
            {
                String word = "";
                int c;

                while((c = file.read()) != -1)
                {
                    if ((char)c != '\r')
                    {
                        if ((char)c != '\n')
                            word += (char) c;
                        else {
                            Car car = null;
                            car = txtParser.readCar(word, '|');
                            listCar.add(car);
                            word = "";
                        }
                    }
                }
                company.setListCar(listCar);
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }

        return company;

    }

    // Delete object
    public static Company deleteObject(Company company, int id){
        List<Car> listCar = company.getListCar();
        for (Car car : listCar)
        {
            if (car.getId() == id)
            {
                listCar.remove(car);
                return company;
            }
        }
        company.setListCar(listCar);
        return company;
    }

    // Update object
    public static Company updateObject(Company company, Car newCar){
        List<Car> listCar = company.getListCar();
        for (Car car : listCar) {

            if (car.getId() == newCar.getId()) {
                listCar.remove(car);
                listCar.add(newCar);
                return company;
            }
        }
        company.setListCar(listCar);
        return company;
    }

    // Search object
    public static void searchObject(Company company, Car searchCar){
        List<Car> listCar = company.getListCar();
        for (Car car : listCar)
        {
            if (car.getId() == searchCar.getId())
            {
                listCar.remove(car);
                System.out.println(screenObject(car, ' '));
                return;
            }
        }
    }

    // Screen object
    public static String screenObject(Object obj, char l){
        if (obj instanceof Car) {
            Car car = (Car) obj;
            return car.getModel() + l + car.getId() + l + car.getYearIssue() + l + car.getPrice() + l + car.getSeats() + l + car.isRent();
        }
        return "";
    }
}

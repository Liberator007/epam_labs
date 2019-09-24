package com.bsuir.autobase.entity;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;

class CarModelComparator implements Comparator<Car>{
    @Override
    public int compare(Car a, Car b){

        return a.getModel().compareTo(b.getModel());
    }
}

class CarYearIssueComparator implements Comparator<Car>{
    @Override
    public int compare(Car a, Car b){

        if(a.getYearIssue()> b.getYearIssue())
            return 1;
        else if(a.getYearIssue()< b.getYearIssue())
            return -1;
        else
            return 0;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        List<Client> listClient = new ArrayList<>();
        List<Car> listCar = new ArrayList<>();
        int number;

// Start test Example
        Car car1 = new Car("Lada", 7731, 2006,20, 5,false);
        listCar.add(car1);
        Car car2 = new Car("Audi", 751, 2019,400, 2,true);
        listCar.add(car2);
        Car car3 = new Car("Volvo", 1031, 2014,40, 5,true);
        listCar.add(car3);

        Address addressClient = new Address("Минск", "Победителей", 108);

        Date startDate = new Date();
        Date endDate = new Date(0, 0, 0, 12, 0 , 0);
        endDate.setTime(startDate.getTime() + endDate.getTime());

        RentCar rentCar = new RentCar(car1, startDate, endDate, addressClient);

        Client client = new Client("Anton", "Salyava", addressClient, 239498, rentCar);
        listClient.add(client);

        Address addressCompany = new Address("Минск", "Тимирязева", 92);
        Company company = new Company("Hello", addressCompany, listCar);

        for(Car  c : company.getListCar()){
            System.out.println(c.getModel() + " " + c.getYearIssue());
        }
        System.out.println();

        readObject(company, listClient, listCar);   // Load data from *.txt file

        company.setListCar(listCar);

        // Sort by Year of Issue car
        Collections.sort(company.getListCar(), new CarYearIssueComparator());
        for(Car  c : company.getListCar()){
            System.out.println(c.getModel() + " " + c.getYearIssue());
        }
        System.out.println();

        deleteObject(listCar, 751);  // Delete object

        for(Car  c : company.getListCar()){
            System.out.println(c.getModel() + " " + c.getYearIssue());
        }

        System.out.println();
        car3.setModel("Bugatti");
        updateObject(listCar, car3);   // Update object
        // Sort by model car
        Collections.sort(company.getListCar(), new CarModelComparator());
        for(Car  c : company.getListCar()){
            System.out.println(c.getModel() + " " + c.getYearIssue());
        }

        saveObject(company, listClient, listCar);  // Save data in *.txt file
// End test Example
    }
    // Save data in *.txt file
    public static void saveObject(Object o, List<Client> listClient, List<Car> listCar){
        String path = "save/";
        String filename = "";
        String info = "";

        if (o instanceof Company)
        {
            Company company =  ((Company) o);
            filename = "Company";
            info = company.getName() + '|' + company.getAddress().writeAddress('|');

            try(FileWriter file = new FileWriter(path + filename + ".txt", false))
            {
                file.write(info);
                file.append('\n');
                file.append('\r');
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }

        if (listClient != null)
        {
            filename = "Client";

            try(FileWriter file = new FileWriter(path + filename + ".txt", false))
            {
                for (int i=0; i < listClient.size(); i++)
                {
                    file.write(listClient.get(i).writeClient('|'));
                    file.append('\n');
                    file.append('\r');
                }
                file.flush();
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }

        if (listCar != null)
        {
            filename = "Car";

            try(FileWriter file = new FileWriter(path + filename + ".txt", false))
            {
                for (int i=0; i < listCar.size(); i++)
                {
                    file.write(listCar.get(i).writeCar('|'));
                    file.append('\n');
                    file.append('\r');
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
    public static void readObject(Company company, List<Client> listClient, List<Car> listCar){
        String path = "save/";
        String filename = "";
        String info = "";
        if (true)
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
                            company.readCompany(word, '|');
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

        if (listClient != null)
        {
            filename = "Client";

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
                            client.readClient(word, '|');
                            listClient.add(client);
                            word = "";
                        }
                    }

                }
            }
            catch(IOException | ParseException ex)
            {
                System.out.println(ex.getMessage());
            }
        }

        if (listCar != null)
        {
            filename = "Car";

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
                            car.readCar(word, '|');
                            listCar.add(car);
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


    }
    // Delete object
    public static void deleteObject(List<Car> listCar, int id){
        for (Car car : listCar)
        {
            if (car.getId() == id)
            {
                listCar.remove(car);
                return;
            }
        }
    }
    // Update object
    public static void updateObject(List<Car> listCar, Car newCar){
        for (Car car : listCar) {

            if (car.getId() == newCar.getId()) {
                listCar.remove(car);
                listCar.add(newCar);
                return;
            }
        }
    }


}

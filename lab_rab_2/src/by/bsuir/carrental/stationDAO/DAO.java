package by.bsuir.carrental.stationDAO;

import by.bsuir.carrental.entity.Car;
import by.bsuir.carrental.entity.Client;
import by.bsuir.carrental.entity.Company;
import by.bsuir.carrental.exceptions.CantLoadException;
import by.bsuir.carrental.exceptions.DaoGetException;
import by.bsuir.carrental.exceptions.DaoSaveException;
import by.bsuir.carrental.exporter.SQLExporter;
import by.bsuir.carrental.parser.TXTParser;
import by.bsuir.carrental.parser.XMLParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public static Company getData(){
        String path = "C:/Users/Антон/Documents/GitHub/epam_labs/lab_rab_2/src/save/";
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

    public static void setData(Object obj) throws DaoSaveException {
        try{
            String path = "C:/Users/Антон/Documents/GitHub/epam_labs/lab_rab_2/src/save/";
            String filename = "";
            String info = "";
            Company company = (Company) obj;
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
        catch(Exception ex){
            throw new DaoSaveException();
        }
    }

    public static void setXMLData(Object obj) throws DaoSaveException {
        try{
            String path = "C:/Users/Антон/Documents/GitHub/epam_labs/lab_rab_2/src/save/";
            String filename = "carRental";
            String ext = ".xml";
            Company company = (Company) obj;
            XMLParser xmlParser = new XMLParser();
            xmlParser.pullSubscribers(company, path + filename + ext);
        }
        catch(Exception ex){
            throw new DaoSaveException();
        }
    }

    public static void setSQLData(){
            SQLExporter exporter = new SQLExporter();
            exporter.sqlExporter();
    }
}

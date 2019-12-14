package by.bsuir.carrental.exporter;

import by.bsuir.carrental.controller.Controller;
import by.bsuir.carrental.exceptions.WrongInputException;
import by.bsuir.carrental.exportClass.XMLExporter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import static by.bsuir.carrental.constants.ProgramConstants.*;
import static by.bsuir.carrental.validator.XML_Validator.checkSchemeXML;

public class SQLExporter {
    private static final String dbUrl="jdbc:mysql://localhost:3306/mysql" + "?verifyServerCertificate=false"+
            "&useSSL=false"+
            "&requireSSL=false"+
            "&useLegacyDatetimeCode=false"+
            "&amp"+
            "&serverTimezone=UTC";;
    private static final String uName = "root";
    private static final String pass = "root";
    private static final String fullPath = "C:/Users/Антон/Documents/GitHub/epam_labs/lab_rab_2/src/save/carRental.xml";
    private static final String xsdPath = "C:/Users/Антон/Documents/GitHub/epam_labs/lab_rab_2/src/save/carRental.xsd";
    private static Scanner in = new Scanner(System.in);
    private static XMLExporter xmlEx;
    private static boolean isNotEnd = true;
    private static boolean finalMessIsNeeded = false;
    private static final Logger logger = Logger.getLogger(SQLExporter.class);
    static {
        try { Class.forName("com.mysql.cj.jdbc.Driver"); }
        catch(ClassNotFoundException ex) {
            logger.fatal("Driver not found: " + ex.getMessage());
        }
    };

    public static void sqlExporter() {
        PropertyConfigurator.configure("C:/Users/Антон/Documents/GitHub/epam_labs/lab_rab_2/src/log4j.properties");
        try {
            xmlEx = new XMLExporter(dbUrl, uName, pass);
            logger.info("Connection success");
        }catch (SQLException sqlEx){
            isNotEnd = false;
            logger.error(sqlEx.getMessage());
            finalMessIsNeeded = true;
        }

        while (isNotEnd) {
            printMenu();
            try {
                int choice = Controller.chooseFromMenu(MENU_MIN, MAIN_MENU_MAX, in);
                switch (choice) {
                    case 1:
                        // checkFile = checkSchemeXML(fullPath, xsdPath);
                        boolean checkFile = true;
                        if(checkFile)
                            xmlEx.exportXML(fullPath);
                        else
                            System.out.println("Your XML is not valid");
                        break;
                    case 2:
                        isNotEnd = false;
                        break;
                    default:
                        System.out.println(MAIN_MENU_DEFAULT_MESS);
                }
            } catch (SQLException | ParserConfigurationException | IOException | SAXException ex) {
                logger.error(ex.getMessage());
            } catch (WrongInputException e) {
                logger.info(e.getMessage());
                in.next();
            }

        }

        if (finalMessIsNeeded)
            System.out.println("Press any button to leave");
    }

    private static void printMenu() {
        System.out.println(MENU);
    }

}
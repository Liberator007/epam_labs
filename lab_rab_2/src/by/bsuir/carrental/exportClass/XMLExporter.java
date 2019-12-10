package by.bsuir.carrental.exportClass;

import by.bsuir.carrental.entity.Car;
import by.bsuir.carrental.entity.Company;
import by.bsuir.carrental.exceptions.SaveFailedException;

import com.mysql.cj.result.SqlDateValueFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class XMLExporter {
    private Connection con;
    public XMLExporter(String dbUrl, String uName, String pass) throws SQLException {
        this.con = DriverManager.getConnection(dbUrl, uName, pass);
    }

    public void exportXML(String fullPath) throws SQLException, ParserConfigurationException, IOException, SAXException {
        try{
            con.createStatement()
                    .execute("DROP TABLE carRental");
        }catch (SQLException ex) {;}
        con.createStatement()
                .execute("CREATE TABLE carRental(\n" +
                        " id integer primary key auto_increment,\n" +
                        " model varchar(25) not null unique,\n" +
                        " idcar varchar(25) not null unique,\n" +
                        " yearIssue varchar(25) not null unique,\n" +
                        " price varchar(25) not null unique,\n" +
                        " seats varchar(25) not null unique,\n" +
                        " rent varchar(25) not null unique\n" +
                        ")");


        File file = new File(fullPath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document xmlDoc = builder.parse(file);

        PreparedStatement stmt = con
                .prepareStatement("REPLACE INTO carRental(\n" +
                        " model, idcar, yearIssue, price, seats, rent)\n" +
                        "VALUES(?, ?, ?, ?, ?, ?)");

        Node root = xmlDoc.getFirstChild();
        NodeList nlist = root.getChildNodes();
        for (int i = 0 ; i < nlist.getLength() ; i++) {
            Node child = nlist.item(i);//sub
            ArrayList<String> columns = new ArrayList<String>();
            NodeList nlist2 = child.getChildNodes();
            for(int j = 0; j < nlist2.getLength(); j++)
            {
                Node child2 = nlist2.item(j);
                columns.add(child2.getTextContent());
            }
            for (int n = 0 ; n < columns.size() ; n++) {
                stmt.setString(n+1, columns.get(n));
            }
            stmt.execute();
        }
    }
}

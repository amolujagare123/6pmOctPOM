package DataBaseTesting.Clients;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Menu;
import pages.clients.AddClient;

import util.DoLogin;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import static util.Conversion.*;


public class AddClientTest extends DoLogin {

    @Test (dataProvider = "getData")
    public void addClientTest(String name,String surname,String language,
           String add1,String add2,String city,String state,String zip,
            String country,String gender,String birthdate,String phone,
             String fax,String mob,String email,String website,String vat,
           String tax) throws ParseException, ClassNotFoundException, SQLException {

        ArrayList<String> expected = new ArrayList<>();
        expected.add(name );
        expected.add(surname);
        expected.add(language.toLowerCase());
        expected.add(add1);
        expected.add(add2);
        expected.add(city);
        expected.add(state);
        expected.add(zip);
        expected.add(country);
        expected.add(gender);
        expected.add(birthdate);
        expected.add(phone );
        expected.add(fax);
        expected.add(mob);
        expected.add(email);
        expected.add(website);
        expected.add(vat);
        expected.add(tax);

        System.out.println("Expected:"+expected);




        Menu menu = new Menu(driver);
        menu.clickAddclient();
        AddClient addClient = new AddClient(driver);
        addClient.setClientName(name);
        addClient.setSurname(surname);
        addClient.setAddress1(add1);
        addClient.setAddress2(add2);
        addClient.setCity(city);
        addClient.setState(state);
        addClient.setZip(zip);
        addClient.setPhone(phone);
        addClient.setFax(fax);
        addClient.setMobile(mob);
        addClient.setEmail(email);
        addClient.setWeb(website);
        addClient.setTax(tax);
        addClient.setVat(vat);
        addClient.setBirthDate(birthdate); // dd/MM/yyyy
        addClient.setlanguage(language);
        addClient.setCountry(country);
        addClient.setGender(gender);
        addClient.clickSave();


        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/ip6pm";
        String user ="root";
        String pass ="root";

        Connection con = DriverManager.getConnection(url,user,pass);
        Statement st = con.createStatement();

        String sql = "select * from ip_clients where client_name='"+name+"'";

        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while(rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));


            String countryShort = rs.getString("client_country");
            String countryFull = convertedCountry(countryShort);

            actual.add(countryFull);


            actual.add(convertGender(rs.getString("client_gender")));

            actual.add(convertDBDate(rs.getString("client_birthdate")));
            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }

        System.out.println("actual:"+actual);

        Assert.assertEquals(actual,expected,
                "all the inputs in recod are not same");

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        FileInputStream fp = new FileInputStream("Data\\dataSheet.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fp);
        XSSFSheet sheet = workbook.getSheet("Sheet2");
        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount-1][18];

        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            for(int j =0 ;j<18;j++)
            {
                XSSFCell element = row.getCell(j);
                data[i][j] = element.toString().trim();

            }

        }

        return  data;
    }
}

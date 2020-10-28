package regression.Clients;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.clients.AddClient;
import util.DoLogin;
import util.OpenUrl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import static util.ConfigReader.getPassword;
import static util.ConfigReader.getUsername;

public class AddClientTest extends DoLogin {

    @Test (dataProvider = "getData")
    public void addClientTest(String name,String surname,String language,
           String add1,String add2,String city,String state,String zip,
            String country,String gender,String birthdate,String phone,
             String fax,String mob,String email,String website,String vat,
           String tax,String expected,String xpathactual) throws ParseException {
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

        String actual="";

        try {

            actual = driver.findElement(By.xpath(xpathactual)).getText();
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"incorrect error message or " +
                "error message is absent");
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        FileInputStream fp = new FileInputStream("Data\\dataSheet.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fp);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount-1][20];

        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            for(int j =0 ;j<20;j++)
            {
                XSSFCell element = row.getCell(j);
                data[i][j] = element.toString().trim();

            }

        }

        return  data;
    }
}

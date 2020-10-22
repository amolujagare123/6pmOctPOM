package regression.Clients;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.clients.AddClient;
import util.DoLogin;
import util.OpenUrl;

import java.io.IOException;

import static util.ConfigReader.getPassword;
import static util.ConfigReader.getUsername;

public class AddClientTest extends DoLogin {

    @Test
    public void addClientTest()  {

        Menu menu = new Menu(driver);
        menu.clickAddclient();

        AddClient addClient = new AddClient(driver);

        addClient.setClientName("sameer");
        addClient.setClientName("Shaikh");
        addClient.setClientAdd1("abcd");
        addClient.setClientAdd2("xyz");
        addClient.setCity("Pune");
        addClient.setLaguage("English");
        addClient.setCountry("Malaysia");
        addClient.setGender("Other");


        addClient.clickSave();



    }
}

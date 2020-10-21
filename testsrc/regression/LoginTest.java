package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import util.DoLogin;

import java.io.IOException;

import static util.ConfigReader.getPassword;
import static util.ConfigReader.getUsername;

public class LoginTest extends DoLogin {

    @Test
    public void logintest() throws IOException {
        Login login = new Login(driver);

        login.setTxtUser(getUsername());
        login.setTxtPass(getPassword());
        login.clickLogin();
    }
}

package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import util.DoLogin;

public class LoginTest extends DoLogin {

    @Test
    public void logintest()
    {
        Login login = new Login(driver);

        login.setTxtUser("amolujagare@gmail.com");
        login.setTxtPass("admin123");
        login.clickLogin();
    }
}

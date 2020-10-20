package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ForgotPassword;
import pages.Login;
import util.DoLogin;

public class ForgotPassTest extends DoLogin  {

    @Test
    public void forgotPassTest()
    {
        Login login = new Login(driver);
        login.clickForgotPass();

        ForgotPassword forgotPassword = new ForgotPassword(driver);
        forgotPassword.setTxtEmail("amolo@gmail.com");
        forgotPassword.clickResetPass();


    }

}

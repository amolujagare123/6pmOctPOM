package regression;

import org.testng.annotations.Test;
import pages.Login;
import util.OpenUrl;

import java.io.IOException;

import static util.ConfigReader.getPassword;
import static util.ConfigReader.getUsername;

public class LoginTest extends OpenUrl {

    @Test
    public void logintest() throws IOException {
        Login login = new Login(driver);

        login.setTxtUser(getUsername());
        login.setTxtPass(getPassword());
        login.clickLogin();
    }
}

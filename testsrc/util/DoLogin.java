package util;

import org.testng.annotations.BeforeClass;
import pages.Login;

import java.io.IOException;

import static util.ConfigReader.getPassword;
import static util.ConfigReader.getUsername;

public class DoLogin extends  OpenUrl{

    @BeforeClass
    public void doLogin()throws IOException
    {
        Login login = new Login(driver);

        login.setTxtUser(getUsername());
        login.setTxtPass(getPassword());
        login.clickLogin();
    }
}

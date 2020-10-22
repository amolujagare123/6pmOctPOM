package regression;

import org.testng.annotations.Test;
import pages.ForgotPassword;
import pages.Login;
import util.OpenUrl;

public class ForgotPassTest extends OpenUrl {


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

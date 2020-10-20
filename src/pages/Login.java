package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

   /* WebDriver driver;

    WebElement txtUser = driver.findElement(By.name("email"));*/

    @FindBy (name="email")
    WebElement txtUser;

    @FindBy (name="password")
    WebElement txtPass;

    @FindBy (xpath="//*[@type='submit']")
    WebElement btnLogin;

    @FindBy(xpath="//a")
    WebElement lnkForgotPass;

    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void clickForgotPass()
    {
        lnkForgotPass.click();
    }


    public void setTxtUser(String user)
    {
        txtUser.sendKeys(user);
    }

    public void setTxtPass(String pass)
    {
        txtPass.sendKeys(pass);
    }

    public void clickLogin()
    {
        btnLogin.click();
    }

}

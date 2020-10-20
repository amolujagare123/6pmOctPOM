package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {

    @FindBy (name="email")
    WebElement txtEmail;

    @FindBy (xpath="//*[@type='submit']")
    WebElement btnResetpass;


    public ForgotPassword(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }


    public void setTxtEmail(String email)
    {
        txtEmail.sendKeys(email);
    }

    public void clickResetPass()
    {
        btnResetpass.click();
    }
}

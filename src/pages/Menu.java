package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

    @FindBy (xpath="//a[text()='Dashboard']")
    WebElement dashboard;

    @FindBy (xpath="//span[contains(normalize-space(),'Clients')]")
    WebElement clients;

    @FindBy (xpath="//a[contains(normalize-space(),'Add Client')]")
    WebElement addClients;

    @FindBy (xpath="//a[contains(normalize-space(),'View Clients')]")
    WebElement viewClients;

    @FindBy (xpath="//span[contains(normalize-space(),'Quotes')]")
    WebElement quotes;

    @FindBy (xpath="//a[@class='create-quote']")
    WebElement createQuotes;

    @FindBy (xpath="//a[contains(normalize-space(),'View Quotes')]")
    WebElement viewQuotes;

    public  Menu(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void clickDashBoard()
    {
        dashboard.click();
    }

    public void clickAddclient()
    {
        clients.click();
        addClients.click();
    }

    public void clickViewClients()
    {
        clients.click();
        viewClients.click();
    }

    public void clickCreateQuotes()
    {
        quotes.click();
        createQuotes.click();
    }

    public void clickViewQuotes()
    {
        quotes.click();
        viewQuotes.click();
    }

}

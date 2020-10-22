package pages.clients;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {

    @FindBy(xpath="//input[@id='client_name']")
    WebElement clientName;

    @FindBy (xpath="//input[@id='client_surname']")
    WebElement clientSurname;

    @FindBy (xpath="//input[@id='client_address_1']")
    WebElement clientAdd1;

    @FindBy (xpath="//input[@id='client_address_2']")
    WebElement clientAdd2;

    @FindBy (xpath="//input[@id='client_city']")
    WebElement clientCity;


    @FindBy (id="select2-client_language-container")
    WebElement containerLaguage;

    @FindBy (xpath = "//input[@type='search']")
    WebElement txtSearch;


    public void setLaguage(String language)
    {
        containerLaguage.click();
        txtSearch.sendKeys(language);

        driver.findElement(By.xpath("//li[contains(text(),'"+language+"')]")).click();
    }

    @FindBy (id ="select2-client_country-container")
    WebElement containerCountry;


    public void setCountry(String country)
    {
        containerCountry.click();
        txtSearch.sendKeys(country);
        driver.findElement(By.xpath("//li[text()='"+country+"']")).click();
    }


    @FindBy (id="select2-client_gender-container")
    WebElement containerGender;

    public void setGender(String gender)
    {
        containerGender.click();
        driver.findElement(By.xpath("//li[contains(text(),'"+gender+"')]")).click();
    }



    @FindBy (xpath="//button[@id='btn-submit']")
    WebElement save;

    public void clickSave()
    {
        save.click();
    }

    WebDriver driver;

    public AddClient(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void setClientName(String name)
    {
        clientName.sendKeys(name);
    }

    public void setClientSurname(String surname)
    {
        clientSurname.sendKeys(surname);
    }

    public void setClientAdd1(String add1)
    {
        clientAdd1.sendKeys(add1);
    }

    public void setClientAdd2(String add2)
    {
        clientAdd2.sendKeys(add2);
    }


    public void setCity(String city)
    {
        clientCity.sendKeys(city);
    }




}

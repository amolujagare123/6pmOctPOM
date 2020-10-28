package pages.clients;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddClientOld {

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

    public AddClientOld(WebDriver driver)
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


    @FindBy (xpath = "//input[@id='client_birthdate']")
    WebElement birthDate;

    public void setBirthDate(String setDateStr) throws ParseException {

        birthDate.click();

        System.out.println(setDateStr);

        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDateStr);

        String currDateStr = driver.findElement(By.xpath("//th[@class='datepicker-switch']")).getText();
        System.out.println(currDateStr);

        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDateStr);

        // take the month differnce betwen these 2 dates

        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1),
                new DateTime(setDate).withDayOfMonth(1)).getMonths();

        System.out.println(monthDiff); // 2

        boolean isFuture = true;
        if (monthDiff<0)
        {
            isFuture = false;
            monthDiff = monthDiff * (-1);
        }

        for (int i=0;i<monthDiff;i++)
        {
            if (isFuture)
                driver.findElement(By.xpath("//th[@class='next']")).click();
            else
                driver.findElement(By.xpath("//th[@class='prev']")).click();
        }


        String currDayStr = new SimpleDateFormat("dd").format(setDate);
        int currDay = Integer.parseInt(currDayStr);


        driver.findElement(By.xpath("//td[@class='day' and text()='"+currDay+"']")).click();


    }

    public void setBirthDatesendKeys(String setDateStr)  // as per the text box format (here) MM/dd/yyyy
    {

        birthDate.sendKeys(setDateStr);

    }

    public void setBirthDateJS(String setDateStr)  // as per the text box format (here) MM/dd/yyyy
    {

     //    birthDate.sendKeys(setDateStr);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+setDateStr+"')",birthDate);


    }
}

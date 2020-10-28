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

public class AddClient {



    @FindBy(xpath="//input[@id='client_name']")
    WebElement clientName;

    @FindBy (xpath="//input[@id='client_surname']")
    WebElement surname;

    @FindBy (xpath="//input[@id='client_address_1']")
    WebElement address1;

    @FindBy (xpath="//input[@id='client_address_2']")
    WebElement address2;



    @FindBy (id="select2-client_language-container")
    WebElement containerlanguage;

    @FindBy (xpath="//input[@type='search']")
    WebElement txtSearch;

    public void setlanguage(String lang)
    {
        containerlanguage.click();
        txtSearch.sendKeys(lang);
        driver.findElement(By.xpath("//li[contains(text(),'"+lang+"')]")).click();
    }




    @FindBy (xpath="//input[@id='client_city']") WebElement city;
    @FindBy (xpath="//input[@id='client_state']") WebElement state;
    @FindBy (xpath="//input[@id='client_zip']") WebElement zip;
    @FindBy (xpath="//input[@id='client_phone']") WebElement phone;
    @FindBy (xpath="//input[@id='client_mobile']") WebElement mobile;

    @FindBy (xpath="//input[@id='client_fax']") WebElement fax;
    @FindBy (xpath="//input[@id='client_web']") WebElement web;

    @FindBy (xpath="//input[@id='client_email']") WebElement email;
    @FindBy (xpath="//input[@id='client_vat_id']") WebElement vat;
    @FindBy (xpath="//input[@id='client_tax_code']") WebElement tax;
    @FindBy (xpath="//button[@id='btn-submit']") WebElement btnSave;

    public void setCity(String cityTxt)
    {
        city.sendKeys(cityTxt);
    }
    public void setEmail(String emailtxt) {email.sendKeys(emailtxt);}
    public void setWeb(String webtxt) {web.sendKeys(webtxt);}
    public void setMobile(String mob) {mobile.sendKeys(mob);}
    public void setState(String stateTxt)
    {
        state.sendKeys(stateTxt);
    }
    public void setZip(String zipTxt)
    {
        zip.sendKeys(zipTxt);
    }
    public void setPhone(String phoneTxt)
    {
        phone.sendKeys(phoneTxt);
    }
    public void setFax(String faxTxt)
    {
        fax.sendKeys(faxTxt);
    }
    public void setTax(String taxTxt)
    {
        tax.sendKeys(taxTxt);
    }
    public void setVat(String vatTxt)
    {
        vat.sendKeys(vatTxt);
    }

    public void clickSave()
    {
        btnSave.click();
    }


    @FindBy (id="select2-client_country-container")
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


    @FindBy(xpath="//input[@id='client_birthdate']")
    WebElement txtDate;

    public void setBirthDateJS(String myDate)
    {
        //  txtDate.sendKeys(myDate);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+myDate+"')",txtDate);
    }

    public void setBirthDate(String setDateStr) throws ParseException {
        txtDate.click();
        System.out.println(setDateStr);

        // lets extract the current date (month year)

        String currDateStr =  driver.findElement(By.className("datepicker-switch")).getText();

       // System.out.println(currDateStr);

        // lets convert currentDateStr & setDateStr into date

        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDateStr);

        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDateStr);

        // take month difference between current date & set date
        // download Joda date jar

        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1),

                new DateTime(setDate).withDayOfMonth(1)).getMonths();

        //System.out.println(monthDiff);


        boolean isFuture=true;

        if(monthDiff<0) // if the month diff is negative then (-5)
        {
            isFuture=false; // set isFuture to false
            monthDiff = monthDiff * (-1); // make the value of month diff positive -- 5
        }


        for(int i=0 ; i<monthDiff ;i++)
        {
            if(isFuture)
                driver.findElement(By.xpath("//th[@class='next']")).click();
            else
                driver.findElement(By.xpath("//th[@class='prev']")).click();
        }


        String currDayStr = new SimpleDateFormat("dd").format(setDate);

        int currDay = Integer.parseInt(currDayStr);

        driver.findElement(By.xpath("//td[@class='day' and text()='"+currDay+"']")).click();


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

    public void setSurname(String surnametext)
    {
        surname.sendKeys(surnametext);
    }

    public void setAddress1(String add1)
    {
        address1.sendKeys(add1);
    }

    public void setAddress2(String add2)
    {
        address2.sendKeys(add2);
    }

}

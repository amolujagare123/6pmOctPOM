package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {

    static WebDriver driver;

    static enum  DriverType {
      CHROME,FIREFOX,INTERNETEXPLORER
    };

    public static  WebDriver getWebDriver(DriverType d)
    {

        switch (d) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case INTERNETEXPLORER:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
        }

        driver.manage().window().maximize();

        return driver;
    }

}

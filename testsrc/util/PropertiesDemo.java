package util;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

    @Test
    public void demo() throws IOException {

        FileInputStream fp = new FileInputStream("config\\project.properties");

        Properties prop = new Properties();

        prop.load(fp);

        System.out.println(prop.getProperty("url"));
        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));

    }
}

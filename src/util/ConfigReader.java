package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

     static  Properties getPropObject() throws IOException {
        FileInputStream fp = new FileInputStream("config\\project.properties");

        Properties prop = new Properties();

        prop.load(fp);

        return prop;
    }


    public static String getUrl() throws IOException {

       return getPropObject().getProperty("url");
    }

    public static String getUsername() throws IOException {

        return getPropObject().getProperty("username");
    }

    public static String getPassword() throws IOException {

        return getPropObject().getProperty("password");
    }
}

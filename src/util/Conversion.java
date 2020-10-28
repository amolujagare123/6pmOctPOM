package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    public static String convertedCountry(String countryShortForm)
    {
        String countryFullForm="";


        switch (countryShortForm)
        {
            case "IN" : countryFullForm="India";break;
            case "CN" : countryFullForm="China";break;
            case "AF" : countryFullForm="Afghanistan";break;
            case "AS" : countryFullForm="American Samoa";break;
            case "AU" : countryFullForm="Australia";break;
        }

        return countryFullForm;

    }

    public static String convertGender(String genderID)
    {
        String gender="";

        switch (genderID)
        {
            case "0" : gender="Male";break;
            case "1" : gender="Female";break;
            case "2" : gender="Other";break;
        }

        return gender;
    }

    public static String convertDBDate(String dateDB) throws ParseException {

        String convertedDate="";
        // lets convert date in string into Date

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateDB);
        convertedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);

        return convertedDate;
    }
}

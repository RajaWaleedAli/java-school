package Date_format;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    public static void main(String[] args) {
        String dateString = "18.12.2015";

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        try {
            Date date = dateFormat.parse(dateString);

            System.out.println("Das Datum ist: " + date.toString());
        } catch (ParseException e) {
            System.out.println("Ungültiges Datum: " + dateString);
        }
    }
}


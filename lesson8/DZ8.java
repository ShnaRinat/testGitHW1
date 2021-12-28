import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class DZ8 {

    public static void main(String[] args) throws IOException {

        String city = "Moscow";

        try {
            DBHandler dbHandler = new DBHandler();
            dbHandler.addWeatherCity(city);
            dbHandler.selectAllWeather();
            System.out.println("--------");
            dbHandler.selectWeatherDate("2021-12-27");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
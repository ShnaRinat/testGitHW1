package lesson7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import java.io.IOException;

public class DZ7 {
    public static final String HOST = "developer.accuweather.com";
    public static final String FORECAST_URL = "forecasts";
    public static final String DAILY_URL = "daily";
    public static final String FIVE_DAYS_URL = "5day";
    public static final String API_VERSION = "V1";
    public static final String CITY_ID = "295212";
    public static final String API_KEY = "lN5VdWRrldAJhMUGsD49B9aNRMGGEkwU";
    public static final String LANGUAGE = "ru-ru";
    public static final String METRIC = "true";

        public static void main(String[] args) throws IOException {

            OkHttpClient client = new OkHttpclient();
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(HOST)
                    .addPathSegment(FORECAST_URL)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(DAILY_URL)
                    .addPathSegment(FIVE_DAYS_URL)
                    .addPathSegment(CITY_ID)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", LANGUAGE)
                    .addQueryParameter("metric", METRIC)
                    .build();


            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Responce responce = client.newCall(request).execute();
            ObjectMapper objectMapper = new ObjectMapper();
            WeatherResponce weatherResponce = objectMapper.readValue(responce.body().byteStream(), WeatherResponse.class);

            for (DailyForecast forecast : weatherResponce.getDailyForecasts()) {
                System.out.printf(
                        "Погода в Питере на %s\n" +
                                "%s, температура от %.1f до %.1f %s\n\n",
                        forecast.getDate(),
                        forecast.getDay().getIconPhrase(),
                        forecast.getTemperature().getMinimum().getValue(),
                        forecast.getTemperature().getMaximum().getValue(),
                        forecast.getTemperature().getMinimum().getUnit());
        }
    }
}
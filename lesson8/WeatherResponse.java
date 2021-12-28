import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class WeatherResponse {

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static final String API_KEY = "lN5VdWRrldAJhMUGsD49B9aNRMGGEkwU";
    public static String cityName;
    public static String cityEnglishName;
    public static String cityId;

    public static String sendCityIdRequest(String cityName) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", cityName)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String responseJson = response.body().string();
        JsonNode cityIdNode = objectMapper
                .readTree(responseJson)
                .at("/0/Key");
        cityId = cityIdNode.asText();
        JsonNode cityEnglishNameNode = objectMapper
                .readTree(responseJson)
                .at("/0/EnglishName");
        cityEnglishName = cityEnglishNameNode.asText();
        return cityId;
    }

    public static String sendTempRequest(String cityId) throws IOException {
        Date date = new Date();
        String daterequest = date.toString();
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String responseJson = response.body().string();
        System.out.println(responseJson);

        String str = "";
        for (int i = 0; i < 5; i++) {

            JsonNode dayNode = objectMapper
                    .readTree(responseJson)
                    .at("/DailyForecasts/" + i + "/Date");
            String day = dayNode.asText().substring(0, 10);

            JsonNode textNode = objectMapper
                    .readTree(responseJson)
                    .at("/DailyForecasts/" + i + "/Day/IconPhrase");
            String text = textNode.asText();

            JsonNode tempNode = objectMapper
                    .readTree(responseJson)
                    .at("/DailyForecasts/" + i + "/Temperature/Minimum/Value");
            String temp = tempNode.asText();

            str += daterequest + "; " + cityId + "; " + cityEnglishName + "; " + day + "; " + text + "; " + temp + ";\n";
        }

        File csvFileWrite = new File("src/main/resources/HM8-rw.csv");

        try (PrintWriter writer = new PrintWriter(csvFileWrite)) {
            writer.write(str);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return str;
    }
}
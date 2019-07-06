import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URL;

// wrapper class around Open Weather Map API
class OpenWeatherApi {
    private static String root = "http://api.openweathermap.org/data/2.5/weather?";
    private static String options = "&units=imperial";
    private static String token = "&appid=370be09443bced97836456dddbb484c6";

    static JsonObject getWeatherAtZipCode(String zipCode) throws IOException {
        return ApiUtility.getJson(new URL(root + "zip=" + zipCode.trim() + options + token));
    }

    static JsonObject getWeatherAtCity(String city) throws IOException {
        return ApiUtility.getJson(new URL(root + "q=" + city.trim() + options + token));
    }

    static JsonObject getWeatherAtCity(String city, String countryCode) throws IOException {
        return ApiUtility.getJson(new URL(root + "q=" + city.trim() + "," + countryCode.trim().toLowerCase() +
                options + token));
    }

    static JsonObject getWeatherAtCoords(String latitude, String longitude) throws IOException {
        return ApiUtility.getJson(new URL(root + "lat=" + latitude.trim() + "&lon=" + longitude.trim() +
                options + token));
    }
}
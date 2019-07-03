import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URL;

// wrapper class around Open Weather Map API
class OpenWeatherApi {
    private static String root = "http://api.openweathermap.org/data/2.5/weather?";
    private static String token = "&appid=370be09443bced97836456dddbb484c6";

    static JsonObject getWeatherAtZipCode(String zipCode) throws IOException {
        return ApiUtility.getJson(new URL(root + "zip=" + zipCode.trim() + "&units=imperial" + token));
    }
}
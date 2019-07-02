import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenWeatherApi {
    public static String root = "http://api.openweathermap.org/data/2.5/weather?q=";
    public static String token = "&APPID=370be09443bced97836456dddbb484c6";

    public static JsonObject getWeather(String location) throws Exception {
        URL url = new URL(root + location + token);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        String res = bufferToString(new BufferedReader(new InputStreamReader(con.getInputStream())));
        return new JsonParser().parse(res).getAsJsonObject();
    }

    public static String bufferToString(BufferedReader in) throws IOException {
        StringBuilder response = new StringBuilder();
        String responseSingle = null;
        while ((responseSingle = in.readLine()) != null) {
            response.append(responseSingle);
        }
        return response.toString();
    }
}

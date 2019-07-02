import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SpaceXApi {
    public static String root = "https://api.spacexdata.com/v3";

    public static JsonObject getLatestLaunch() throws IOException {
        URL url = new URL(root + "/launches/latest");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");
        String res = ApiUtility.bufferToString(new BufferedReader(new InputStreamReader(con.getInputStream())));
        return new JsonParser().parse(res).getAsJsonObject();
    }
}
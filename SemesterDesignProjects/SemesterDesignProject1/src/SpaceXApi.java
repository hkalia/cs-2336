import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URL;

// wrapper class around SpaceX API
class SpaceXApi {
    private static String root = "https://api.spacexdata.com/v3";

    static JsonObject getLatestLaunch() throws IOException {
        return ApiUtility.getJson(new URL(root + "/launches/latest"));
    }
}
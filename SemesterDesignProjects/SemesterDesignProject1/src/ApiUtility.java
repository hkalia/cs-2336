import java.io.BufferedReader;
import java.io.IOException;

public class ApiUtility {
    public static String bufferToString(BufferedReader in) throws IOException {
        StringBuilder response = new StringBuilder();
        String responseSingle;
        while ((responseSingle = in.readLine()) != null) {
            response.append(responseSingle);
        }
        in.close();
        return response.toString();
    }
}

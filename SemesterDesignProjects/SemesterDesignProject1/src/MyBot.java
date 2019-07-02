import com.google.gson.JsonObject;
import org.jibble.pircbot.PircBot;

import java.io.IOException;

public class MyBot extends PircBot {
    public MyBot() {
        this.setName("MyBot");
    }

    public void onMessage(String channel, String sender,
                          String login, String hostname, String message) {
        if (message.startsWith("weather")) {
            sendMessage(channel, sender + ": Hi! This bot can tell you the weather!");
        } else if (message.startsWith("spacex")) {
            try {
                JsonObject launchData = SpaceXApi.getLatestLaunch();
                sendMessage(channel, sender + ": " + launchData.toString());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
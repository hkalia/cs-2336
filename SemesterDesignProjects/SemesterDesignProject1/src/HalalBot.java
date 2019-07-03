import com.google.gson.JsonObject;
import org.jibble.pircbot.PircBot;

import java.io.IOException;

public class HalalBot extends PircBot {
    HalalBot() {
        this.setName("HalalBot");
    }

    protected void onJoin(String channel, String sender, String login, String hostname) {
        // only send message if someone else is joining (not the bot itself)
        if (!sender.equals(getName()))
            // \u0002 makes the text bold
            respond(channel, sender, "Hello 👋, My name is HalalBot. I can tell you the weather 🌦 " +
                    "(\u0002hb weather 94043\u0002). I can also tell you about rockets 🚀 " +
                    "(\u0002hb spacex\u0002)! Type \u0002hb help\u0002 to learn more!");
    }

    protected void onMessage(String channel, String sender, String login, String hostname, String message) {
        String lowerCaseMessage = message.toLowerCase();
        if (lowerCaseMessage.startsWith("hb ") || lowerCaseMessage.startsWith("halalbot ")) {
            String[] tokens = lowerCaseMessage.split(" ");

            if (tokens.length < 2)
                basicHelpMessage(channel, sender);
            else if (tokens[1].equals("help"))
                detailedHelpMessage(channel, sender, tokens);
            else if (tokens[1].equals("weather"))
                weatherMessage(channel, sender, tokens);
            else if (tokens[1].equals("spacex"))
                spacexMessage(channel, sender, tokens);
            else
                respond(channel, sender, "Command not found. Try \u0002hb help\u0002");
        }
    }

    private void basicHelpMessage(String channel, String sender) {
        respond(channel, sender, "Every command starts with \u0002hb\u0002 or \u0002halalbot\u0002. " +
                "Then you can type one of the following commands:");
        respond(channel, sender, "\u0002weather <zip code>\u0002 to get the weather 🌦 at a " +
                "specific zip code (\u0002hb weather 94043\u0002)");
        respond(channel, sender, "\u0002spacex\u0002 to get the latest SpaceX launches 🚀!");
        respond(channel, sender, "\u0002help\u0002 to get this help menu.");
        respond(channel, sender, "\u0002help <command>\u0002 to get detailed help on a specific " +
                "command (\u0002hb help weather\u0002)");
    }

    private void detailedHelpMessage(String channel, String sender, String[] tokens) {
        if (tokens.length < 3) {
            basicHelpMessage(channel, sender);
        } else if (tokens[2].equals("weather")) {
            respond(channel, sender, "\u0002hb weather\u0002 options:");
            respond(channel, sender, "\u0002city <city name> to get the weather 🌦 " +
                    "for a specific city! (\u0002hb weather city London\u0002)");
            respond(channel, sender, "\u0002city <city name> <country code> to get the weather 🌦 " +
                    "for a specific city! (\u0002hb weather city London uk\u0002)");
            respond(channel, sender, "\u0002coord <latitude> <longitude> to get the weather 🌦 " +
                    "for a specific set of coordinates! (\u0002hb weather coord 35 139\u0002)");
        } else if (tokens[2].equals("spacex")) {
            respond(channel, sender, "no detailed help just yet");
        }
    }

    private void weatherMessage(String channel, String sender, String[] tokens) {
        if (tokens.length < 3) {
            respond(channel, sender, "Please provide zip code.");
            return;
        }
        try {
            JsonObject weatherData = OpenWeatherApi.getWeatherAtZipCode(tokens[2]);
            String description = weatherData.getAsJsonArray("weather").get(0).getAsJsonObject()
                    .get("description").getAsString();
            double temp = weatherData.getAsJsonObject("main").get("temp").getAsDouble();
            String cityName = weatherData.get("name").getAsString();

            respond(channel, sender, "Weather is " + description + " and the temperature is " +
                    temp + "℉ in " + cityName);
        } catch (IOException e) {
            respond(channel, sender, "Could not get weather, please try again later.");
            System.out.println(e.getMessage());
        }

    }

    private void spacexMessage(String channel, String sender, String[] tokens) {
        try {
            JsonObject spacexData = SpaceXApi.getLatestLaunch();

            String missionName = spacexData.get("mission_name").getAsString();
            String details = spacexData.get("details").getAsString();
            respond(channel, sender, "Mission Name: " + missionName);
            respond(channel, sender, "Details: " + details);
        } catch (IOException e) {
            respond(channel, sender, "Could not get launches, please try again later.");
            System.out.println(e.getMessage());
        }
    }

    // send a message to a specific user
    private void respond(String channel, String sender, String message) {
        sendMessage(channel, sender + ": " + message);
    }
}
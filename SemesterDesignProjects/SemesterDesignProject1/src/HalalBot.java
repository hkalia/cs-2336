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
                    "(\u0002hb spacex launches\u0002)! Type \u0002hb help\u0002 to learn more!");
    }

    protected void onMessage(String channel, String sender, String login, String hostname, String message) {
        String lowerCaseMessage = message.toLowerCase();
        if (lowerCaseMessage.equals("hb") || lowerCaseMessage.equals("halalbot")) {
            basicHelpMessage(channel, sender);
        } else if (lowerCaseMessage.startsWith("hb ") || lowerCaseMessage.startsWith("halalbot ")) {
            String[] tokens = lowerCaseMessage.split(" ");

            if (tokens.length < 2)
                basicHelpMessage(channel, sender);
            else if (tokens[1].equals("help"))
                detailedHelpMessage(channel, sender, tokens);
            else if (tokens[1].equals("weather"))
                weatherMessage(channel, sender, tokens);
            else if (tokens[1].equals("spacex"))
                spaceXMessage(channel, sender, tokens);
            else
                respond(channel, sender, "Command not found. Try \u0002hb help\u0002");
        }
    }

    private void basicHelpMessage(String channel, String sender) {
        respond(channel, sender, "Every command starts with \u0002hb\u0002 or \u0002halalbot\u0002. " +
                "Then you can type one of the following commands:");
        respond(channel, sender, "\u0002weather <zip code>\u0002 to get the weather 🌦 at a " +
                "specific zip code (\u0002hb weather 94043\u0002)");
        respond(channel, sender, "\u0002spacex launches\u0002 to get the latest SpaceX launches 🚀! " +
                "(\u0002hb spacex launches\u0002)");
        respond(channel, sender, "\u0002help\u0002 to get this help menu.");
        respond(channel, sender, "\u0002help <command>\u0002 to get detailed help on a specific " +
                "command (\u0002hb help weather\u0002)");
    }

    private void detailedHelpMessage(String channel, String sender, String[] tokens) {
        if (tokens.length < 3) {
            basicHelpMessage(channel, sender);
        } else if (tokens[2].equals("weather")) {
            respond(channel, sender, "\u0002hb weather\u0002 options:");
            respond(channel, sender, "\u0002<zip code>\u0002 to get the weather 🌦 " +
                    "for a specific zip code! (\u0002hb weather 94043\u0002)");
            respond(channel, sender, "\u0002city <city name>\u0002 to get the weather 🌦 " +
                    "for a specific city! (\u0002hb weather city London\u0002)");
            respond(channel, sender, "\u0002city <city name> <country code>\u0002 to get the weather 🌦 " +
                    "for a specific city! (\u0002hb weather city London uk\u0002)");
            respond(channel, sender, "\u0002coord <latitude> <longitude>\u0002 to get the weather 🌦 " +
                    "for a specific set of coordinates! (\u0002hb weather coord 35 139\u0002)");
        } else if (tokens[2].equals("spacex")) {
            respond(channel, sender, "\u0002hb spacex\u0002 options:");
            respond(channel, sender, "\u0002latest launches\u0002 to get the latest launches 🚀!" +
                    "(\u0002hb spacex latest launches\u0002)");
            respond(channel, sender, "\u0002launch <flight number>\u0002 to get the launch with " +
                    "that flight number 🚀! (\u0002hb spacex launch 81\u0002)");
            respond(channel, sender, "\u0002rocket <rocket id>\u0002 to get the info on a specific rocket 🚀" +
                    "(\u0002hb spacex rocket falconheavy\u0002)");
            respond(channel, sender, "\u0002info\u0002 to get info on SpaceX 🚀!" +
                    "(\u0002hb spacex info\u0002)");
        }
    }

    private void weatherMessage(String channel, String sender, String[] tokens) {
        if (tokens.length < 3) {
            respond(channel, sender, "Please provide zip code or command. Try \u0002hb help\u0002");
        }
        try {
            if (tokens[2].matches("^\\d{5}$")) {
                weatherMessageHelper(channel, sender, OpenWeatherApi.getWeatherAtZipCode(tokens[2]));
            } else {
                if (tokens[2].equals("city")) {
                    if (tokens.length >= 5) {
                        weatherMessageHelper(channel, sender, OpenWeatherApi.getWeatherAtCity(tokens[3], tokens[4]));
                    } else if (tokens.length >= 4) {
                        weatherMessageHelper(channel, sender, OpenWeatherApi.getWeatherAtCity(tokens[3]));
                    } else {
                        respond(channel, sender, "Command invalid. Try \u0002hb help weather\u0002");
                    }
                } else if (tokens[2].equals("coord") && tokens.length >= 5) {
                    weatherMessageHelper(channel, sender, OpenWeatherApi.getWeatherAtCoords(tokens[3], tokens[4]));
                } else {
                    respond(channel, sender, "Command invalid. Try \u0002hb help weather\u0002");
                }
            }
        } catch (IOException e) {
            respond(channel, sender, "Could not get weather, please try again later.");
            System.out.println(e.getMessage());
        }

    }

    private void weatherMessageHelper(String channel, String sender, JsonObject weatherData) {
        String description = weatherData.getAsJsonArray("weather").get(0).getAsJsonObject()
                .get("description").getAsString();
        double temp = weatherData.getAsJsonObject("main").get("temp").getAsDouble();
        String cityName = weatherData.get("name").getAsString();

        respond(channel, sender, "Weather is " + description + " and the temperature is " +
                temp + "℉ in " + cityName);
    }

    private void spaceXMessage(String channel, String sender, String[] tokens) {
        if (tokens.length < 3) {
            respond(channel, sender, "Please provide command. Try \u0002hb help\u0002");
            return;
        }
        try {
            if (tokens.length >= 4) {
                if (tokens[2].equals("latest") && tokens[3].equals("launches")) {
                    JsonObject spaceXData = SpaceXApi.getLatestLaunch();

                    spaceXMessageLaunchHelper(channel, sender, spaceXData);
                } else if (tokens[2].equals("launch")) {
                    JsonObject spaceXData = SpaceXApi.getLaunchByFlightNum(tokens[3]);

                    spaceXMessageLaunchHelper(channel, sender, spaceXData);
                } else if (tokens[2].equals("rocket")) {
                    JsonObject spaceXData = SpaceXApi.getRocketById(tokens[3]);

                    respond(channel, sender, "Rocket name: " + spaceXData.get("rocket_name").getAsString());
                    respond(channel, sender, "Stages: " + spaceXData.get("stages").getAsInt() +
                            " Boosters: " + spaceXData.get("boosters").getAsInt());
                    respond(channel, sender, "Height: " +
                            spaceXData.get("height").getAsJsonObject().get("feet").getAsDouble() + " feet");
                    respond(channel, sender, "Description: " + spaceXData.get("description").getAsString());
                } else {
                    respond(channel, sender, "Command invalid. Try \u0002hb help spacex\u0002");
                }
            } else if (tokens[2].equals("info")) {
                JsonObject spaceXData = SpaceXApi.getCompanyInfo();

                respond(channel, sender, "Company name: " + spaceXData.get("name").getAsString());
                respond(channel, sender, "Founder: " + spaceXData.get("founder").getAsString());
                respond(channel, sender, "Summary: " + spaceXData.get("summary").getAsString());
            } else {
                respond(channel, sender, "Command invalid. Try \u0002hb help spacex\u0002");
            }
        } catch (IOException e) {
            respond(channel, sender, "Could not get launches, please try again later.");
            System.out.println(e.getMessage());
        }
    }

    private void spaceXMessageLaunchHelper(String channel, String sender, JsonObject spaceXData) {
        respond(channel, sender, "Mission Name: " + spaceXData.get("mission_name").getAsString());
        respond(channel, sender, "Flight Number: " + spaceXData.get("flight_number").getAsInt());
        respond(channel, sender, "Rocket: " + spaceXData.get("rocket").getAsJsonObject().get("rocket_name").getAsString());
        respond(channel, sender, "Details: " + spaceXData.get("details").getAsString());
    }

    // send a message to a specific user
    private void respond(String channel, String sender, String message) {
        final int MAX_LINE_LEN = 450;
        if (message.length() > MAX_LINE_LEN) {
            for (int i = 0; i < message.length(); i += MAX_LINE_LEN) {
                if (i + MAX_LINE_LEN < message.length())
                    sendMessage(channel, sender + ": " + message.substring(i, MAX_LINE_LEN));
                else
                    sendMessage(channel, sender + ": " + message.substring(i));
            }
        } else {
            sendMessage(channel, sender + ": " + message);
        }
    }
}
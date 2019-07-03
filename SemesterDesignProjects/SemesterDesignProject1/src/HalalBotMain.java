public class HalalBotMain {
    public static void main(String[] args) throws Exception{
        HalalBot bot = new HalalBot();

        bot.setVerbose(true);
        bot.connect("irc.freenode.net");
        bot.joinChannel("#pircbot");
    }
}
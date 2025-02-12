public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();

        logger.configure(true, true, "log.txt");

        // Nachrichten loggen
        logger.log("Das ist eine Testnachricht.");
        logger.log("Eine weitere Nachricht wird geloggt.");
    }
}
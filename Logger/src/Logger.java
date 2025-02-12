import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger logger;
    private boolean logToConsole;
    private boolean logToFile;
    private String filePath;

    private Logger() {
        this.logToConsole = true;
        this.logToFile = true;
        this.filePath = "log.txt";
    }

    public static Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void configure(boolean logToConsole, boolean logToFile, String logFilePath) {
        this.logToConsole = logToConsole;
        this.logToFile = logToFile;
        if (logFilePath != null && !logFilePath.isEmpty()) {
            this.filePath = logFilePath;
        }
    }

    public void log(String message) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " - " + message;

        if (logToConsole) {
            System.out.println(time);
        }

        if (logToFile) {
            logToFile(time);
        }
    }

    private void logToFile(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
            writer.append(message);
            writer.append("\n");
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in die Logdatei: " + e.getMessage());
            e.getStackTrace();
        }
    }
}


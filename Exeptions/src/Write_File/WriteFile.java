package Write_File;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WriteFile {
    public static void main(String[] args) {
        schreibeInDatei("C:\\Users\\39339\\IdeaProjects\\java\\Exeptions\\src\\Write_File\\test.txt");
    }

    static void schreibeInDatei(String dateiname) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(dateiname))) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm:ss");
            bw.write("Aktuelles Datum und Uhrzeit: " + now.format(formatter));
            bw.newLine();

            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
                    bw.write(i + " x " + j + " = " + (i * j));
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben in die Datei: " + e.getMessage());
        }
    }
}

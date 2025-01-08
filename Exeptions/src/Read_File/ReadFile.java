package Read_File;

import java.io.*;

public class ReadFile {

    public static void main(String[] args) {
        dateiLesen("C:\\Users\\39339\\IdeaProjects\\java\\Exeptions\\src\\Read_File\\text.txt");
    }

    static void dateiLesen(String dateiname) {
        try (BufferedReader br = new BufferedReader(new FileReader(dateiname))) {
            String line1 = br.readLine();
            br.readLine();
            String line3 = br.readLine();

            System.out.println(line1);
            System.out.println(line3);

            String extraLine = br.readLine();
            System.out.println("Extra line: " + extraLine);
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden: " + dateiname);
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }
}


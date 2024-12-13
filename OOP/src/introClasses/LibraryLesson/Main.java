package introClasses.LibraryLesson;

public class Main {
    public static void main(String[] args) {
        // Erstelle eine Bibliothek mit einer Kapazität von 5 Büchern
        Library library = new Library(5);

        // Füge einige Bücher zur Bibliothek hinzu
        library.addBook("The Catcher in the Rye", "J.D. Salinger", 214);
        library.addBook("To Kill a Mockingbird", "Harper Lee", 281);
        library.addBook("1984", "George Orwell", 328);
        library.addBook("Animal Farm", "George Orwell", 112);
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", 180);

        // Zeige an, wie viele Bücher sich derzeit in der Bibliothek befinden
        System.out.println("Anzahl der Bücher in der Bibliothek: " + library.getBookCount());

        // Suche nach Büchern eines bestimmten Autors
        String authorToSearch = "George Orwell";
        int index = library.searchBook(authorToSearch);

        if (index != -1) {
            Book foundBook = library.getBooks()[index]; // Zugriff auf das gefundene Buch
            System.out.println("Buch gefunden: " + foundBook.getTitle() + " von " + foundBook.getAuthor());
        } else {
            System.out.println("Kein Buch von " + authorToSearch + " gefunden.");
        }
    }
}

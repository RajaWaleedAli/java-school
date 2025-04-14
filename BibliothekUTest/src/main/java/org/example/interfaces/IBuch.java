package org.example.interfaces;

public interface IBuch {
    void ausleihen();
    void zurueckgeben();

    String getTitel();
    void setTitel(String titel);

    String getAuthor();
    void setAuthor(String author);

    String getIsbn();
    void setIsbn(String isbn);

    boolean isVerfuegbar();
    void setVerfuegbar(boolean verfuegbar);
}

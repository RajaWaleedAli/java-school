package org.example;

import org.example.interfaces.IBuch;

public class Buch implements IBuch {
    private String titel;
    private String author;
    private String isbn;
    private boolean verfuegbar;

    public Buch(String titel, String author, String isbn) {
        this.titel = titel;
        this.author = author;
        this.isbn = isbn;
        this.verfuegbar = true;
    }

    public void ausleihen(){
        verfuegbar = false;
    }

    public void zurueckgeben(){
        verfuegbar = true;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isVerfuegbar() {
        return verfuegbar;
    }

    public void setVerfuegbar(boolean verfuegbar) {
        this.verfuegbar = verfuegbar;
    }
}

package MusicCollection;

import java.io.*;
import java.util.*;

class Album implements Serializable {
    private int id;
    private int artistId;
    private String name;
    private int numberOfTracks;
    private String label;
    private String releaseDate;
    private double price;

    public Album(int id, int artistId, String name, int numberOfTracks, String label, String releaseDate, double price) {
        this.id = id;
        this.artistId = artistId;
        this.name = name;
        this.numberOfTracks = numberOfTracks;
        this.label = label;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public String toCsv() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(";")
                .append(artistId).append(";")
                .append(name).append(";")
                .append(numberOfTracks).append(";")
                .append(label).append(";")
                .append(releaseDate).append(";")
                .append(price);
        return sb.toString();
    }

    // Getters-Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getArtistId() {
        return artistId;
    }
    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfTracks() {
        return numberOfTracks;
    }
    public void setNumberOfTracks(int numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}

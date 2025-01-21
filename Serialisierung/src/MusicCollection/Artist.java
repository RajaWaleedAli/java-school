package MusicCollection;

import java.io.*;
import java.util.*;

class Artist implements Serializable {
    private int id;
    private String name;
    private List<String> genres;
    private String website;
    private String lastFmUrl;

    public Artist(int id, String name, List<String> genres, String website, String lastFmUrl) {
        this.id = id;
        this.name = name;
        this.genres = genres;
        this.website = website;
        this.lastFmUrl = lastFmUrl;
    }

    public String toCsv() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(";")
                .append(name).append(";")
                .append(genres).append(";")
                .append(website).append(";")
                .append(lastFmUrl);
        return sb.toString();
    }

    // Getters-Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGenres() {
        return genres;
    }
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLastFmUrl() {
        return lastFmUrl;
    }
    public void setLastFmUrl(String lastFmUrl) {
        this.lastFmUrl = lastFmUrl;
    }
}

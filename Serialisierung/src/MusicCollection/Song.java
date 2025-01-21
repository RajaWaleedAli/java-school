package MusicCollection;

import java.io.*;
import java.util.*;

class Song implements Serializable {
    private int artistId;
    private int albumId;
    private String title;
    private int trackNumber;
    private String format;
    private int length;
    private String bitrate;
    private String filename;

    public Song(int artistId, int albumId, String title, int trackNumber, String format, int length, String bitrate, String filename) {
        this.artistId = artistId;
        this.albumId = albumId;
        this.title = title;
        this.trackNumber = trackNumber;
        this.format = format;
        this.length = length;
        this.bitrate = bitrate;
        this.filename = filename;
    }

    public String toCsv(){
        StringBuilder sb = new StringBuilder();
        sb.append(artistId).append(';')
                .append(albumId).append(';')
                .append(title).append(';')
                .append(trackNumber).append(';')
                .append(format).append(';')
                .append(length).append(';')
                .append(bitrate).append(';')
                .append(filename);
        return sb.toString();
    }

    //Getter-Setter
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getBitrate() {
        return bitrate;
    }
    public void setBitrate(String bitrate) {
        this.bitrate = bitrate;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }

    public int getTrackNumber() {
        return trackNumber;
    }
    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getAlbumId() {
        return albumId;
    }
    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getArtistId() {
        return artistId;
    }
    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
}

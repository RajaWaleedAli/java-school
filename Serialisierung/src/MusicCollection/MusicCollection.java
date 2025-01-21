package MusicCollection;

import java.io.*;
import java.util.*;

class MusicCollection implements Serializable {
    private ArrayList<Artist> artists;
    private ArrayList<Album> albums;
    private ArrayList<Song> songs;

    public MusicCollection() {
        this.artists = new ArrayList<>();
        this.albums = new ArrayList<>();
        this.songs = new ArrayList<>();
    }

    public void addArtist(Artist artist) {
        this.artists.add(artist);
    }
    public void addAlbum(Album album) {
        this.albums.add(album);
    }
    public void addSong(Song song) {
        this.songs.add(song);
    }
    public void remArtist(Artist artist) {
        this.artists.remove(artist);
    }
    public void remAlbum(Album album) {
        this.albums.remove(album);
    }
    public void remSong(Song song) {
        this.songs.remove(song);
    }

    //Getter-Setter
    public List<Artist> getArtists() {
        return artists;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setArtists(ArrayList<Artist> artists) {
        this.artists = artists;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}

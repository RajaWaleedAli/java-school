package MusicCollection;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
            // Test data files
            File artistFile = new File("artist.bin");
            File albumFile = new File("albums.bin");
            File songFile = new File("songs.bin");
            //File singleBinaryFile = new File("musiccollection.dat");

            // Example data
            Artist artist = new Artist(1, "Vangelis", Arrays.asList("new age", "electronic"), null, "http://www.lastfm.de/music/Vangelis");
            Album album = new Album(1, 1, "Chariots Of Fire", 7, "Polydor", "30. Nov. 1980", 9.90);
            Song song = new Song(1, 1, "Chariots of Fire", 1, "mp3", 211, "192kbps", "/home/max/music/vangelis-chariots.mp3");

            MusicCollection collection = new MusicCollection();
            collection.addArtist(artist);
            collection.addArtist(artist);
            collection.addArtist(artist);
            collection.addAlbum(album);
            collection.addAlbum(album);
            collection.addAlbum(album);
            collection.addSong(song);
            collection.addSong(song);
            collection.addSong(song);

            MusicCollectionManager.binaryWrite(collection, artistFile, albumFile, songFile);

            MusicCollection binaryReadCollection = MusicCollectionManager.binaryRead(artistFile, albumFile, songFile);
            System.out.println("Read from binary files: " + binaryReadCollection);

            System.out.println("Artist");
            for(Artist a:binaryReadCollection.getArtists()) {
                    System.out.println(a.toCsv());
            }
            System.out.println("Album");
            for(Album a:binaryReadCollection.getAlbums()) {
                    System.out.println(a.toCsv());
            }
            System.out.println("Song");
            for(Song s:binaryReadCollection.getSongs()) {
                    System.out.println(s.toCsv());
            }
    }
}

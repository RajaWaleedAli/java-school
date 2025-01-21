package MusicCollection;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MusicCollectionManager {
    public static MusicCollection read(File artists, File albums, File songs) {
        MusicCollection collection = new MusicCollection();
        String line;
        try(BufferedReader artistReader = new BufferedReader(new FileReader(artists))){
            while ((line = artistReader.readLine()) != null) {
                String[] data = line.split(";");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                List<String> genres = Arrays.asList(data[2].split(","));
                String website = data[3].equals("-") ? null : data[3];
                String lastFmUrl = data[4];
                collection.addArtist(new Artist(id, name, genres, website, lastFmUrl));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            System.err.println("Error reading artists file");
        }

        try (BufferedReader albumReader = new BufferedReader(new FileReader(albums))) {
            while ((line = albumReader.readLine()) != null) {
                String[] data = line.split(";");
                int id = Integer.parseInt(data[0]);
                int artistId = Integer.parseInt(data[1]);
                String name = data[2];
                int numberOfTracks = Integer.parseInt(data[3]);
                String label = data[4];
                String releaseDate = data[5];
                double price = Double.parseDouble(data[6]);
                collection.addAlbum(new Album(id, artistId, name, numberOfTracks, label, releaseDate, price));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            System.err.println("Error reading albums file");
        }

        try (BufferedReader songReader = new BufferedReader(new FileReader(songs))){
            while ((line = songReader.readLine()) != null) {
                String[] data = line.split(";");
                int artistId = Integer.parseInt(data[0]);
                int albumId = Integer.parseInt(data[1]);
                String title = data[2];
                int trackNumber = Integer.parseInt(data[3]);
                String format = data[4];
                int length = Integer.parseInt(data[5]);
                String bitrate = data[6];
                String filename = data[7];
                collection.addSong(new Song(artistId, albumId, title, trackNumber, format, length, bitrate, filename));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            System.err.println("Error reading songs file");
        }

        return collection;
    }

    public static void write(MusicCollection collection, File artists, File albums, File songs) {
        try (BufferedWriter artistWriter = new BufferedWriter(new FileWriter(artists))){
            for(Artist artist:collection.getArtists()){
                artistWriter.write(artist.toCsv());
                artistWriter.newLine();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            System.err.println("Error writing artists file");
        }

        try(BufferedWriter albumWriter = new BufferedWriter(new FileWriter(albums))){
            for(Album album:collection.getAlbums()){
                albumWriter.write(album.toCsv());
                albumWriter.newLine();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            System.err.println("Error writing albums file");
        }

        try(BufferedWriter songWriter = new BufferedWriter(new FileWriter(songs))){
            for(Song song:collection.getSongs()){
                songWriter.write(song.toCsv());
                songWriter.newLine();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            System.err.println("Error writing songs file");
        }
    }

    public static MusicCollection binaryRead(File artists, File albums, File songs) {
        MusicCollection collection = new MusicCollection();

        try (ObjectInputStream artistInput = new ObjectInputStream(new FileInputStream(artists))){

            collection.setArtists((ArrayList<Artist>) artistInput.readObject());
        }catch (FileNotFoundException e){
            System.err.println("Error opening artists file");
            e.printStackTrace();
        }catch (ClassNotFoundException|IOException e){
            System.err.println("Error reading arists file");
            e.printStackTrace();
        }

        try (ObjectInputStream albumInput = new ObjectInputStream(new FileInputStream(albums))) {
            collection.setAlbums((ArrayList<Album>) albumInput.readObject());
        }catch (FileNotFoundException e){
            System.err.println("Error opening album file");
            e.printStackTrace();
        }catch (ClassNotFoundException|IOException e){
            System.err.println("Error reading album file");
            e.printStackTrace();
        }

        try (ObjectInputStream songInput = new ObjectInputStream(new FileInputStream(songs))) {
            collection.setSongs((ArrayList<Song>) songInput.readObject());
        }catch (FileNotFoundException e){
            System.err.println("Error opening artists file");
            e.printStackTrace();
        }catch (ClassNotFoundException|IOException e){
            System.err.println("Error reading arists file");
            e.printStackTrace();
        }

        return collection;
    }

    public static void binaryWrite(MusicCollection collection, File artists, File albums, File songs){
        try (ObjectOutputStream artistOutput = new ObjectOutputStream(new FileOutputStream(artists))) {
            artistOutput.writeObject(collection.getArtists());
        }catch (FileNotFoundException e){
            System.err.println("Error opening artists file");
            e.printStackTrace();
        }catch (IOException e){
            System.err.println("Error writing artists file");
        }
        try (ObjectOutputStream albumOutput = new ObjectOutputStream(new FileOutputStream(albums))) {
            albumOutput.writeObject(collection.getAlbums());
        }catch (FileNotFoundException e){
            System.err.println("Error opening albums file");
            e.printStackTrace();
        }catch (IOException e){
            System.err.println("Error writing albums file");
        }
        try (ObjectOutputStream songOutput = new ObjectOutputStream(new FileOutputStream(songs))) {
            songOutput.writeObject(collection.getSongs());
        }catch (FileNotFoundException e){
            System.err.println("Error opening songs file");
            e.printStackTrace();
        }catch (IOException e){
            System.err.println("Error writing songs file");
        }
    }

    public static void binaryWriteSingleFile(MusicCollection collection, File musicCollection) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(musicCollection))) {
            output.writeObject(collection);
        }catch (FileNotFoundException e){
            System.err.println("Error opening musicCollection file");
            e.printStackTrace();
        }catch (IOException e){
            System.err.println("Error writing musicCollection file");
        }
    }
}

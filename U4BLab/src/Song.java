import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.ArrayList;

public class Song {
    private final String specs = "%-21s %-24s %-28s %-5s %-7s";
    private String title;
    private String artist;
    private String album;
    private String min;
    private String year;
    private String genre;

    public Song(String title, String artist, String album, String min, String year, String genre) throws FileNotFoundException {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.min = min;
        this.year = year;
        this.genre = genre;
//        years.add(Integer.valueOf(this.year));
    }

    public String getAlbum() {
        return album;
    }
    public String getArtist() {
        return artist;
    }
    public String getGenre() {
        return genre;
    }
    public String getMin() {
        return min;
    }
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return Integer.parseInt(year);
    }
    public String toString(){
        return String.format(specs, artist, title, album, year, genre);
    }
}

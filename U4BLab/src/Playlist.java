import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Playlist {
    static ArrayList<Song> origin = new ArrayList<>();
    static ArrayList<Song> sortedSongs = new ArrayList<>();
    public Playlist() {
        try {
            Scanner sc = new Scanner(new File("spotify_unique_years_artists.txt"));
            while(sc.hasNextLine()){
                String[] str = sc.nextLine().split(",");
                Song song = new Song(str[0], str[1], str[2], str[3], str[4], str[5]);
                origin.add(song);
            }
        } catch (FileNotFoundException e) {
            System.out.println();
            System.out.println();
            System.out.println("File is not found. Try again");
            System.out.println();
            System.out.println();
        }
    }

    public static void genreSort(String word){
        // removes all previous sorted songs
        sortedSongs.removeAll(sortedSongs);
        for (int i = 0; i < origin.size()-1; i++) {
            // checks if the origin genre is equal to the given genre
            if(word.equalsIgnoreCase(origin.get(i).getGenre())){
                // adds the origin genre to the sortedSongs array
                sortedSongs.add(origin.get(i));
            }else if(origin.get(i).getGenre().contains(word)){
                sortedSongs.add(origin.get(i));
            }
        }

        // if there are no songs, it displays the given message
        // otherwise it displays what songs are added into the sortedSongs array
        if(!sortedSongs.isEmpty()){
            for(Song song: sortedSongs){
                System.out.println(song.toString());
            }
        }else {
            System.out.println("No genres match any song in this playlist");
        }

    }

    public static void oldToNew(){ // years of songs
        sortedSongs.removeAll(sortedSongs);
        sortedSongs.addAll(origin);

        // take each object of the array and switch them around using .set() method
        // 
        // insertion sort
        for (int i = 1; i < sortedSongs.size(); i++) {
            Song current = sortedSongs.get(i);
            int x = i-1;

            while(x>=0 && sortedSongs.get(x).getYear()>current.getYear()){
                sortedSongs.set(x+1, sortedSongs.get(x));
                x--;
            }
        }


        // displays all songs in sorted arraylist
        for(Song song: sortedSongs){
            System.out.println(song.toString());
        }
    }

    public static void newToOld(){
        sortedSongs.removeAll(sortedSongs);
        sortedSongs.addAll(origin);

        // take each object of the array and switch them around using .set() method
        //
        // insertion sort
        for (int i = 1; i < sortedSongs.size(); i++) {
            Song current = sortedSongs.get(i);
            int x = i-1;

            while(x>=0 && sortedSongs.get(x).getYear()>current.getYear()){
                sortedSongs.set(x+1, sortedSongs.get(x));
                x--;
            }
        }

        // reverse the array using Collections.reverse() method
        Collections.reverse(sortedSongs);

        // displays all songs in sorted arraylist
        for(Song song: sortedSongs){
            System.out.println(song.toString());
        }
    }

    public static void aToZ(){
        sortedSongs.removeAll(sortedSongs);
        sortedSongs.addAll(origin);
        // take each object of the array and switch them around using .set() method
        //
        // insertion sort
        for (int i = 0; i < sortedSongs.size()-1; i++) {
            int index = i;

            for (int j = i+1; j < sortedSongs.size(); j++) {
                if(sortedSongs.get(j).getArtist().compareToIgnoreCase(sortedSongs.get(index).getArtist()) < 0){
                    index=j;
                }
            }

            sortedSongs.set(index, sortedSongs.set(i, sortedSongs.get(index)));
        }

        // displays all songs in sorted arraylist
        for(Song song: sortedSongs){
            System.out.println(song.toString());
        }
    }

    public static void zToA(){
        sortedSongs.removeAll(sortedSongs);
        sortedSongs.addAll(origin);
        for (int i = 0; i < sortedSongs.size()-1; i++) {
            int index = i;

            for (int j = i+1; j < sortedSongs.size(); j++) {//                                 just switch the < to >
                if(sortedSongs.get(j).getArtist().compareToIgnoreCase(sortedSongs.get(index).getArtist()) < 0){
                    index=j;
                }
            }

            sortedSongs.set(index, sortedSongs.set(i, sortedSongs.get(index)));
        }

        Collections.reverse(sortedSongs);

        // displays all songs in sorted arraylist
        for(Song song: sortedSongs){
            System.out.println(song.toString());
        }

    }

    public static void displayAll(){
        sortedSongs.removeAll(sortedSongs);
        sortedSongs.addAll(origin);
        for(Song song: sortedSongs){
            System.out.println(song.toString());
        }
    }
}

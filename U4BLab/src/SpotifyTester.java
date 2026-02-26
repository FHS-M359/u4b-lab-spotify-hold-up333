import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SpotifyTester {
    public static void main(String[] args) {
        Scanner input = null;
        boolean state;
        int num;

        try {
            input = new Scanner(System.in);

            new Playlist();
//            String str1 = "hello";
//            String str2 = "Bye";
//            System.out.println(str2.compareToIgnoreCase(str1));
            System.out.println("========= Spotify Menu =========");
            System.out.println("1) Sort artist A-Z");
            System.out.println("2) Sort artist Z-A");
            System.out.println("3) Sort by year (oldest-newest)");
            System.out.println("4) Sort by year (newest-oldest)");
            System.out.println("5) Search by genre");
            System.out.println("6) Display all songs");
            System.out.println("7) Quit");

            num = input.nextInt();
            while (num != 7) {
                while ((num > 0) && (num < 7)) {

                    if (num == 1) {
                        Playlist.aToZ();
                        state = true;
                    } else if (num == 2) {
                        Playlist.zToA();
                        state = true;
                    } else if (num == 3) {
                        Playlist.oldToNew();
                        state = true;
                    } else if (num == 4) {
                        Playlist.newToOld();
                        state = true;
                    } else if (num == 5) {
                        System.out.println("Which genre do you wish to search for");
                        input.nextLine();
                        String word = input.nextLine();
                        Playlist.genreSort(word);
                        state = true;
                    } else{
                        Playlist.displayAll();
                        state = true;
                    }

                    while (state) {
                        System.out.println();
                        System.out.println();
                        System.out.println("========= Spotify Menu =========");
                        System.out.println("1) Sort artist A-Z");
                        System.out.println("2) Sort artist Z-A");
                        System.out.println("3) Sort by year (oldest-newest)");
                        System.out.println("4) Sort by year (newest-oldest)");
                        System.out.println("5) Search by genre");
                        System.out.println("6) Display all songs");
                        System.out.println("7) Quit");
                        state = false;
                    }


                    num = input.nextInt();
                }
                System.out.println("Please input a number between 1 and 7");
                input.nextLine();
                num = input.nextInt();
            }

            System.out.println("Have a nice day");

        } catch (InputMismatchException e) {
            System.out.println("please input a number 1-7");
            input.nextLine();
            num = input.nextInt();
        } catch (NoSuchElementException e) {
            System.out.println("Please input another value");
        }
    }
}

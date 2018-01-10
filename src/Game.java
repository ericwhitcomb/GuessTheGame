import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    /**
     * Fields
     */
    private String movie;
    private int count;

    Game() {
        this.movie = null;
    }

    Game(String movie) {
        this.setMovie(movie);
    }

    /**
     * Get movie
     * @return
     */
    public String getMovie() {
        return movie;
    }

    /**
     * Set movie
     * @param movie
     */
    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void print() {
        System.out.println("You are guessing:" + this.getMovie());
        System.out.println("You have guessed (" + this.count + ") wrong letters:");
        System.out.print("Guess a letter:");
    }

    /**
     * Main method, runs game
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<String> movies = new ArrayList<String>();
//        System.out.println(movies.size());

        while (scanner.hasNextLine()) {
            movies.add(scanner.nextLine().trim());
        }
//        System.out.println(movies.size());

        int n = (int) (Math.random() * movies.size() - 1);
//        System.out.println(n);

//        System.out.println(movies.get(n));

        Game game = new Game(movies.get(n));
        game.print();
    }
}

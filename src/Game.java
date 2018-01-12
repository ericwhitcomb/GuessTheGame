import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private static int INCORRECT_GUESS_LIMIT = 10;

    /**
     * Fields
     */
    private ArrayList<String> movies;
    private String movie;

    private int incorrectGuesses;

    private Scanner scanner;

    private String maskedMovie;

    /**
     * Default Game constructor
     */
    Game() {
        this.movies = null;
        this.movie = null;
        this.incorrectGuesses = 0;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Game constructor
     *
     * @param movies
     */
    Game(ArrayList<String> movies) {
        this.setMovies(movies);
        this.movie = null;
        this.incorrectGuesses = 0;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Display current game information
     */
    private void display() {
        System.out.println("You are guessing:" + this.movie);
        System.out.println("You have guessed (" + this.incorrectGuesses + ") wrong letters:");
    }

    /**
     * Get movie list
     *
     * @return movies
     */
    public ArrayList<String> getMovies() {
        return this.movies;
    }

    /**
     * Prints movie list to console
     */
    public void printMovies() {
        for (String movie : this.movies) {
            System.out.println(movie);
        }
    }

    private String promptPlayer() {
        System.out.print("Guess a letter:");
        return scanner.next();
    }

    /**
     * Selects a random movie from the movie list
     *
     * @return movie
     */
    private String selectRandomMovie() {
        return this.movies.get((int) (Math.random() * movies.size() - 1));
    }

    /**
     * Set movie list
     *
     * @param movies
     */
    public void setMovies(ArrayList<String> movies) {
        this.movies = movies;
    }

    /**
     * Starts a new game
     */
    public void start() {
        this.movie = this.selectRandomMovie();
        this.incorrectGuesses = 0;

        while (incorrectGuesses < INCORRECT_GUESS_LIMIT) {
            this.display();
            System.out.println(this.promptPlayer());
            this.incorrectGuesses++;
        }
    }
}

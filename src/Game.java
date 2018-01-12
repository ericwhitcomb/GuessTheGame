import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class Game {

    private static int INCORRECT_GUESS_LIMIT = 3;

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
        System.out.println("You are guessing:" + this.maskedMovie);
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
//        return this.movies.get((int) (Math.random() * movies.size() - 1));
        return this.movies.get(3);
    }

    /**
     * Set movie for current game
     *
     * @param movie
     */
    private void setMovie(String movie) {
        StringJoiner joiner = new StringJoiner(" ");
        String[] words = movie.split(" ");
        for (String word : words) {
            joiner.add(Character.toUpperCase(word.charAt(0)) + word.substring(1));
        }
        this.movie = joiner.toString();

        char[] characters = this.movie.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            if (Character.isLetter(characters[i])) {
                characters[i] = '_';
            }
        }
        this.maskedMovie = String.copyValueOf(characters);
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
        this.setMovie(this.selectRandomMovie());

        this.incorrectGuesses = 0;

        while (this.incorrectGuesses < INCORRECT_GUESS_LIMIT) {
            this.display();
            String guess = this.promptPlayer();
            this.incorrectGuesses++;
        }

        if (this.incorrectGuesses >= INCORRECT_GUESS_LIMIT) {
            System.out.println("You lose!");
            System.out.println("The movie was '" + this.movie + "'");
        }
    }
}

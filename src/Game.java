import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class Game {

    private static final int INCORRECT_GUESS_LIMIT = 10;
    private static final char MASKED_CHARACTER = '_';

    /**
     * Fields
     */
    private ArrayList<String> movies;
    private String movie;
    private String maskedMovie;

    private ArrayList<String> incorrectGuesses;

    private Scanner scanner;

    /**
     * Default Game constructor
     */
    Game() {
        this.movies = null;
        this.movie = null;
        this.incorrectGuesses = null;
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
        this.incorrectGuesses = null;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Display current game information
     */
    private void display() {
        System.out.println("You are guessing:" + this.maskedMovie);
        System.out.print("You have guessed (" + this.incorrectGuesses.size() + ") wrong letters:");
        for (String s : this.incorrectGuesses) {
            System.out.print(" " + s.toLowerCase());
        }
        System.out.println();
    }

    /**
     * Format movie to include Uppercase letters for first letter in words
     *
     * @param movie
     * @return
     */
    private String formatMovie(String movie) {
        StringJoiner joiner = new StringJoiner(" ");
        String[] words = movie.split(" ");
        for (String word : words) {
            joiner.add(Character.toUpperCase(word.charAt(0)) + word.substring(1));
        }
        return joiner.toString();
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
        char c = scanner.nextLine().toCharArray()[0];
        if (Character.getType(c) == Character.UPPERCASE_LETTER ||
                Character.getType(c) == Character.LOWERCASE_LETTER) {
            return String.valueOf(c);
        }
        return null;
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
     * Set movie for current game
     *
     * @param movie
     */
    private void setMovie(String movie) {
        this.movie = movie.toLowerCase();

        char[] characters = this.movie.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            if (Character.isLetter(characters[i])) {
                characters[i] = MASKED_CHARACTER;
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
        this.incorrectGuesses = new ArrayList<String>();

        while (this.incorrectGuesses.size() < INCORRECT_GUESS_LIMIT) {

            this.display();

            String guess = this.promptPlayer();
            if (guess == null) {
                System.out.println("Invalid entry. Must enter alphabetic character.");
                continue;
            }

            if (this.movie.contains(guess.toLowerCase())) {
                char[] chars = this.maskedMovie.toCharArray();
                for (int i = this.movie.indexOf(guess.toLowerCase()); i >= 0; i = this.movie.indexOf(guess.toLowerCase(), ++i))
                {
                    chars[i] = this.movie.charAt(i);
                }
                this.maskedMovie = this.formatMovie(new String(chars));

                if (this.maskedMovie.equalsIgnoreCase(this.movie)) {
                    break;
                }
            } else {
                if (!this.incorrectGuesses.contains(guess.toLowerCase())) {
                    this.incorrectGuesses.add(guess.toLowerCase());
                    this.incorrectGuesses.sort(String.CASE_INSENSITIVE_ORDER);
                }
            }
        }

        if (this.incorrectGuesses.size() >= INCORRECT_GUESS_LIMIT) {
            System.out.println("You lose!");
            System.out.println("The movie was '" + this.formatMovie(this.movie) + "'.");
        } else {
            System.out.println("You win!");
            System.out.println("You have guessed '" + this.formatMovie(this.movie) + "' correctly.");
        }
    }
}

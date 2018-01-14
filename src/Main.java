import java.io.FileNotFoundException;

public class Main {
    private static final String DEFAULT_FILENAME = "movies.txt";

    /**
     * Main method, runs game
     *
     * @param args
     */
    public static void main(String[] args) {
        Game game = null;
        try {
            game = new Game(FileManager.getList(DEFAULT_FILENAME));
            game.start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

import java.io.FileNotFoundException;

public class Main {

    /**
     * Main method, runs game
     *
     * @param args
     */
    public static void main(String[] args) {
        Game game = null;
        try {
            game = new Game(FileManager.getList("movies.txt"));
            game.start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

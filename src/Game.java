import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<String> movies = new ArrayList<String>();
        System.out.println(movies.size());

        while (scanner.hasNextLine()) {
            movies.add(scanner.nextLine().trim());
        }
        System.out.println(movies.size());

        int n = (int) (Math.random() * movies.size() - 1);
        System.out.println(n);

        System.out.println(movies.get(n));

        

    }
}

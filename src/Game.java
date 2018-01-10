import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);
        System.out.println(scanner.nextLine());
    }
}

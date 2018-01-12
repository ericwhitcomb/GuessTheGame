import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    /**
     * Opens file and returns contents in ArrayList
     *
     * @param filename
     * @return list
     * @throws FileNotFoundException
     */
    public static ArrayList<String> getList(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        ArrayList<String> lines = new ArrayList<String>();

        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine().trim());
        }

        scanner.close();

        return lines;
    }
}

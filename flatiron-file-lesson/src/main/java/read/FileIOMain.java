package read;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileIOMain {

    public static void main(String[] args) {
        Path path = Paths.get("simple.txt");
        try {
            String content = Files.readString(path);

            System.out.println(content);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        List<String> linesInFile;
        try {
            linesInFile = Files.readAllLines(path);

            System.out.println("There are " + linesInFile.size() + " lines in the file.");
            for (String line : linesInFile) {
                System.out.println(line);
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

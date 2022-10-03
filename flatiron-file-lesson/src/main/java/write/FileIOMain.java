package write;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileIOMain {

    public static void main(String[] args) {
        Path path = Paths.get("simple.txt");
        try {
            Files.writeString(path, "example of writing to a file.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        List<String> names = new ArrayList<String>(Arrays.asList(
                "Leslie",
                "Ron",
                "Ann"
        ));

        String listAsString = "";
        for (String name : names) {
            listAsString = listAsString.concat(name).concat("\n");
        }

        try {
           Files.writeString(path, listAsString);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class FileCopy {
    public static void main(String[] args) {
        String sourceFilePath = "file.txt";  // Replace with your source file path
        String destinationFilePath = "emfile.txt"; // Replace with your destination file path
        try {
            List<String> lines = Files.readAllLines(Paths.get(sourceFilePath));
            Files.write(Paths.get(destinationFilePath), lines);
            System.out.println("Copied data:");
            for (String line : lines) {
                System.out.println(line);
            }
            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.err.println("Error during file copy: " + e.getMessage());
        }
    }
}

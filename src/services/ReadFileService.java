package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFileService {
    public static ArrayList<String> readFile(String path) {
        File file = new File(path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> stringsInFile = new ArrayList<>();

        stringsInFile.add(scanner.nextLine());

        while(scanner.hasNext()) {
            stringsInFile.add(scanner.nextLine());
        }

        scanner.close();
        return stringsInFile;
    }
}

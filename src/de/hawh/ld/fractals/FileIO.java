package de.hawh.ld.fractals;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class FileIO {

    public static void fileWriter(ArrayList list, String filename) {
        Path file = Paths.get(filename);
        try {
            Files.write(file, list, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  static ArrayList<String> fileReader(String filename ) {
        ArrayList<String> list = new ArrayList<>();
        File temp = new File(filename);
        Scanner file = null;
        try {
            file = new Scanner(temp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (Objects.requireNonNull(file).hasNextLine()) {
            list.add(file.nextLine());
        }
        return list;
    }
}

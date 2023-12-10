package ru.vsu.cs.yachnyy_m_a.obj_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIO {
    public static String readFileContent(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        StringBuilder res = new StringBuilder();
        while (scanner.hasNext()){
            res.append(scanner.nextLine()).append('\n');
        }
        return res.toString();
    }
}

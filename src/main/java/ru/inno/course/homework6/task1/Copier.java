package ru.inno.course.homework6.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Copier {
    public static void copyTextFile(String readPath, String writePath) throws IOException {
        List<String> fileContent = Files.readAllLines(Path.of(readPath));
        for (String s : fileContent) {
            Files.writeString(Path.of(writePath), s + "\n", StandardOpenOption.APPEND);
        }
    }
}

package com.jpmc.midascore.foundation;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileLoader {
    public List<String> loadStrings(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);

        if (file.length() == 0) {
            return new String[0];
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder builder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append("\n");
                value = reader.readLine();
            }

            List<String> result = new ArrayList<>();
            String text = builder.toString();
            String[] words = text.split("[\\s\\p{Punct}]+");

            for (String word : words) {
                if (word.toLowerCase().startsWith("w")) {
                    result.add(word.toLowerCase());
                }
            }

            Collections.sort(result);
            return result.toArray(new String[0]);
        } catch (IOException e) {
            throw new  RuntimeException("Can't read file", e);
        }
    }
}

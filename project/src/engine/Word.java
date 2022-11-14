package engine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Word {
    public static Set<String> stopWords = new HashSet<>();
    private String words;

    private Word(String words) {
        this.words = words;
    }
    public boolean isKeyWord() {

        return false;
    }

    public static boolean loadStopWords(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                stopWords.add(br.readLine());
            }
            return true;
        } catch (FileNotFoundException e) {

        return false;
        } catch (IOException e) {
            return false;
        }
    }
}

package engine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Word {
    public static Set<String> stopWords = new HashSet<>();
    private String words;


    private Word(String words) {
        this.words = words;
    }

    public boolean isValidWord() {
        for (int i = 0; i < words.length(); i++) {
            if (!Character.isDigit(words.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public String getPrefix() {
        String prefix = "";
        if (isValidWord()) {
            return "";
        }
        for (int i = 0; i < words.length(); i++) {
            if(!(words.charAt(i) > 'a' && words.charAt(i) < 'z') && !(words.charAt(i) > 'A' && words.charAt(i) < 'Z')) {
                prefix.concat(String.valueOf(words.charAt(i)));
            } else {
                break;
            }
        }
        return prefix;
    }
    public String getSuffix() {
        String suffix = "";
        if (isValidWord()) {
            return "";
        }
        for (int i = words.length() - 1; i >= 0; i--) {
            if(!(words.charAt(i) > '1' && words.charAt(i) < '9') && !(words.charAt(i) > 'a' && words.charAt(i) < 'z') && !(words.charAt(i) > 'A' && words.charAt(i) < 'Z')) {
                suffix.concat(String.valueOf(words.charAt(i)));
            } else {
                break;
            }
        }
        return suffix;
    }
    public String getText() {
        if (isValidWord()) {
            return words;
        }
        return words.replace(getPrefix(), "").replace(getSuffix(), "");
    }


    

    public boolean equals(Object o) {
        return false;
    }
    public boolean isKeyword() {
        for (String s : stopWords) {
            if (words.equals(s)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Word{}";
    }

    public static Word createWord(String rawText) {
        Word newWord = new Word(rawText);
        return newWord;
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

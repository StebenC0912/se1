package engine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Word {
    public static Set<String> stopWords = new HashSet<>();
    private String words;

    private Word(String words) {
        this.words = words;
    }

    public boolean isValidWord() {
        if (words.length() == 0) {
            return false;
        }
        boolean valid = false;
        int countLetter = 0;
        // all characters in the word must be letters
        // check if string have space return false
        for (int i = 0; i < words.length(); i++) {
            if (Character.isDigit(words.charAt(i))) {
                return false;
            } else if (Character.isLetter(words.charAt(i))) {
                countLetter++;
                valid = true;
            } else {
                if (words.charAt(i) == ' ') {
                    return false;
                }
            }
        }
        if (countLetter < words.length()) {
            valid = false;
        }

        return valid;
    }

    public String getPrefix() {
        String prefix = "";
        if (!isValidWord()) {
            return prefix;
        }
        for (int i = 0; i < words.length(); i++) {
            if (!Character.isLetter(words.charAt(i))) {
                prefix += words.charAt(i);
            } else {
                break;
            }
        }
        return prefix;
    }

    public String getSuffix() {
        String suffix = "";
        if (!isValidWord()) {
            return "";
        }
        for (int i = words.length() - 1; i >= 0; i--) {
            if (!Character.isLetter(words.charAt(i))) {
                suffix.concat(String.valueOf(words.charAt(i)));
            } else {
                break;
            }
        }
        return suffix;
    }

    public String getText() {
        if (!isValidWord()) {
            return words;
        }
        return words.replace(getPrefix(), "").replace(getSuffix(), "");
    }


    public boolean equals(Object o) {
        if (createWord(o.toString()).getText().toLowerCase() == this.getText().toLowerCase()) {
            return true;
        }
        return false;
    }

    public boolean isKeyword() {
        if (!isValidWord()) {
            return false;
        }
        for (String s : stopWords) {
            if (words.equals(s)) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return words;
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

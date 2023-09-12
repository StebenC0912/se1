package a1_2001040210;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Word {
    public static Set<String> stopWords;
    private String words;

    private Word(String words) {
        this.words = words;
    }

    public static Word createWord(String rawText) {
        return new Word(rawText);
    }

    /**
     * Check if the word is a keyword
     * 
     * @return true if the word is a keyword, false otherwise
     */
    public boolean isKeyword() {
        return isValidWord() && !stopWords.contains(getText().toLowerCase());
    }

    /**
     * Check if the word is valid
     * 
     * @return true if the word is valid, false otherwise
     */
    public boolean isValidWord() {
        if (words.length() == 0 || words.contains(" ")) {
            return false;
        }
        boolean valid = false;
        // all characters in the word must be letters
        // check if string have space return false
        for (int i = 0; i < words.length(); i++) {
            if (Character.isDigit(words.charAt(i))) {
                return false;
            } else if (Character.isLetter(words.charAt(i))) {
                valid = true;
            }
        }
        return valid;
    }

    /**
     * Get the prefix of the word
     * 
     * @return the prefix of the word
     */
    public String getPrefix() {
        if (!isValidWord()) {
            return "";
        }
        String prefix = "";
        for (int i = 0; i < words.length(); i++) {
            if (!Character.isLetter(words.charAt(i))) {
                prefix += words.charAt(i);
            } else {
                break;
            }
        }
        return prefix;
    }

    /**
     * Get the suffix of the word
     * 
     * @return the suffix of the word
     */
    public String getSuffix() {
        int suffixIndex = words.length();
        if (!isValidWord()) {
            return "";
        }
        if (words.contains("'")) {
            int indexOfSingleQuote = words.lastIndexOf("'");
            return words.substring(indexOfSingleQuote);
        }
        for (int i = words.length() - 1; i >= 0; i--) {
            if (Character.isLetter(words.charAt(i))) {
                suffixIndex = i;
                break;
            }
        }
        return words.substring(suffixIndex + 1);
    }

    /**
     * Get the text of the word
     * Check if the word is valid
     * 
     * @return the text of the word
     */
    public String getText() {
        if (!isValidWord()) {
            return words;
        }
        StringBuilder sb = new StringBuilder(words);
        String str = sb.delete(0, getPrefix().length()).toString();
        return sb.delete(str.length() - getSuffix().length(), str.length()).toString();
    }

    /**
     * Load the stop words from a file
     * 
     * @param fileName
     * @return true if the stop words are loaded successfully, false otherwise
     */
    public static boolean loadStopWords(String fileName) {
        stopWords = new HashSet<>();
        try (FileReader fr = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fr)) {
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

    /**
     * Check if the word is equal to another word
     * 
     * @param o the word to be compared with
     * @return true if the word is equal to another word, false otherwise
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (createWord(o.toString()).getText().equalsIgnoreCase(this.getText())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return words;
    }
}

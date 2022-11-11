package week10_TranKhacLinh_2001040121.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Xref {
    private Document document;
    private List<String> words;
    private Map<String, List<Integer>> result;

    public Map<String, List<Integer>> index(String doc) {
        result = new HashMap<>();
        document = new Document(doc);
        List<Line> lines = document.getLines();
        for (Line line : lines) {
            words = line.getWords();
            for (String word : words) {
                if (result.containsKey(word)) {
                    result.get(word).add(words.indexOf(word));
                } else {
                    result.put(word, List.of(words.indexOf(word)));
                }
            }
        }
        return result;
    }

    public List<String> words(String doc) {
        String[] word = doc.split(" ");
        words.addAll(Arrays.asList(word));
        for (String wString : words) {
            if (!wString.contains("[^a-zA-Z]")) {
                words.remove(wString);
            }
        }
        return words;
    }
    public static void main(String[] args) {
        String doc = "fsdarw 2,3 asdf ";
    }

}

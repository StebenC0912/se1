package engine;

import java.util.List;

public class Query {
    private List<String> queryWords;
    public Query(String searchPhrase) {
        String[] words = searchPhrase.split(" ");
        for (String word : words) {
            if (Word.createWord(word).isKeyword()) {
                queryWords.add(word);
            }
        }
    }
}

package a1_2001040210;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Query {
    private String searchPhrase;

    // constructor
    public Query(String searchPhrase) {
        this.searchPhrase = searchPhrase;
    }

    /**
     * 
     * Get all keywords in the search phrase
     * 
     * @return a list of keywords in the search phrase
     */
    public List<Word> getKeywords() {
        List<Word> keywords = new ArrayList<>();
        for (String word : searchPhrase.split(" ")) {
            if (!Word.createWord(word).isKeyword()) {
                continue;
            }
            keywords.add(Word.createWord(word));
        }
        return keywords;
    }

    /**
     * Performs the search function of the engine.
     * 
     * @param q the query to be searched
     * @return a list of sorted search results
     */
    public List<Match> matchAgainst(Doc d) {
        List<Match> matches = new ArrayList<>();
        for (Word word : getKeywords()) {
            int frequency = 0;
            int firstIndex = 0;
            for (Word titleWord : d.getTitle()) {
                if (word.equals(titleWord)) {
                    frequency++;
                    firstIndex = d.getTitle().indexOf(titleWord);
                }
            }
            for (Word bodyWord : d.getBody()) {
                if (word.equals(bodyWord)) {
                    frequency++;
                    firstIndex = d.getBody().indexOf(bodyWord);
                }

            }
            if (frequency > 0) {
                matches.add(new Match(d, word, frequency, firstIndex));
            }
        }
        Collections.sort(matches);
        return matches;
    }
}

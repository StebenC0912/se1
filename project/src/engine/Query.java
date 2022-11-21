package engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Query {
    private String searchPhrase;
    private List<String> queryWords = new ArrayList<String>();

    public Query(String searchPhrase) {
        this.searchPhrase = searchPhrase;
    }

    public List<Word> getKeywords() {
        List<Word> keywords = new ArrayList<>();
        String[] words = searchPhrase.split(" ");
        for (String word : searchPhrase.split(" ")) {
            if (!Word.createWord(word).isKeyword()) {
                continue;
            }
            keywords.add(Word.createWord(word));
        }
        return keywords;
    }

    // Returns a list of matches against the input document. Sort matches by position
    // where the keyword first appears in the document. See the Match class for more
    // information about search matches.
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

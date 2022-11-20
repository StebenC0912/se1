package engine;

import java.util.ArrayList;
import java.util.List;

public class Query {
    private List<String> queryWords = new ArrayList<String>();
    public Query(String searchPhrase) {
        String[] words = searchPhrase.split(" ");
        for (String word : words) {
            if (Word.createWord(word).isKeyword()) {
                queryWords.add(word);
            }
        }
    }

    public List<Word> getKeywords() {
        List<Word> keywords = new ArrayList<>();
        for (String word : queryWords) {
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
            matches.add(new Match(d,word, frequency, firstIndex));
        }
        return matches;


    }

}

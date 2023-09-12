package a1_2001040210;

import java.util.ArrayList;
import java.util.List;

public class Doc {
    private List<Word> title;
    private List<Word> body;

    // constructor
    public Doc(String content) {
        String[] lines = content.split("\\n");
        String titleString = lines[0];
        List<Word> docTitle = new ArrayList<>();
        List<Word> docBody = new ArrayList<>();
        for (String wordString : titleString.split("\\s+")) {
            Word word = Word.createWord(wordString);
            docTitle.add(word);
        }
        String bodyString = lines[1];
        for (String wordString : bodyString.split("\\s+")) {
            Word word = Word.createWord(wordString);
            docBody.add(word);
        }
        this.title = docTitle;
        this.body = docBody;
    }

    // getter
    public List<Word> getTitle() {
        return title;
    }

    public List<Word> getBody() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Doc) {
            Doc doc = (Doc) o;
            if (doc.getTitle().equals(this.getTitle()) && doc.getBody().equals(this.getBody())) {
                return true;
            }
        }
        return false;
    }
}

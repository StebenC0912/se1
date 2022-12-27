package a1_2001040121;

import java.util.ArrayList;
import java.util.List;

public class Doc {
    private String content;
    private List<Word> title;
    private List<Word> body;

    public Doc(String content) {
        this.content = content;
        this.title = new ArrayList<>();
        this.body = new ArrayList<>();
        String[] lines = content.split("\\n");
        String titleString = lines[0];
        for (String wordString : titleString.split("\\s+")) {
            Word word = Word.createWord(wordString);
            title.add(word);
        }
        String bodyString = lines[1];
        for (String wordString : bodyString.split("\\s+")) {
            Word word = Word.createWord(wordString);
            body.add(word);
        }
    }

    public List<Word> getTitle() {
        return title;
    }


    public List<Word> getBody() {
        return body;
    }


    public String getContent() {
        return content;
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

package a1_2001040121;

import java.util.ArrayList;
import java.util.List;

public class Doc {
    private String content;
    private List<Word> title;
    private List<Word> body;

    public Doc(String content) {
        String[] lines = content.split("\\n");
        String titleString = lines[0];
        List<Word> title = new ArrayList<>();
        List<Word> body = new ArrayList<>();
        for (String wordString : titleString.split("\\s+")) {
            Word word = Word.createWord(wordString);
            title.add(word);
        }
        String bodyString = lines[1];
        for (String wordString : bodyString.split("\\s+")) {
            Word word = Word.createWord(wordString);
            body.add(word);
        }
        this.content = content;
        this.title = title;
        this.body = body;
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

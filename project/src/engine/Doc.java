package engine;

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
        String[] lines = content.split("\\r?\\n");
        for (String line : lines) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (line.equals(lines[0])) {
                    title.add(Word.createWord(word));
                } else {
                    body.add(Word.createWord(word));
                }
            }
        }
    }

    public List<Word> getTitle() {
        return title;
    }

    public void setTitle(List<Word> title) {
        this.title = title;
    }

    public List<Word> getBody() {
        return body;
    }

    public void setBody(List<Word> body) {
        this.body = body;
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

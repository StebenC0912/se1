package engine;

import java.util.ArrayList;
import java.util.List;

public class Doc {
    private String content;
    private List<Word> title;
    private List<Word> body;
    public Doc(String content) {
        this.content = content;
    }

    public List<Word> getTitle() {
        List<Word> title = new ArrayList<>();

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
}

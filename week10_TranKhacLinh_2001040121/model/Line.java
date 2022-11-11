package week10_TranKhacLinh_2001040121.model;

import java.util.List;

public class Line {
    private List<String> words;

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public Line(List<String> words) {
        this.words = words;
    }

}

package engine;

import java.util.List;

public class Result {
    private Doc d;
    private List<Match> matches;

    public Result(Doc d, List<Match> matches) {
        this.d = d;
        this.matches = matches;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public int getTotalFrequency() {
        int totalFrequency = 0;
        for (Match match : matches) {
            totalFrequency += match.getFreq();
        }
        return totalFrequency;
    }

    public double getAverageFirstIndex() {
        double totalFirstIndex = 0;
        for (Match match : matches) {
            totalFirstIndex += match.getFirstIndex();
        }
        return totalFirstIndex / matches.size();
    }
    //Highlight the matched words in the document using HTML markups. For a
    //matched word in the document’s title, put the tag <u> and </u> around the
    //word’s text part (the <u> tag should not affect the word’s prefix and suffix). For a
    //matched word in the document’s body, surround the word’s text part with the tag
    //<b> and </b>
    public String htmlHighlight() {
        String[] lines = d.getContent().split("\\r?\\n");
        String highlightedContent = "";
        for (String line : lines) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (line.equals(lines[0])) {
                    for (Match match : matches) {
                        if (match.getWord().getText().equals(word)) {
                            highlightedContent += "<u>" + word + "</u>";
                        } else {
                            highlightedContent += word;
                        }
                    }
                } else {
                    for (Match match : matches) {
                        if (match.getWord().getText().equals(word)) {
                            highlightedContent += "<b>" + word + "</b>";
                        } else {
                            highlightedContent += word;
                        }
                    }
                }
            }
        }
        return highlightedContent;
    }

    //These are criteria to determine if Result A is greater than Result B
    //(in descending order of priority):
    //A has greater match count than B
    //A has greater total frequency than B
    //A has lower average first index than B
    public int compareTo(Result o) {
        if (this.getMatches().size() > o.getMatches().size()) {
            return 1;
        } else if (this.getMatches().size() < o.getMatches().size()) {
            return -1;
        } else if (this.getTotalFrequency() > o.getTotalFrequency()) {
            return 1;
        } else if (this.getTotalFrequency() < o.getTotalFrequency()) {
            return -1;
        } else if (this.getAverageFirstIndex() < o.getAverageFirstIndex()) {
            return 1;
        } else if (this.getAverageFirstIndex() > o.getAverageFirstIndex()) {
            return -1;
        } else {
            return 0;
        }
    }

    public Doc getDoc() {
        return d;
    }
}




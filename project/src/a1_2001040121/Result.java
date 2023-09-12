package a1_2001040121;

import java.util.List;

public class Result implements Comparable<Result> {
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

    /**
     * Highlight the matched words in the document using HTML markups. For a matched
     * word in the document’s title, put the tag <u> and </u> around the word’s text
     * part (the <u> tag should not affect the word’s prefix and suffix). For a
     * matched word in the document’s body, surround the word’s text part with the
     * tag <b> and </b>
     * 
     * @return the highlighted document
     */
    public String htmlHighlight() {
        StringBuilder sb = new StringBuilder();
        // html for title
        sb.append("<h3>");
        for (Word wordInTitle : d.getTitle()) {
            boolean isKeyWord = false;
            for (Match match : matches) {
                if (match.getWord().getText().toLowerCase().compareTo(wordInTitle.getText().toLowerCase()) == 0) {
                    isKeyWord = true;
                    break;
                }
            }
            if (isKeyWord) {
                sb.append(wordInTitle.getPrefix() + "<u>" + wordInTitle.getText() + "</u>" + wordInTitle.getSuffix());
            } else {
                sb.append(wordInTitle);
            }
            sb.append(" ");
        }
        sb.delete(sb.toString().length() - 1, sb.toString().length());
        sb.append("</h3>");
        sb.append("<p>");
        for (Word wordInBody : d.getBody()) {
            boolean isKeyWord = false;
            for (Match match : matches) {
                if (match.getWord().getText().toLowerCase().compareTo(wordInBody.getText().toLowerCase()) == 0) {
                    isKeyWord = true;
                }
            }
            if (isKeyWord)
                sb.append(wordInBody.getPrefix() + "<b>" + wordInBody.getText() + "</b>" + wordInBody.getSuffix());
            else
                sb.append(wordInBody);
            sb.append(" ");
        }
        sb.delete(sb.toString().length() - 1, sb.toString().length());
        sb.append("</p>");
        return sb.toString();
    }

    /**
     * Compares this Result object with the specified Result object for order.
     * 
     * @param o the Result object to be compared with
     * @return 1 if this is greater than o, -1 if this is less than o, 0 if this is
     */
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

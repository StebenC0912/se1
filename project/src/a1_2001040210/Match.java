package a1_2001040210;

public class Match implements Comparable<Match> {
    private Doc d;
    private Word w;
    private int freq;
    private int firstIndex;

    public Match(Doc d, Word w, int freq, int firstIndex) {
        this.d = d;
        this.w = w;
        this.freq = freq;
        this.firstIndex = firstIndex;
    }

    public int getFreq() {
        return freq;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public Word getWord() {
        return w;
    }

    /**
     * Compares this Match object with the specified Match object for order.
     * 
     * @param o the Match object to be compared with
     * 
     * @return 1 if this is greater than o, -1 if this is less than o, 0 if this is
     * equal to o
     */
    public int compareTo(Match o) {
        if (this.getFirstIndex() > o.getFirstIndex()) {
            return 1;
        } else if (this.getFirstIndex() < o.getFirstIndex()) {
            return -1;
        } else {
            return 0;
        }
    }
}

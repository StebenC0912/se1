package week10_TranKhacLinh_2001040121.model;

import java.util.List;

public class Document {
    private String doc;
    private List<Line> lines;
    public Document(String doc){
        this.doc = doc;
    }
    public String getDoc(){
        return doc;
    }
    public List<Line> getLines(){
        return lines;
    }
    public void setLines(List<Line> lines){
        this.lines = lines;
    }
    public void setDoc(String doc){
        this.doc = doc;
    }
}

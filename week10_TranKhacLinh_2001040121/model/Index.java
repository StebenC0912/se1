package week10_TranKhacLinh_2001040121.model;

import java.util.List;
import java.util.Map;

public class Index {
    private String document;
    private Map<String, List<Integer>> entries;
    
    public Index(String document, Map<String, List<Integer>> entries){
        this.document = document;
        this.entries = entries;
    }
}

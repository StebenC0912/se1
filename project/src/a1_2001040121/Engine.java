package a1_2001040121;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Engine {
    private Doc[] docs;
    private String dirname;

    // Loads the documents from the folder specified by dirname (which resides under
    //the project’s root folder) and returns the number of documents loaded. Refer to
    //the Doc class for more information about a Doc object.
    public int loadDocs(String dirname) {
        File folder = new File(dirname);
        File[] listOfFiles = folder.listFiles();
        int count = 0;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                count++;
            }
        }
        // load content of files into docs
        docs = new Doc[count];
        int i = 0;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                try {
                    FileReader fileReader = new FileReader(file);
                    StringBuilder sb = new StringBuilder();
                    int c;
                    while ((c = fileReader.read()) != -1) {
                        sb.append((char) c);
                    }
                    docs[i] = new Doc(sb.toString());
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return count;
    }

    public Doc[] getDocs() {
        return docs;
    }

    // Performs the search function of the engine. Returns a list of sorted search
    // results. Refer to the classes above to know the expected search results.
    public List<Result> search(Query q) {
        List<Result> results = new ArrayList<>();
        for (Doc d : docs) {
            List<Match> matches = q.matchAgainst(d);
            if (matches.size() > 0) {
                results.add(new Result(d, matches));
            }
        }
        Collections.sort(results);
        Collections.reverse(results);
        return results;
    }

    // Converts a list of search results into HTML format. The output of this method is
    // the output of Result.htmlHighlight() combined together (without any
    // delimiter). Refer to the 3rd line of the file testCases.html for a specific example.
    public String htmlResult(List<Result> results) {
        StringBuilder sb = new StringBuilder();
        for (Result result : results) {
            sb.append(result.htmlHighlight());
        }
        return sb.toString();
    }
}

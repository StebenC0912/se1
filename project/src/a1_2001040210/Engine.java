package a1_2001040210;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Engine {
    private Doc[] docs;
    /**
     * Loads the documents from the specified directory into the system.
     * 
     * @param dirname the name of the directory containing the documents
     * @return the number of documents loaded into the system
     */
    public int loadDocs(String dirname) {
        File folder = new File(dirname);
        File[] listOfFiles = folder.listFiles();
        int count = 0;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                count++;
            }
        }
        docs = new Doc[count];
        int i = 0;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                try (FileReader fileReader = new FileReader(file)) {
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

    /**
     * Performs the search function of the engine.
     * 
     * @param q the query to be searched
     * @return a list of sorted search results
     */
    public List<Result> search(Query q) {
        List<Result> results = new ArrayList<>();
        for (Doc d : docs) {
            List<Match> matches = q.matchAgainst(d);
            if (!matches.isEmpty()) {
                results.add(new Result(d, matches));
            }
        }
        Collections.sort(results);
        Collections.reverse(results);
        return results;
    }

    /**
     * Converts a list of search results into HTML format.
     * 
     * @param results the list of search results
     * @return the HTML representation of the search results
     */
    public String htmlResult(List<Result> results) {
        StringBuilder sb = new StringBuilder();
        for (Result result : results) {
            sb.append(result.htmlHighlight());
        }
        return sb.toString();
    }
}

package week3_TranKhacLinh_2001040121;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CompressFile{
    public void Remove(){

    }
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        try (
            BufferedReader input = new BufferedReader(new FileReader(inputFile));
            FileWriter writer = new FileWriter(outputFile);
        ){
            String line = input.readLine();
            
            while (line != null) {
                String lineWithoutSpace = line.replaceAll("\\s+", "");
                writer.write(lineWithoutSpace + "\n");
                line= input.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

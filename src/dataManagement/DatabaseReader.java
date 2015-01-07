package dataManagement;

import java.io.*;

/**
 * Created by Evan on 07/01/2015.
 */
public class DatabaseReader {

    public File BMData = new File("res/BM Data.txt");

    public void FileReader() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(BMData));
        String line = null;
        try {
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } {

        }
    }
}

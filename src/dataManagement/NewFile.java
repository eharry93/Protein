package dataManagement;

import ui.MainWindow;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Evan on 01/01/2015.
 */
public class NewFile {

    File saveFile;
    Writer writer;

    public void CreateFile(File saveFile) throws IOException {
        this.saveFile = saveFile;
        writer = new FileWriter(saveFile);

        for (String s : MainWindow.ModelNameList) {
            System.out.println(s);
        }
    }
}

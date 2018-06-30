package Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextIO {

    public TextIO() {
    }

    public static ArrayList<String> read(File file) throws IOException {
        BufferedReader reader = null;
        ArrayList list = new ArrayList();

        try {
            reader = new BufferedReader(new FileReader(file));

            String line;
            while((line = reader.readLine()) != null) {
                if(line.startsWith("#")) { continue;}
                else if (line.startsWith("Text:")) {
                    String[] split = line.split(":");
                    System.out.println(split[1]);
                }
                else if (line.startsWith("~")) { System.out.println("\n"); }
                else { list.add(line); }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }

        }

        return list;
    }
}

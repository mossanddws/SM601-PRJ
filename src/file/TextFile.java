package file;

import java.io.*;

public class TextFile {
    File file;

    public TextFile(String path) {
        this.file = new File(path);
    }

    public File getFile() {
        return file;
    }

    public String[][] read() {
        try {
            FileReader fileReader = new FileReader(getFile());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string = bufferedReader.readLine();
            if (string != null) {
                int numVertex = Integer.parseInt(string);
                String[][] strings = new String[numVertex * numVertex + 1][3];
                strings[0][0] = string;
                for (int i = 1; (string = bufferedReader.readLine()) != null; ++i) {
                    strings[i] = string.split(" ");
                }
                return strings;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Writer {
    private static String path = System.getProperty("user.home") + "/Desktop/";

    private static File f = new File(path + "file.txt");

    private static PrintWriter out;

    public void write(String s) {
        try {
            out = new PrintWriter(f);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(s);
        out.println(s);
        out.flush(); // TODO napraw
        out.close();
    }
}

package learn_file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yuan on 2017/3/19.
 */
public class testFileWrite {

    public static void main(String[] args) throws IOException {

        FileWriter f = new FileWriter("output.txt");
        f.write("123\n");
        f.write("666\n");
        f.write("123\n");
        f.write("000\n");
        f.write("正\n");
        f.close();

        PrintWriter p = new PrintWriter("output2.txt");
        p.println("123");
        p.println("正");
        p.close();
    }
}

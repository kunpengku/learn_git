package learn_file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by yuan on 2017/3/19.
 */
public class testFileRead {

    public static void main(String[] args) {

        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            String path = "C:\\\\fupeng\\\\书\\\\书\\\\Java 核心技术 基础知识.txt";
            inputStream = new FileInputStream(path);
            sc = new Scanner(inputStream, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(sc.hasNext()) {
            String line = sc.nextLine();
            System.out.println(line);
        }

    }
}

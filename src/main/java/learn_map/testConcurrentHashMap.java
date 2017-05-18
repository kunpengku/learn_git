package learn_map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fupeng on 2017/5/4.
 */
public class testConcurrentHashMap {
    public static void main(String[] args) {
        System.out.println("concurrentHashMap");

        ConcurrentHashMap con = new ConcurrentHashMap();


        con.put("abc","abc");

        System.out.println(con.get("abc"));
    }
}

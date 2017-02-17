package learn_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuan on 2017/2/17.
 */
public class testLinkedList {
    public static void main(String[] args) {
        List<Integer> log = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            log.add(i);
        }

        for (Integer i :
                log) {
            System.out.println(i);
        }
        System.out.println(log.getClass());
    }
}

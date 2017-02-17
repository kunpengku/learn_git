package learn_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yuan on 2017/2/17.
 */
public class testArrayList {
    public static void main(String[] args) {
        List<Integer> log = new ArrayList<Integer>();
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

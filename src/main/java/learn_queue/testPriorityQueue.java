package learn_queue;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Created by yuan on 2017/2/17.
 */
public class testPriorityQueue {
    public static void main(String[] args) {
        Queue<Integer> aa =  new PriorityQueue<Integer>();
        for (int i = 0; i < 8; i++) {
            Random a = new Random();
            aa.add(a.nextInt(99));
        }

        for (Integer t:
             aa) {
            System.out.println(t);
        }
        System.out.println("after math");
        //它保证 每次 堆顶的元素是 最小的。
        for (int i = 0; i < 8; i++) {
            Random a = new Random();
            System.out.println(aa.poll());
        }

    }
}


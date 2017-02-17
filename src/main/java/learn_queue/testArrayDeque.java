package learn_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

/**
 * Created by yuan on 2017/2/17.
 */

//队列的本质 先进先出
public class testArrayDeque {
    public static void main(String[] args) {
        Deque<Integer> aa = new ArrayDeque<Integer>();
        for (int i = 0; i < 8; i++) {
            Integer num = new Random().nextInt(100);
            System.out.println(num);
            aa.add(num);
        }
        System.out.println("after");
        while(!aa.isEmpty()){
            System.out.println(aa.poll());
        }
    }

}

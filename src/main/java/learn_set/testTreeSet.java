package learn_set;

import java.util.*;

/**
 * Created by yuan on 2017/2/16.
 */

//TreeSet 根据某种规则，对元素进行排序。

public class testTreeSet {
    public static void main(String[] args) {
        Set<Integer> mSet = new TreeSet<Integer>();

        for (int i = 0; i < 10; i++) {
            Random num = new Random();
            mSet.add(num.nextInt(100));
        }

        Iterator<Integer> SetItetaor = mSet.iterator();
        while(SetItetaor.hasNext()){
            System.out.println(SetItetaor.next());
        }

    }
}

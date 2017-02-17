package learn_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yuan on 2017/2/16.
 */

//HashSet  不能保证遍历 出的顺序和 插入顺序一样。

public class testHashSet {
    public static void main(String[] args) {
        Set<Integer> mSet = new HashSet<Integer>();

        for (int i = 90; i < 100; i++) {
            mSet.add(i);
        }
        for (int i = 0; i < 10; i++) {
            mSet.add(i);
        }

        Iterator<Integer> SetItetaor = mSet.iterator();
        while(SetItetaor.hasNext()){
            System.out.println(SetItetaor.next());
        }

    }
}

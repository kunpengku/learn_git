package learn_set;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by yuan on 2017/2/16.
 */

//LinkedHashSet  能保证遍历 出的顺序和 插入顺序是一样的。
// LinkedHashSet 是 HashSet的子类， 它为什么就能保证 插入顺序呢？

public class testLinkedHashSet {
    public static void main(String[] args) {
        Set<Integer> mLinkedSet = new LinkedHashSet<Integer>();

        for (int i = 90; i < 100; i++) {
            mLinkedSet.add(i);
        }
        for (int i = 0; i < 10; i++) {
            mLinkedSet.add(i);
        }


        Iterator<Integer> linkSetItetaor = mLinkedSet.iterator();
        while(linkSetItetaor.hasNext()){
            System.out.println(linkSetItetaor.next());
        }

    }
}

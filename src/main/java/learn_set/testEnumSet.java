package learn_set;

import java.util.*;

/**
 * Created by yuan on 2017/2/16.
 */

//EnumSet 根据某种规则，对元素进行排序。

public class testEnumSet {
    public static void main(String[] args) {
        Set<MyEnum> mSet = EnumSet.noneOf(MyEnum.class);


        mSet.add(MyEnum.BLUR);
        mSet.add(MyEnum.BLACK);


        Iterator<MyEnum> SetItetaor = mSet.iterator();
        while(SetItetaor.hasNext()){
            System.out.println(SetItetaor.next());
        }

    }
}

enum MyEnum {
    BLACK, WHITE, RED, BLUR, GREEN, YELLOW
}

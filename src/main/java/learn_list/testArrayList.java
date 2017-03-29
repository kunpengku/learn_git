package learn_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuan on 2017/2/17.
 */
public class testArrayList {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        List<Integer> log = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            log.add(i);
        }

        for (Integer i :
                log) {
            System.out.println(i);
        }
        System.out.println(log.getClass());

        ArrayList a = new ArrayList();
        a.add(1);
        a.add(3);
        a.add(1);
        for(Object i:a){
            int j = (Integer)i;
            System.out.println(j);
        }

        Object [] b = new Object[3];
        a.toArray(b);

        System.out.println(Arrays.toString(b));

        max_a(1,2,3);
        testArrayList seta = testArrayList.class.newInstance();

}

    private static void max_a(int... ia) {
        System.out.println(Arrays.toString(ia));
    }
}

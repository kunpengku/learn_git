package learn_map;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by yuan on 2017/2/17.
 */
public class testTreeMap {
    public static void main(String[] args) {
        SortedMap<String, String> aa = new TreeMap<String, String>();
        String k1 = "3";
        String k2 = "2";
        String k3 = "1";

        aa.put(k1, "k1_value");
        aa.put(k2, "k2_value");
        aa.put(k3, "k3_value");

        //put和get的效率将越来越低，这里的时间复杂度是O(n)，假如有1000个元素，put时需要比较1000次。
        //哈希是通过hash单词音译过来的，也可以称为散列表
        //equals方法就是哈希码碰撞时才会执行的方法

        Iterator iter = aa.entrySet().iterator();
        //可以看到，并没有按照 插入的顺序输出，那是 LinkedHashMap的特性
        while(iter.hasNext()){
            Map.Entry en = (Map.Entry) iter.next();
            System.out.println(en.getKey() + ":" + en.getValue() );
        }
    }
}

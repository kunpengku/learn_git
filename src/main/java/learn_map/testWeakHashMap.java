package learn_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by yuan on 2017/2/17.
 */
public class testWeakHashMap {
    public static void main(String[] args) {
        String k1 = new String("jan");
        String k2 = "May";
        String k3 = "Otc";

//        WeakHashMap，此种Map的特点是，当除了自身有对key的引用外，此key没有其他引用,那么此map会自动丢弃此值
        WeakHashMap<String ,String> aa = new WeakHashMap<String, String>();
        HashMap<String ,String> bb = new HashMap<String, String>();

        bb.put(k1,"k1_value");
        aa.put(k1, "k1_value");
        aa.put(k2, "k2_value");
        aa.put(k3, "k3_value");

        bb.remove(k1);
        k1=null;

        System.gc();



        Iterator iter = aa.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry en = (Map.Entry) iter.next();
            System.out.println(en.getKey() + ":" + en.getValue() );
        }
    }
}

package learn_map;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by yuan on 2017/2/17.
 */

enum Operate{
    ADD, UPDATE, DELETE;
}

public class testEnumMap {
    public static void main(String[] args) {
        EnumMap<Operate, String> aa = new EnumMap<Operate, String>(Operate.class);


        aa.put(Operate.ADD, "k1_value");
        aa.put(Operate.DELETE, "k2_value");
        aa.put(Operate.UPDATE, "k3_value");


        Iterator iter = aa.entrySet().iterator();
        //可以看到，并没有按照 插入的顺序输出，那是 LinkedHashMap的特性
        while(iter.hasNext()){
            Map.Entry en = (Map.Entry) iter.next();
            System.out.println(en.getKey() + ":" + en.getValue() );
        }
    }
}

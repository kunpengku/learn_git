package learn_singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuan on 2017/4/4.
 */
//登记式
public class Singleton3{
    private static Map<String, Singleton3> map = new HashMap<String, Singleton3>();
    static {
        Singleton3  single = new Singleton3();
        map.put(single.getClass().getName(), single);
    }
    protected Singleton3(){}

    public static Singleton3 getInstance(String name){
        if(name == null){
            name = Singleton3.class.getName();
            System.out.println(name);
        }

        if(map.get(name) == null){
            try {
                map.put(name, (Singleton3) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }
}
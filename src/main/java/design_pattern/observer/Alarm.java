package design_pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by yuan on 2017/4/4.
 */
public class Alarm implements Observer {

    public void update(Observable o, Object arg) {
        int tmp = (Integer)arg;
        System.out.println("现在水温是： " + tmp);
        if(tmp>=100) {
            System.out.println("嘀嘀嘀。。。水已经烧开了");
        }

    }
}

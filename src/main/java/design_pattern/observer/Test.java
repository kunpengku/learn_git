package design_pattern.observer;

/**
 * Created by yuan on 2017/4/4.
 */
public class Test {
    public static void main(String[] args) {
        Heater h = new Heater();
        Alarm a = new Alarm();
        Display dis = new Display();
        h.addObserver(dis);
        dis.addObserver(a);

        h.boilWater();
    }
}

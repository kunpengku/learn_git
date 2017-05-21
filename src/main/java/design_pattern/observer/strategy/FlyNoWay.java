package design_pattern.observer.strategy;

/**
 * Created by fupeng on 2017/5/21.
 */
public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I can not fly");
    }
}

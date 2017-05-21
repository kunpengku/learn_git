package design_pattern.observer.strategy;

/**
 * Created by fupeng on 2017/5/21.
 */
public class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("I'm flying");
    }
}

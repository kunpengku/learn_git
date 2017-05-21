package design_pattern.observer.strategy;

/**
 * Created by fupeng on 2017/5/21.
 */


//策略模式
public class MiniDuck extends Duck {
    public MiniDuck(){
        flyBehavior = new FlyWithWings();
    }

    public static void main(String[] args) {
        Duck d = new MiniDuck();
        d.performFly();

        Duck d2 = new ModelDuck();

        d2.performFly();
        d2.setFlyBehavior(new FlyWithWings());
        d2.performFly();
    }
}

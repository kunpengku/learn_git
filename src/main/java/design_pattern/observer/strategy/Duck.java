package design_pattern.observer.strategy;

/**
 * Created by fupeng on 2017/5/21.
 */
public abstract class Duck {
    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    FlyBehavior flyBehavior;
    public Duck(){

    }

    public void performFly(){
        flyBehavior.fly();
    }
}

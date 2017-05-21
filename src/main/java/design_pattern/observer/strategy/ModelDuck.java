package design_pattern.observer.strategy;

/**
 * Created by fupeng on 2017/5/21.
 */
public class ModelDuck extends Duck {

    public ModelDuck(){
        flyBehavior = new FlyNoWay();
    }
}

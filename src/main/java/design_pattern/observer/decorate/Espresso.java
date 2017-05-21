package design_pattern.observer.decorate;

/**
 * Created by fupeng on 2017/5/21.
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    public double cost() {
        return 1.99;
    }
}

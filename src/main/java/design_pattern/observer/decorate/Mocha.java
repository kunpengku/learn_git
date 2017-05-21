package design_pattern.observer.decorate;

/**
 * Created by fupeng on 2017/5/21.
 */
public class Mocha extends Condiment {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return  beverage.description + "Mocha";
    }

    public double cost() {
        return  beverage.cost() + 0.2;

    }
}

package design_pattern.observer.decorate;

/**
 * Created by fupeng on 2017/5/21.
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    public double cost() {
        return 0.89;
    }


}

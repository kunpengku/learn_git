package design_pattern.observer.decorate;

/**
 * Created by fupeng on 2017/5/21.
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription(){
        return description;
    }
    public abstract double cost();
}

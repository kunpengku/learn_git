package design_pattern.observer.decorate;

/**
 * Created by fupeng on 2017/5/21.
 */
public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage es_mocha = new Mocha(beverage);

        System.out.println(es_mocha.getDescription() + "$ " + es_mocha.cost());
    }
}

package design_pattern.observer.Observer;

/**
 * Created by fupeng on 2017/5/21.
 */
public class CurrrentDisplay implements Observer,DisplayElement {
    private float temp;
    private Subject weather;

    public CurrrentDisplay(Subject weatherData){
        this.weather = weatherData;
        weatherData.registerObserber(this);
    }

    public void update(float temp) {
        this.temp = temp;
    }



    public void display() {
        System.out.println("Current condition temp=" + temp);
    }
}

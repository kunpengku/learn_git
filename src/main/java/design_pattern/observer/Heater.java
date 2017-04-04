package design_pattern.observer;

import java.util.Observable;

/**
 * Created by yuan on 2017/4/4.
 */
public class Heater extends Observable {
    private  int temperature;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void boilWater() {

        for (int i = 90; i < 110; i++) {

            temperature = i;

            this.setChanged();
            this.notifyObservers();

        }

    }


}

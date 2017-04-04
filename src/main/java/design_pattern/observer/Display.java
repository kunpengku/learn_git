package design_pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by yuan on 2017/4/4.
 */
public class Display extends Observable implements Observer {
    private String state = "未开";
    public void update(Observable o, Object arg) {
        int temperature = ((Heater) o).getTemperature();
        if (temperature > 100) {

            this.setState("沸腾");

            this.setChanged();

            this.notifyObservers(temperature);

        }
        System.out.println("状态： " +  state + "  现在温度： " + temperature);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

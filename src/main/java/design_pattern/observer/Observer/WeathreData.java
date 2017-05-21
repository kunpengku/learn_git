package design_pattern.observer.Observer;

import java.util.ArrayList;

/**
 * Created by fupeng on 2017/5/21.
 */
public class WeathreData implements Subject {

    private ArrayList observers;
    private  float temp;

    public WeathreData(){
        observers = new ArrayList();
    }
    public void registerObserber(Observer o) {
        this.observers.add(o);
    }

    public void removeObserber(Observer o) {
        int i = observers.indexOf(o);
        if(i>0){
            observers.remove(i);
        }
    }

    public void notifyObserber() {
        for (int i=0;i<observers.size();i++
             ) {

            Observer observer = (Observer) observers.get(i);
            observer.update(temp);
        }
    }
}

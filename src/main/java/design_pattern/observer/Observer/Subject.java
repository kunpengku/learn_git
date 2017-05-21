package design_pattern.observer.Observer;

/**
 * Created by fupeng on 2017/5/21.
 */
public interface Subject {
    public void registerObserber(Observer observero);
    public void removeObserber(Observer observer);
    public void notifyObserber();

}


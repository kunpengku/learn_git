package design_pattern.observer.Singleton;

/**
 * Created by fupeng on 2017/5/21.
 */
public class MyClass_e {
    private final static MyClass_e singleton = new MyClass_e();

    private MyClass_e(){}

    public static MyClass_e getInstance(){
        return singleton;
    }
}

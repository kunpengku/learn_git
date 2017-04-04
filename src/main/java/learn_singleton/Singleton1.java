package learn_singleton;

/**
 * Created by yuan on 2017/4/4.
 */

//懒汉式
public class Singleton1{
    private static Singleton1 single = null;

    private Singleton1(){}

    public synchronized static Singleton1 getInstance(){
        if(single == null){
            single = new Singleton1();
        }

        return single;
    }
}
package learn_singleton;

/**
 * Created by yuan on 2017/4/4.
 */
//饿汉式单例
public class Singleton2{
    private static final Singleton2 single = new Singleton2();

    private Singleton2(){}

    public static Singleton2 getInstance(){
        return single;
    }
}

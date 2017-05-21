package design_pattern.observer.Singleton;

/**
 * Created by fupeng on 2017/5/21.
 */
public class MyClass {

    private volatile static MyClass singleton;

    private MyClass() {
    }

    //使用synchronized 可以管用，但这好像是一种累赘，只有第一次实例化时，会有这个风险，后面都不会有了， 但是 这个关键词
    //让后面 无谓的同步了许多次 ，值得改进。
    public static synchronized MyClass  getInstance(){
        if(singleton != null){
            singleton = new MyClass();
        }

        return singleton;

    }


    //  双重检查枷锁， 配合 volatile，可以 避免 每次都使用同步。
    public static MyClass getInstance_2(){
        if(singleton != null){
            synchronized (MyClass.class){
                if(singleton != null){
                    singleton = new MyClass();
                }
            }
        }

        return singleton;
    }


}

package learn_thread;

/**
 * Created by fupeng on 2017/4/7.
 */

class ppp extends Thread{
    public void run(){
        System.out.println("123");
    }
}



class P2 implements Runnable{
    public void run(){
        System.out.println("123");
    }
}

//创建线程的两种方法
public class TestThread1 {
    public static void main(String[] args) {
        ppp p = new ppp();
        p.start();

        Thread a = new Thread(new P2());
        a.start();

    }
}

package learn_thread;

/**
 * Created by yuan on 2017/3/29.
 */
// 实现线程的方法， 通过实现 Runnable接口的类
// 通过 继承 Thread的方法已经不推荐了
class printA implements Runnable{

    public void run() {

        for (int i = 0; i < 10 && !Thread.currentThread().isInterrupted(); i++) {
            System.out.println("AAA"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }


    }
}
public class Test_Interrupt {
    public static void main(String[] args) throws InterruptedException {
        printA a = new printA();
        Thread t = new Thread(a);
        t.start();
        Thread.sleep(4000);
        t.interrupt();
    }
}

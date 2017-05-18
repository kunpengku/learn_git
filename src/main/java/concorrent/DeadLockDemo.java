package concorrent;

/**
 * Created by fupeng on 2017/5/9.
 */
public class DeadLockDemo {

    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock() {
        Thread t1= new Thread(new Runnable() {
            public void run() {
                synchronized (A){
                        try {
                            Thread.currentThread().sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        synchronized (B){
                            System.out.println("1");
                        }

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                synchronized (B){

                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (A){
                        System.out.println("2");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}

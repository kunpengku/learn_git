package concorrent;

/**
 * Created by fupeng on 2017/5/10.
 */
public class Thread01 {
    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            public void run() {
                System.out.println("123");
            }
        });

//        t.setDaemon(true);
        t.start();

    }
}

package concorrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yuan on 2017/4/5.
 */

class Bak implements Runnable{

    public void run() {
        System.out.println("bak in lala");
    }
}
public class TestExecutorService1 {
    public static void main(String[] args) {
        ExecutorService s = Executors.newSingleThreadExecutor();
        Bak oob = new Bak();
        s.execute(oob);

        ExecutorService s2 = Executors.newFixedThreadPool(3);

        s2.submit(oob);



    }
}

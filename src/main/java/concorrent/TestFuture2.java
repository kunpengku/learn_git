package concorrent;

import java.util.concurrent.*;

/**
 * Created by fupeng on 2017/5/15.
 */


class Cal implements Callable{
    private int a;
    private int b;

    public Cal(int a, int b){
        this.a = a;
        this.b = b;
    }
    public Integer call() throws Exception {

        return a+b;
    }
}

public class TestFuture2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService exe = Executors.newFixedThreadPool(2);

        Future<Integer> ret = exe.submit(new Cal(1,1));
        Future<Integer> ret2 = exe.submit(new Cal(2,2));
        exe.shutdown();
        int all = ret.get() + ret2.get();
        System.out.println(all);
    }
}

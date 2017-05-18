package concorrent;

import java.util.concurrent.*;

/**
 * Created by yuan on 2017/4/5.
 */

class Task implements Callable<Integer>{

    public Integer call() throws Exception {
        System.out.println("cal");
        Thread.sleep(1000);
        int sum=0;
        for(int i=0;i<101;i++){
            sum+=i;
        }

        //
        return sum;
    }
}

public class TestFuture {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = exe.submit(task);

        exe.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("task ret:"+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("all done");
    }
}

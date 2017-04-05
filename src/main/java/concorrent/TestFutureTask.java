package concorrent;

import java.util.concurrent.*;

/**
 * Created by yuan on 2017/4/5.
 */
public class TestFutureTask {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newCachedThreadPool();

        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        exe.submit(futureTask);
        exe.shutdown();

        try {
            System.out.println("task 运行结果"+ futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}



class Task1 implements Callable<Integer> {

    public Integer call() throws Exception {
        System.out.println("cal");
        Thread.sleep(3000);
        int sum=0;
        for(int i=0;i<101;i++){
            sum+=i;
        }

        return sum;
    }
}
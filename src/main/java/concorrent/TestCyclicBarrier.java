package concorrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by fupeng on 2017/4/6.
 */
public class TestCyclicBarrier {

    private static final int THREAD_NUM = 5;

    public static class WorkThread implements Runnable{
        CyclicBarrier barrier;

        public WorkThread(CyclicBarrier b){
            this.barrier = b;
        }

        public void run() {
            try {
                System.out.println("ID:"+ Thread.currentThread().getId()+"is waiting");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("ID:"+ Thread.currentThread().getId()+"working");
        }
    }
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(5);

        for(int i=0;i<5;i++){
            new Thread(new WorkThread(cb)).start();
        }

    }
}

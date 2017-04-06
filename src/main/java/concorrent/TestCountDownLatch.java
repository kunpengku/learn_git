package concorrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by fupeng on 2017/4/6.
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        ExecutorService exe  = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(3);

        Student s1 = new Student(101,latch);
        Student s2 = new Student(102,latch);
        Student s3 = new Student(103,latch);

        Teacher t = new Teacher(latch);

        exe.submit(s1);
        exe.submit(s2);
        exe.submit(s3);
        exe.submit(t);

        exe.shutdown();
    }

}

class Teacher implements Runnable{
    private CountDownLatch cdlatch;
    Teacher(CountDownLatch latch){
        this.cdlatch = latch;
    }
    public void run() {
        System.out.println("teacher is waiting ---");
        try {
            cdlatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("now teacher can ---");

    }
}

class Student implements Runnable{

    private int num;
    private CountDownLatch cdlatch;

    Student(int num, CountDownLatch latch){
        this.num = num;
        this.cdlatch = latch;
    }

    private void Doexam(){
        System.out.println("Student " + num + "is doing exam");
    }
    public void run() {
        Doexam();

        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Student "+num+"is finished");
        cdlatch.countDown();
    }
}
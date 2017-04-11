package learn_thread;

/**
 * Created by fupeng on 2017/4/7.
 */
public class UncatchedException {

        public static void main(String[] args) throws Exception {
        Thread thread = new Thread1(Thread.currentThread().getThreadGroup(), "thread1");
        thread.start();
            Thread.currentThread().sleep(2000);
        Thread.UncaughtExceptionHandler ueh = thread.getUncaughtExceptionHandler();

        if (ueh != null)
            System.out.println("UncaughtExceptionHandler : " + ueh.toString());
        else
            System.out.println("UncaughtExceptionHandler is null");
    }

        private static final class Thread1 extends Thread {
            public Thread1(ThreadGroup group, String name) {
                super(group, name);
            }

            public void run() {
                System.out.println(">> Thread1 run begin ");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Ex: " + e.getMessage());
                }
                System.out.println(">> Thread1 run end ");
            }
        }
    }
class MyThread implements Runnable {
    private String threadName;

    MyThread(String name) {
        this.threadName = name;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " - Count: " + i);
            try {
                Thread.sleep(500); // Pause for 500ms
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted");
            }
        }
    }
}

public class MultiThreadExample {
    public static void main(String[] args) {
        // Create Runnable objects
        MyThread task1 = new MyThread("Thread-1");
        MyThread task2 = new MyThread("Thread-2");

        // Create Thread objects and start them
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        System.out.println("Main thread finished starting other threads.");
    }
}

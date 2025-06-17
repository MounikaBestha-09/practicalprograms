public class SingleThreadExample {
    public static void main(String[] args) {
        // Create a thread using an anonymous inner class
        Thread thread = new Thread() {
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Thread is running: " + i);
                    try {
                        Thread.sleep(500); // Sleep for 500ms
                    } catch (InterruptedException e) {
                        System.out.println("Thread interrupted");
                    }
                }
            }
        };

        // Start the thread
        thread.start();

        // Main thread work
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main thread: " + i);
            try {
                Thread.sleep(500); // Sleep for 500ms
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }
    }
}

package Day_4.Assignment_2;

/*
Benjamin Schroeder

One of the 2 threads used to create deadlock within the deadlock example inverse of DeadlockThread 2
 */
public class DeadlockThread1 implements Runnable {

    /**
     * Thread 1 immediately grabs lock 1 then waits 25 milliseconds then attempts to grab lock 2
     */
    @Override
    public void run() {
        DeadlockSingleton mySingleton = DeadlockSingleton.getInstance();

        System.out.println("Thread1: Getting lock 1.");

        synchronized (mySingleton.getLock1()) {
            System.out.println("Thread1: I got lock 1!");

            try {
                Thread.sleep(25);

                System.out.println("Thread1: Getting lock 2.");

                synchronized (mySingleton.getLock2()) {
                    System.out.println("Thread1: I got lock 2!");
                }

                System.out.println("Thread1: Released lock 2");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread1: Released lock 1");
    }
}

/*
Benjamin Schroeder

One of the 2 threads used to create deadlock within the deadlock example inverse of DeadlockThread 1
 */

public class DeadlockThread2 implements Runnable {

    /**
     * Thread 2 immediately grabs lock 2 then waits 25 milliseconds then attempts to grab lock 1
     */
    @Override
    public void run() {
        DeadlockSingleton mySingleton = DeadlockSingleton.getInstance();

        System.out.println("Thread2: Getting lock 2.");

        synchronized (mySingleton.getLock2()) {
            System.out.println("Thread2: I got lock 2!");

            try {
                Thread.sleep(25);

                System.out.println("Thread2: Getting lock 1.");

                synchronized (mySingleton.getLock1()) {
                    System.out.println("Thread2: I got lock 1!");
                }

                System.out.println("Thread2: Released lock 1");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread2: Released lock 2");
    }
}

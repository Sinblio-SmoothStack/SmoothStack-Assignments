/*
  Benjamin Schroeder

  The main class for my deadlock program, creates and runs an instance of thread 1 and thread 2
 */

import static java.lang.Thread.sleep;

public class DeadlockDemo {

    public static void main(String[] args)  {
        Thread t1 = new Thread(new DeadlockThread1());
        Thread t2 = new Thread(new DeadlockThread2());

        t1.start();
        t2.start();
    }
}

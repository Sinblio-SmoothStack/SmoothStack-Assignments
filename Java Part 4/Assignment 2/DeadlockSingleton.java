/*
Benjamin Schroeder

A singleton class made to hold the locks used within the deadlock example
 */
public class DeadlockSingleton {

    private static volatile DeadlockSingleton deadlockSingleton = null;
    private Object lock1;
    private Object lock2;

    /**
     * Default Constructor makes lock objects
     */
    private DeadlockSingleton(){
        lock1 = new Object();
        lock2 = new Object();
    }

    /**
     * a method to get lock 1
     *
     * @return the lock object lock 1
     */
    public Object getLock1() {
        return lock1;
    }

    /**
     * a method to get lock 2
     *
     * @return the lock object lock 2
     */
    public Object getLock2() {
        return lock2;
    }

    /**
     * A method to get the instance of the singleton. Uses double-checked locking for the thread safe initialization
     *
     * @return the instance of the singleton
     */
    public static DeadlockSingleton getInstance() {
        if (deadlockSingleton == null) {
            synchronized (MySingleton.class) {
                if (deadlockSingleton == null) {
                    deadlockSingleton = new DeadlockSingleton();
                }
            }
        }
        return deadlockSingleton;
    }
}
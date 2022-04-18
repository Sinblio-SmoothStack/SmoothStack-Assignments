/*
 * Ben Schroeder
 *
 * An example singleton class that uses double-checked locking for thread safe creation
 */

public class MySingleton {

    private static volatile MySingleton mySingleton = null;
    private String myData;

    /**
     * Singleton Constructor
     */
    private MySingleton(){
        myData = "Something Important";
    }

    /**
     * the getter for the example myDate field
     *
     * @return test data stored within my data
     */
    public String getMyData() {
        return myData;
    }

    /**
     * Uses double-checked locking to make a thread safe get instance for the singleton class
     *
     * @return the singleton instance
     */
    public static MySingleton getInstance() {
        if (mySingleton == null) {
            synchronized (MySingleton.class) {
                if (mySingleton == null) {
                    mySingleton = new MySingleton();
                }
            }
        }
        return mySingleton;
    }
}

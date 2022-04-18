package Demo_1;

import java.sql.Connection;


public class SampleSingleton {

    private static Connection conn = null;

    private static SampleSingleton instance = null;

    /**
     * Singleton class needs a private constructor to give instance a non null value
     */
    private SampleSingleton() {
        instance = this;
    }

    /**
     * Implemented a double system of double-checked locking to allow for thread safe first time initialization of the
     * singleton
     *
     * @return the instance of the singleton
     */
    public static SampleSingleton getInstance() {
        if (instance == null) {
            synchronized (SampleSingleton.class) {
                if (instance == null) {
                    instance = new SampleSingleton();
                }
            }
        }
        return instance;
    }

}

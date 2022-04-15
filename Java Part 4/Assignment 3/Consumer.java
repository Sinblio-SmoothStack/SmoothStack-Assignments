/*
Benjamin Schroeder

Consumer object consumes a set number of Integers removing them from the provided bound buffer
 */

public class Consumer implements Runnable{
    private int toConsume;
    private BoundedBuffer<Integer> myBuffer;

    /**
     * Constructor for Consumer
     *
     * @param myBuffer bound buffer to produce to
     * @param toConsume the number of Integers to consume
     */
    public Consumer(BoundedBuffer<Integer> myBuffer, int toConsume) {
        this.toConsume = toConsume;
        this.myBuffer = myBuffer;
    }

    /**
     * Runs consumer thread
     */
    @Override
    public void run() {
        while (toConsume > 0) {
            Integer consumed = myBuffer.take();
            System.out.printf("Consumed %d\n", consumed);
            --toConsume;
        }
    }
}

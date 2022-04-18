/*
Benjamin Schroeder

Producer object produces a set number of Integers adding them to the provided bound buffer
 */

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable{
    private int toProduce;
    private BoundedBuffer<Integer> myBuffer;

    /**
     * Constructor for Producer
     *
     * @param myBuffer bound buffer to produce to
     * @param toProduce the number of Integers to produce
     */
    public Producer (BoundedBuffer<Integer> myBuffer, int toProduce) {
        this.myBuffer = myBuffer;
        this.toProduce = toProduce;
    }

    /**
     * Runs producer thread
     */
    @Override
    public void run() {
        while (toProduce > 0) {
            Integer toAdd = ThreadLocalRandom.current().nextInt(0, 1000);
            myBuffer.put(toAdd);
            System.out.printf("Added %d\n", toAdd);
            --toProduce;
        }
    }
}

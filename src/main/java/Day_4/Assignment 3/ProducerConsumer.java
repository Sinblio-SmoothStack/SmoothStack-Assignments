/*
Benjamin Schroeder

A program meant to test the Producer and Consumer objects
 */

public class ProducerConsumer {

    public static void main(String[] args) {
        BoundedBuffer<Integer> myBuffer = new BoundedBuffer<>(2);

        Thread p1 = new Thread(new Producer(myBuffer,10));
        Thread c1 = new Thread(new Consumer(myBuffer, 10));

        p1.start();
        c1.start();
    }
}

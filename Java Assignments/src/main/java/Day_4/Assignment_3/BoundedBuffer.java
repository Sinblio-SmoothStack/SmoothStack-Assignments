package Day_4.Assignment_3;/*
Benjamin Schroeder

An implementation of a bound buffer based off the one found at
https://github.com/manoj-smoothstack/java_training/blob/main/basic/src/com/smoothstack/threads/ProducerConsumer.java
Added/Modified documentation for personal usability
 */

class BoundedBuffer<T> {

    private final Object[] buffer;
    private int putpos, takepos, count;

    /**
     * Constructor for the BoundedBuffer
     *
     * @param bound the size of the buffer
     */
    public BoundedBuffer(int bound) {
        buffer = new Object[bound];
    }

    /**
     * This method blocks the input of objects while the buffer is full. Instead, waiting for there to be an empty spot
     * within the buffer
     *
     * @param object the object to enter into the buffer
     */
    public synchronized void put(T object) {
        try {
            while (isFull()) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doPut(object);
        notifyAll();
    }

    /**
     * This method will attempt to take an object from the buffer, if the buffer is full then the thread will sit and
     * wait for an object to be added to the buffer
     *
     * @return the object taken from the buffer
     */
    public synchronized T take() {
        try {
            while (isEmpty()) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        T element = doTake();
        notifyAll();
        return element;
    }

    /**
     * This method returns a boolean value based whether the buffer is full
     *
     * @return true if the buffer is full, false if there is space in the buffer
     */
    public synchronized boolean isFull() {
        return count == buffer.length;
    }

    /**
     * This method returns a boolean value based whether the buffer is empty
     *
     * @return true if the buffer is empty, false if there are objects in the buffer
     */
    public synchronized boolean isEmpty() {
        return count == 0;
    }

    /**
     * The method responsible for the actual addition of an object to the buffer
     *
     * @param object the object to add to the buffer
     */
    protected synchronized void doPut(T object) {
        buffer[putpos] = object;
        if (++putpos == buffer.length) {
            putpos = 0;
        }
        ++count;
    }

    /**
     * The method responsible for the actual taking of an object from the buffer
     *
     * @return the object taken from the buffer
     */
    protected synchronized T doTake() {
        T element = (T) buffer[takepos];
        if (++takepos == buffer.length) {
            takepos = 0;
        }
        --count;
        return element;
    }
}

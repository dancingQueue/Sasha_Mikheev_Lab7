package firsttask;

/**
 * Created by alexandermiheev on 24.05.16.
 */
public class IncrementingThread implements Runnable {
    private Counter counter;
    private int numOfIncrements;

    IncrementingThread(Counter counter, int numOfIncrements) {
        this.counter = counter;
        this.numOfIncrements = numOfIncrements;
    }

    public void run() {
        for (int i = 0; i < numOfIncrements; i++) {
            counter.increment();
        }
    }
}

package firsttask;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by alexandermiheev on 24.05.16.
 */
public class Counter {
    private final AtomicInteger value = new AtomicInteger(0);

    public void increment() {
        int temp = value.getAndIncrement();
    }

    public int getValue() {
        return value.intValue();
    }
}

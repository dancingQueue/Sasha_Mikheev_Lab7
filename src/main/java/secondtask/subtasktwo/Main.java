package secondtask.subtasktwo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by alexandermiheev on 02.06.16.
 */
public class Main {
    public static Philosopher[] philosophers;
    public static Lock[] forks;

    public static void initForks(int size) {
        forks = new Lock[size];
        for (int i = 0; i < size; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public static void initPhilosophers(int size) {
        philosophers = new Philosopher[size];

        for (int i = 0; i < size; i++) {
            philosophers[i] = new Philosopher(i + 1, forks[i], forks[(i + 4) % 5]);
        }
    }

    public static void startDinner(int size) {
        for (int i = 0; i < size; i++) {
            philosophers[i].start();
        }
    }

    public static void main(String[] args) {
        int size = 5;
        initForks(size);
        initPhilosophers(size);
        startDinner(size);

    }
}

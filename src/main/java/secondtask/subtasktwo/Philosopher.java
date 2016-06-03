package secondtask.subtasktwo;

import java.util.concurrent.locks.Lock;

/**
 * Created by alexandermiheev on 03.06.16.
 */
public class Philosopher extends Thread {
    private Lock leftFork;
    private Lock rightFork;

    private Integer id;

    public Philosopher(Integer id, Lock leftFork, Lock rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void eat() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.print(e.getMessage());
        }
        System.out.println("Philosopher " + id.toString() + " is eating");
    }
    private void think() {
        System.out.println("Philosopher " + id.toString() + " is thinking");
    }

    public void run() {
        while (true) {
            int hashLeftFork = leftFork.hashCode();
            int hashRightFork = rightFork.hashCode();


            Lock tempFirstFork = null;
            Lock tempSecondFork = null;

            if (hashLeftFork < hashRightFork) {
                tempFirstFork = leftFork;
                tempSecondFork = rightFork;
            } else {
                tempSecondFork = leftFork;
                tempFirstFork = rightFork;
            }

            tempFirstFork.lock();
            tempSecondFork.lock();
            eat();
            tempFirstFork.unlock();
            tempSecondFork.unlock();
            think();
        }
    }

}

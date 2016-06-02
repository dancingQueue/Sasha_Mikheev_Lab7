package secondtask.subtaskone;

/**
 * Created by alexandermiheev on 02.06.16.
 */
public class Philosopher extends Thread {
    private Fork leftFork;
    private Fork rightFork;

    private Integer id;

    public Philosopher(Integer id, Fork leftFork, Fork rightFork) {
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
            int hashFork1 = leftFork.hashCode();
            int hashFork2 = rightFork.hashCode();

            Fork tempFirstFork = null;
            Fork tempSecondFork = null;


            if (hashFork1 < hashFork2) {
                tempFirstFork = leftFork;
                tempSecondFork = rightFork;
            } else {
                tempSecondFork = leftFork;
                tempFirstFork = rightFork;
            }

            synchronized (tempFirstFork) {
                synchronized (tempSecondFork) {
                    eat();
                }
            }
            think();
        }
    }
}

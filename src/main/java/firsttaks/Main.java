package firsttaks;


/**
 * Created by alexandermiheev on 24.05.16.
 */
public class Main {
    public static void main(String[] args) {
        int amountOfThreads = 100;
        Thread[] threads = new Thread[amountOfThreads];
        Counter counter = new Counter();
        int numOfIncrements = 1000 * 1000;

        for (int i = 0; i < amountOfThreads; i++) {
            threads[i] = new Thread(new IncrementingThread(counter, numOfIncrements));
        }

        for (int i = 0; i < amountOfThreads; i++) {
            threads[i].start();
        }

        boolean areTreadsAlive = true;

        while (areTreadsAlive) {
            int numOfDeadThreads = 0;
            for (int i = 0; i < amountOfThreads; i++) {
                if (!threads[i].isAlive()) {
                    numOfDeadThreads += 1;
                }
            }

            if (numOfDeadThreads == amountOfThreads) {
                areTreadsAlive = false;
            }
        }

        for (int i = 0; i < amountOfThreads; i++) {
            if (threads[i].isAlive()) {
                System.out.println("Something went wrong");
            }
        }

        System.out.print("Current counter value is " + counter.getValue());
    }
}

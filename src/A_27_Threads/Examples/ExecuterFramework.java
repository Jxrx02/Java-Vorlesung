package A_27_Threads.Examples;

import java.nio.charset.MalformedInputException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterFramework extends Thread {

    static final int NTHREADS = 10;
    // ...
    static ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

    public void main(String[] args) {
        // ...
        for (int i = 0; i < 100; i++) { // 100 neue Threads
            Runnable worker = new MyRunnable(); // Thread erzeugen
            exec.execute(worker); // und zum Arbeiten anmelden
        }
        // ...
        // Hindere den Executor am Annehmen neuer Threads
        // und beende alle Threads in der Queue
        exec.shutdown();
        // ...
        // Warte bis alle Threads fertig sind…
        while (!exec.isTerminated()) {
        }
    }
    static class MyRunnable implements Runnable{

        @Override
        public void run() {

        }
    }


}

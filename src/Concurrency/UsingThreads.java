package Concurrency;

/**
 * Created by tkmab9v on 6/19/20.
 *
 *
 * Threads
 *
 * Java support for OS-threads.
 *
 * Thread is a basic unit that can run in parallel through CPU cores.
 *
 * A thread can 'see' others threads memory.
 *
 */

public class UsingThreads {
    public static void main(String[] args) throws InterruptedException {
        // Creating
        Thread created = new Thread();
        created.start();
        // .run() runs on main thread

        // Assigning a task for running on a thread - we pass a Runnable instance
        Thread threadWithTask = new Thread(() -> System.out.println("Inside thread" + Thread.currentThread().getName()));
        threadWithTask.start();

        // Interrupting a thread
        Runnable interrupatblyTask = new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Im not interrupted " + Thread.currentThread().getName());
                }
            }
        };

        Thread interruptable1 = new Thread(interrupatblyTask);
        Thread interruptable2 = new Thread(interrupatblyTask);
        interruptable1.start();
        interruptable2.start();
        Thread.sleep(3000);
        interruptable1.interrupt();
        interruptable2.interrupt();

    }

}





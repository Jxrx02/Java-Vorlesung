package A_27_Threads.Excercises;

import java.util.LinkedList;


class MyBuffer {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private int maxSize = 4; // Maximum size of the buffer

    public synchronized void put(int v) {
        while (buffer.size() >= maxSize) {
            try {
                wait(); // Wait if the buffer is full
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        buffer.add(v);
        notify(); // Notify waiting consumers
        System.out.println("Put: " + v);
        System.out.println("Fill level after put: " + buffer.size());

    }

    public synchronized int get() {
        while (buffer.isEmpty()) {
            try {
                wait(); // Wait if the buffer is empty
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int v = buffer.remove();
        notify(); // Notify waiting producers
        System.out.println("Get: " + v);
        System.out.println("Fill level after put: " + buffer.size());
        return v;
    }
}


class test {
    public static void main(String args[]) {
        MyBuffer buf = new MyBuffer();

        ProducerThread thread1 = new ProducerThread(buf);
        thread1.start();
        ConsumerThread thread2 = new ConsumerThread(buf);
        thread2.start();
    }
}
class ProducerThread extends Thread {
    MyBuffer buf;
    public ProducerThread(MyBuffer b) {
        this.buf = b;
    }
    public void run() {
        this.buf.put(5);
        this.buf.put(6);
        this.buf.put(7);
        //try { Thread.sleep((int)(Math.random()*1000));} catch (InterruptedException e) {throw new RuntimeException(e);}
        this.buf.put(54);

    }
}
class ConsumerThread extends Thread {
    MyBuffer buffer;
    public ConsumerThread(MyBuffer b) {
        this.buffer = b;
    }
    public void run() {

        this.buffer.get();
        this.buffer.get();
        this.buffer.get();
        this.buffer.get();

        try { Thread.sleep((int)(Math.random()*1000));} catch (InterruptedException e) {throw new RuntimeException(e);}
    }
}
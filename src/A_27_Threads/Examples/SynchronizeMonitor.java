package A_27_Threads.Examples;

public class SynchronizeMonitor {


}

class Name {
    String firstname;
    String surname;
    public synchronized void setName(String fn, String sn) {
        this.firstname = fn;
        this.surname = sn;
    }
    public synchronized String getName() {
        return this.firstname + " " + this.surname;
    }


    //Oder

    //synchronized ( e ) {}

    //oder
    //AtomicInteger nutzen
}

//wait(): Thread geht in Zustand "wartend" über. Er gibt die Objekt-Sperre (Monitor) für andere Threads ab. Kann InterruptedException werfen.
//notify(): stößt einen anderen Thread wieder an, der ein wait() ausführt.
class MyBuffer {
    // buffer Variables
    private int value;
    private boolean empty = true;
    // the producer routine
    public synchronized void put(int v) {
        if (!this.empty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        // buffer is empty, fill it!
        this.value = v;
        this.empty = false;
        // notify waiting consumer
        this.notify();
        System.out.println("Put: " + v);
    }// the consumer routine
    public synchronized int get() {
        int v;
        if (this.empty) {
        // consumer must wait
        // until buffer is full
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        // buffer is full, empty it!
        v = this.value;
        this.empty = true;
        // notify waiting producer
        this.notify();
        System.out.println("Get:" + v);
        return v;
    }


    public static void main(String args[]) {
        MyBuffer buf = new MyBuffer();
        buf.put(5);
      //  buf.get();
        buf.put(6);
        buf.get();
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
    }
}
class ConsumerThread extends Thread {
    MyBuffer buffer;
    public ConsumerThread(MyBuffer b) {
        this.buffer = b;
    }
    public void run() {
        this.buffer.get();
    }
}
class BufferTest2 {
    public static void main(String args[]) {
        MyBuffer buf = new MyBuffer();
        ProducerThread thread1 = new ProducerThread(buf);
        thread1.start();
        ConsumerThread thread2 = new ConsumerThread(buf);
        thread2.start();
    }
}



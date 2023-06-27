package A_27_Threads.Examples;

public class FirstThread extends Thread {

    //Treads:
    //Parallele Ausführung von Anweisungen auf einem oder mehreren Prozessoren bzw. Prozessorkernen.
    //eigenen lokalen Speicherbereich

    //Prozess: ablauffähiges Programm


    /*  Threads - Klasse
    static Thread currentThread()
        Referenz zum gerade ausgeführten Thread-Objekt.
    ThreadGroup getThreadGroup()
        Liefert die ThreadGroup, zu der dieser Thread gehört.
    static boolean holdsLock(Object obj)
        Hält dieser Thread einen Monitor (s. Synchronisation) auf obj?
    void interrupt()
        Unterbricht diesen Thread.
    boolean isAlive()
    void join()
        Wartet auf das Beenden dieses Threads.
        Die Methode join() erlaubt es einem Thread, auf die
        Beendigung eines anderen Threads (t.join()) zu warten.
        Wenn also t ein (parallel laufendes) Thread-Objekt ist,
        sorgt dafür, dass der aktuelle Thread (der, in dessen
        Programmcode diese Zeile steht) so lange pausiert,
        bis t terminiert.
    void setDaemon(boolean on)
        Markiert diesen Thread als Daemon oder User-Thread.
    static void sleep(long millis)
        Legt diesen Thread für millis Millisekunden „zum Schlafen“
    void start()
        Startet die Ausführung dieses Threads. Ruft asynchron die Methode run() auf.
    void run()
        Wird von start() aufgerufen. Wird die Methode nicht überschrieben, dann tut der Thread nichts.
    static void yield()
        Lässt den gerade ausgeführten Thread (kurz) pausieren und gibt anderen Threads eine Chance zur Ausführung.*/


    // ThreadGroup - Klasse

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " ");
            try {
                Thread.sleep(100); // 100 Millisekunden warten
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("End of thread " + this.toString());
    }

    public static void main(String args[]) {
        FirstThread thread = new FirstThread();
        thread.start();
        System.out.println("End of main");
    }


}

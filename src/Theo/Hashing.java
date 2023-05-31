package Theo;

public class Hashing {


    /**
     * Implementieren Sie ein Hash-Verfahren und
     * messen Sie die Anzahl der Kollisionen beim
     * Zugriff auf die Hashtabelle.
     * a) bei 50% Füllstand
     * b) bei 90% Füllstand
     * c) bei 95% Füllstand
     * d) bei 100% Füllstand.
     *  mit Zahlen arbeiten. Zahlen zufällig erzeugen.
     *  mind. 100 Plätze und 100 Zugriffe.
     *  Gruppen möglich. Jeder macht mindestens ein Hash- Verfahren.
     *  Ergebnisse (Beschreibung, Tabelle, Programm) als
     * PDF auf dem Lernserver ablegen.
     */

    int filled50, filled90, filled95, filled100;

    public static void main(String[] args) {
        Hashing h = new Hashing();
    }

    public Hashing() {
        int avg50 = 0, avg90 = 0, avg95 = 0, avg100 = 0;
        int amountTests = 1000;
        for (int i = 0; i < amountTests; i++) {
            method();
            avg50 += filled50;
            avg90 += filled90;
            avg95 += filled95;
            avg100 += filled100;
        }
        avg50 /= amountTests;
        avg90 /= amountTests;
        avg95 /= amountTests;
        avg100 /= amountTests;
        System.out.println("On average at 50%: " + avg50);
        System.out.println("On average at 90%: " + avg90);
        System.out.println("On average at 95%: " + avg95);
        System.out.println("On average at 100%: " + avg100);
    }

    public int mod(int s, int p) {
        return (s % p);
    }


    public void method() {
        int arraySize = 100;
        int[] arrayMap = new int[arraySize];
        int rnd, hash, counterCollision = 0, counterFilled = 0;

        for (int i = 0; i < 100000000; i++) {
            if (counterFilled == arraySize * 0.5) {
                System.out.println("Filled 50%, collisions: " + counterCollision);
                filled50 = counterCollision;
            } else if (counterFilled == arraySize * 0.90) {
                System.out.println("Filled 90%, collisions: " + counterCollision);
                filled90 = counterCollision;
            } else if (counterFilled == arraySize * 0.95) {
                System.out.println("Filled 95%, collisions: " + counterCollision);
                filled95 = counterCollision;
            } else if (counterFilled == arraySize) {
                System.out.println("Filled 100%, collisions: " + counterCollision);
                filled100 = counterCollision;
                break;
            }

            rnd = (int) (Math.random() * 1000);
            hash = mod(rnd, arraySize);

            //collision
            if (arrayMap[hash] != 0) {
                counterCollision++;
            }
            //no collision
            else {
                arrayMap[hash] = rnd;
                counterFilled++;
            }
        }
    }
}
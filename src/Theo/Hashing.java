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
     */

    //Füllstände
    int filled50, filled90, filled95, filled100;

    public static void main(String[] args) {
        Hashing h = new Hashing();
    }

    public Hashing() {
        //durchschnittliche Füllstände
        int avg50 = 0, avg90 = 0, avg95 = 0, avg100 = 0;
        //Testdurchläufe
        int amountTests = 10000;
        for (int i = 0; i < amountTests; i++) {
            executeHash();
            avg50 += filled50;
            avg90 += filled90;
            avg95 += filled95;
            avg100 += filled100;
        }
        avg50 /= amountTests; avg90 /= amountTests;
        avg95 /= amountTests; avg100 /= amountTests;

        System.out.println("Durchschnittliche Kollision - Füllstand: 50%: " + avg50);
        System.out.println("Durchschnittliche Kollision - Füllstand: 90%: " + avg90);
        System.out.println("Durchschnittliche Kollision - Füllstand: 95%: " + avg95);
        System.out.println("Durchschnittliche Kollision - Füllstand: 100%: " + avg100);
    }

    public int mod(int s, int p) {
        //f(Schlüssel) = s mod P mit P = Größe des Speichers, S = Schlüssel
        return (s % p);
    }
    public int mult(int s, int p) {
        //f(Schlüssel) = s * irrationale Zahl;
        return (int) (s * Math.PI);
    }
     public static int anotherhash(String data) {
        int hashValue = 0;
        for (int i = 0; i < data.length(); i++) {
            hashValue += (int) data.charAt(i);  // Die ASCII-Werte der Zeichen addieren
        }
        return hashValue;
    }



    public void executeHash() {
        int arraySize = 100;
        int[] array = new int[arraySize];
        int rnd, hash_key, countCollision = 0, countFilled = 0;

        for (int i = 0; i < 100000000; i++) {
            if (countFilled == arraySize * 0.5) {
                System.out.println("Filled 50%, collisions: " + countCollision);
                filled50 = countCollision;
            } else if (countFilled == arraySize * 0.90) {
                System.out.println("Filled 90%, collisions: " + countCollision);
                filled90 = countCollision;
            } else if (countFilled == arraySize * 0.95) {
                System.out.println("Filled 95%, collisions: " + countCollision);
                filled95 = countCollision;
            } else if (countFilled == arraySize) {
                System.out.println("Filled 100%, collisions: " + countCollision);
                filled100 = countCollision;
                break;
            }

            rnd = (int) (Math.random() * 1000);
            hash_key = mod(rnd, arraySize);
            //hash_key = mult(rnd, arraySize); -> Speicher zu gering

            //Kollision
            if (array[hash_key] != 0) {
                countCollision++;
            }
            //keine Kollision -> fülle mit zufälliger Zahl
            else {
                array[hash_key] = rnd;
                countFilled++;
            }
        }
    }
}
package Theo;

import java.util.Random;

public class HashTable {
    private int size;
    private Integer[] table;
    private int collisions;

    public HashTable(int size) {
        this.size = size;
        this.table = new Integer[size];
        this.collisions = 0;
    }

    private int hashFunction(int key) {
        //f(Schlüssel) = s mod P mit P = Größe des Speichers, S = Schlüssel
        return key % size;
    }

    public void insert(int key) {
        int index = hashFunction(key);
        if (table[index] != null) {
            collisions++;
        }else{
            table[index] = key;
        }
    }

    public int getCollisions() {
        return collisions;
    }

    public static void main(String[] args) {
        int tableSize = 73939;
        int numTests = 10000;
        double fillpercantage = 0.5;

        for(int k=0;k<=3;k++) {

            if(k==0)
                fillpercantage = 0.5;
            else if (k==1) {
                fillpercantage = 0.90;
            }
            else if (k==2) {
                fillpercantage = 0.95;
            }
            else if (k==3) {
                fillpercantage = 1;
            }
            int numElements = (int) (tableSize * fillpercantage); // Change the fill percentage here

            HashTable hashTable = new HashTable(tableSize);
            int random;

            for (int i = 0; i < numElements; i++) {
                random = (int) (Math.random() * tableSize);
                int key = random;
                hashTable.insert(key);
            }

            int totalCollisions = 0;
            for (int i = 0; i < numTests; i++) {
                random = (int) (Math.random() * tableSize);
                int key = random;
                //hashTable.access(key);
                totalCollisions += hashTable.getCollisions();
                hashTable.collisions = 0; // Reset collisions for next test
            }
            double averageCollisions = (double) totalCollisions / numTests;
            System.out.println("Hash Table Size: " + tableSize);
            System.out.println("Fill percentage: " + fillpercantage);
            System.out.println("Number of Elements: " + numElements);
            System.out.println("Number of Tests: " + numTests);
            System.out.println("Collisions: " + totalCollisions);
            System.out.println("Average Collisions: " + averageCollisions);

        }
    }




}

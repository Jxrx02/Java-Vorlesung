
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MasterMind {

    private char word[];
    private char tipp[][] = new char[100][5];
    private int anzVersuche;
    public int anzRichtigBuchstabe;
    public int anzFalschBuchstabe;

    public static final int wordlength = 5;


    public int getAnzVersuche() {
        return this.anzVersuche;

    }

    public void setAnzVersuche(int anzVersuche) {
        this.anzVersuche = anzVersuche;
    }

    public char[] getWord() {
        return word;
    }

    public char[] getTipp() {
        return tipp[anzVersuche];
    }

    public void setTipp(String tipp) {
        if(tipp.length()>wordlength)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Wort zu lange, bitte geben sie ihren "+ wordlength +"-stelligen Tipp ab:");
            setTipp(scan.next());
        }
        this.tipp[getAnzVersuche()] = tipp.toCharArray();
    }

    public MasterMind(String pTipp, String pWord) {
        word = pWord.toCharArray();
        tipp[0] = pTipp.toCharArray();

    }

    public MasterMind(String pWord) {
        word = pWord.toCharArray();

    }
    public MasterMind() {
        this("abced");
    }

    public void checkLetters() {
        for(int i = 0; i < wordlength;i++) {
            for(int j = 0; j<wordlength;j++) {
                if(word[i]==tipp[getAnzVersuche()][j]) {
                    if(i==j)
                        anzRichtigBuchstabe++;
                    anzFalschBuchstabe++;
                }
            }
        }
    }


    public void printAusgabe(){

        for(int i = 0; i < anzVersuche;i++) {
            for (int j = 0; j < wordlength; j++) {
                System.out.print(tipp[i][j]);
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        String word = generatedString(wordlength);
        System.out.println("Wort wurde generiert: " + word);
        MasterMind mm = new MasterMind(word);
        System.out.println(mm);

        do {
            System.out.println("\nGeben sie ihren Tipp ab:");
            mm.setTipp(scan.next());

            mm.checkLetters();
            mm.setAnzVersuche(mm.getAnzVersuche() + 1);

            System.out.println("bisherige Versuche:" + mm.getAnzVersuche());
            System.out.println("Buchstaben an falsche Stelle " + mm.anzFalschBuchstabe + " Buchstaben an richtiger Stelle " + mm.anzRichtigBuchstabe);
            mm.printAusgabe();

            if(mm.anzRichtigBuchstabe == 5)
                break;

            mm.anzFalschBuchstabe = 0;
            mm.anzRichtigBuchstabe =0;
        } while(mm.getTipp() != mm.word);

        System.out.println("Du hast das Wort erraten!");
    }


    @Override
    public String toString() {
        return "MasterMind: word=" + Arrays.toString(word) + ", tipp=" + Arrays.toString(tipp);
    }

    public static String generatedString(int length) {
        char[] chars = {'a','b','c','d','e','f','g','h'};

        String word="";
        for(int i = 0; i< length; i++) {
            word+=chars[MasterMind.randInt(0,3)];
        }
        return word;
    }
    public static int randInt(int min, int max) {
        Random rand= new Random();
        int randomNum = rand.nextInt((max-min)+1)+min;
        return randomNum;
    }
}

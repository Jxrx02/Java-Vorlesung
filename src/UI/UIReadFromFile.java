package UI;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UIReadFromFile extends JFrame {




    public UIReadFromFile(String dateiname, int breite, int höhe){
        JTextArea jTextArea = new JTextArea();

        List<String> lines = new ArrayList<>(); // zweites Semester!
        try ( BufferedReader br =
                      new BufferedReader(new FileReader(dateiname)) ) {
            while (br.ready()) {
                String line = br.readLine();
                lines.add(line); // String-Daten an Liste anhängen
            }
            //System.out.print(lines);
        } catch ( IOException e ) {
            e.printStackTrace();
        }

        //füge Text der TextArea hinzu
        for(int i =0; i < lines.size();i++){
            jTextArea.append(lines.get(i)+"\n");

        }





        this.add(jTextArea);

        //scrollpanel
        JScrollPane scrPane = new JScrollPane(jTextArea);
        this.add(scrPane);

        this.setSize(breite, höhe);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(dateiname);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputArray = new String[0];
        try {
            while (inputArray.length != 3) {
                System.out.println("Dateinamen breite höhe eingeben: ");
                String input = scan.nextLine();
                inputArray = input.split(" ");


                UIReadFromFile textFrame = new UIReadFromFile(inputArray[0], Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));

            }
        }
        catch (NumberFormatException e){
            System.out.println("Zahl im falschen Format -> Programmende.");

        }


        //* Konsole
        //  dir/testFile.txt 600 300
        //  src/UI/UIReadFromFile.java 800 600


    }
}

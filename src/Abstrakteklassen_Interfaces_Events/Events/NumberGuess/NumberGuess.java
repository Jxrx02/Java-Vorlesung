package Abstrakteklassen_Interfaces_Events.Events.NumberGuess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberGuess extends JFrame {
    static NumberGuess ng;
    String playerName = "";
    int int_guessedNumber;
    int int_number;
    int int_attempt;
    public NumberGuess(){

        setLayout(new GridLayout(4, 1,2,20));

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();


        panel3.setLayout(new GridLayout(1, 4, 2, 2));

        JLabel label = new JLabel("PlayerName");                    panel1.add(label);
        JTextField textField_name = new JTextField();                    panel1.add(textField_name);
        textField_name.setColumns(8);

        JLabel label2 = new JLabel("Number between 1 and 100");     panel2.add(label2);
        JTextField textField_guess = new JTextField();                   panel2.add(textField_guess);
        textField_guess.setColumns(8);

        JButton btn_new = new JButton("New Game");                  panel3.add(btn_new);
        JButton btn_ok = new JButton("Ok");                         panel3.add(btn_ok);
        JButton btn_best_player = new JButton("Best Player");       panel3.add(btn_best_player);
        JButton btn_exit = new JButton("Exit");                     panel3.add(btn_exit);

        JTextField textField_result = new JTextField();                 panel4.add(textField_result);
        textField_result.setColumns(16);
        textField_result.setEditable(false);


        //new game
       btn_new.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               playerName = textField_name.getText();
               int_attempt = 0;
               int_number = (int) (Math.random() * 100);
               System.out.println(ng.toString());
           }
       });
        //submit guess
        btn_ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(int_number == Integer.parseInt(textField_guess.getText())){                      /** guess = number */
                    System.out.println("Glückwunsch, du hast die Zahl erraten");
                    textField_result.setText("Attempt #" + ++int_attempt + " Glückwunsch, du hast die Zahl erraten!");

                    //write result to file
                    wirteToFile(ng.toString());


                } else if (Integer.parseInt(textField_guess.getText()) > int_number) {              /** guess > number */
                    textField_result.setText("Attempt #" + ++int_attempt + " " + textField_guess.getText() + " => too big!");
                }
                else{                                                                               /** guess < number */
                    textField_result.setText("Attempt #" + ++int_attempt + " " + textField_guess.getText() + " => too small!");

                }
            }
        });

        btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });



        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);




        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Number Guess");
        setSize(450, 200);
    }



    public static void main(String[] args) {
        ng = new NumberGuess();
        ng.toString();



    }


    @Override
    public String toString() {
        return "NumberGuess{" +
                "playerName='" + playerName + '\'' +
                ", int_number=" + int_number +
                ", int_attempt=" + int_attempt +
                '}';
    }

    public static void wirteToFile(String string){
        try (FileWriter fWriter = new FileWriter("src/Abstrakteklassen_Interfaces_Events/Events/NumberGuess/history.txt", true)){     // öffnen des FileWriters mit Anweisung append
            fWriter.write(string + System.lineSeparator());          // Schreiben des Strings in die Datei
            System.out.println("Ergebnis in der Datei gespeichert.");
        }
        catch (IOException e) {
            e.printStackTrace();                                                // Ausgeben des Fehlers, wenn einer auftritt
        }
    }


}

package Abstrakteklassen_Interfaces_Events.Events.BinaryNumber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class BinaryNumber extends JFrame {

    public BinaryNumber(){

        setLayout(new BorderLayout(5, 5));



        JPanel top = new JPanel();
        JPanel mid = new JPanel();
        JLabel result = new JLabel();

        top.setLayout(new GridLayout(2, 8, 2, 2));
        JToggleButton[] toggleButtons = new JToggleButton[8];
        for(int i = 0; i<8;i++){
            toggleButtons[i] = new JToggleButton();
            ImageIcon imgOff = new ImageIcon("src/Abstrakteklassen_Interfaces_Events/Events/BinaryNumber/off.png");
            ImageIcon imgOn = new ImageIcon("src/Abstrakteklassen_Interfaces_Events/Events/BinaryNumber/on.png");

            toggleButtons[i].setIcon(imgOff); // icon if not selected (default icon)
            toggleButtons[i].setSelectedIcon(imgOn); // icon if selected

            toggleButtons[i].setSize(200,100);
            toggleButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    StringBuilder sb = new StringBuilder();
                    for(int i = 0; i <8; i++){
                        if(toggleButtons[i].isSelected()){
                            sb.append(1);
                        }
                        else{
                            sb.append(0);
                        }
                    }
                    
                    result.setText(String.valueOf(getDecimal(sb.toString())));
                }
            });


            top.add(toggleButtons[i]);
        }
        for(int i = 0 ;i <8; i++){
            JLabel text = new JLabel("2^" + i);
            top.add(text);
        }
        result.setText("42");
        mid.add(result);

        add(top, BorderLayout.NORTH);
        add(mid, BorderLayout.CENTER);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Binary Number");
        setSize(750, 200);

    }

    public static int getDecimal(String text){
        int result = 0;
        for(int i = 0; i < text.length();i++){
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            if(sb.charAt(i) == '0') { //0

            }
            else{   //1
                result += 1* Math.pow(2,i);

            }

        }
        return result;
    }
    public static void main(String[] args) {
        BinaryNumber bn = new BinaryNumber();
    }


}

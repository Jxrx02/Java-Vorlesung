package UI.examples;

import UI.Components_Frame;

import javax.swing.*;
import java.awt.*;

public class CurrencyConverter extends JFrame {

    public CurrencyConverter(){
        setLayout(new BorderLayout(5, 5));

        //textfeld
        JTextField textField = new JTextField();
        textField.setToolTipText("Please enter amount to convert!");

        //JPANEL
        JPanel panel = new JPanel();
        Button btn_euro_usd = new Button("Euro -> USD");
        Button btn_usd_euro = new Button("USD -> Euro");
        Button btn_cancel = new Button("Cancel");
        //add to panel
        panel.add(btn_euro_usd, BorderLayout.WEST);
        panel.add(btn_usd_euro,BorderLayout.CENTER);
        panel.add(btn_cancel, BorderLayout.EAST);

        //add panel, textfield to layout
        add(textField, BorderLayout.NORTH);
        add(panel, BorderLayout.SOUTH);


        // Setze die Größe und Sichtbarkeit des JFrame
        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Currencyconverter");

    }


    public static void main(String[] args) {
        // Erstelle ein neues JFrame
        CurrencyConverter frame = new CurrencyConverter();
    }
}

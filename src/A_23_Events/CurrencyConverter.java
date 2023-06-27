package A_23_Events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        //add listener
        btn_euro_usd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                        textField.setText(String.valueOf((Double.parseDouble(textField.getText()) * 1.09)));
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null,
                            "Falsche Eingabe: " + ex,
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btn_usd_euro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                        textField.setText(String.valueOf((Double.parseDouble(textField.getText()) / 1.09)));
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null,
                            "Falsche Eingabe: " + ex,
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }


            }
        });
        btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

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

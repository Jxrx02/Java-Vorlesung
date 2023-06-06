package Events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMI extends JFrame {

    boolean ismale;
    public BMI(){
        setLayout(new BorderLayout(5, 5));



        //label
        JLabel label_weight = new JLabel("Weight [KG]: ");
        //textfeld
        JTextField textField_weight = new JTextField();
        textField_weight.setToolTipText("Your Weight!");
        textField_weight.setColumns(8);


        //label
        JLabel label_size = new JLabel("Body height [M]: ");
        //textfeld
        JTextField textField_size = new JTextField();
        textField_size.setToolTipText("Your Size!");
        textField_size.setColumns(8);

        //label
        JLabel label_bmi = new JLabel("Body height [M]: ");
        //textfeld
        JTextField textField_bmi = new JTextField();
        textField_bmi.setEditable(false);
        textField_bmi.setColumns(8);

        //textfeld
        JTextField textField_description = new JTextField();
        textField_description.setEditable(false);
        textField_description.setColumns(8);

        Button btn_calc = new Button("Calculate");
        btn_calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double bmi = getBMI(Double.valueOf(textField_weight.getText()), Double.valueOf(textField_size.getText()));
                System.out.println("BMI: " + bmi);
                textField_bmi.setText(String.valueOf(bmi));


                if(ismale)
                {
                    if(bmi <20) textField_description.setText("Untergewicht");
                }
            }
        });

        //JPANEL
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        //add to panel
        panel1.add(label_weight);
        panel1.add(textField_weight);

        panel2.add(label_size);
        panel2.add(textField_size);

        panel3.add(btn_calc);

        panel4.add(label_bmi);
        panel4.add(textField_bmi);
        panel4.add(textField_description);

        //add panel, textfield to layout
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);

        add(panel, BorderLayout.CENTER);

        //radiobutton
        ButtonGroup buttonGroup = new ButtonGroup();            //für 1 anklickbaren button
        for(int i =0;i<2;i++){
            JRadioButton radio;
            if(i ==0){
                radio = new JRadioButton("Male");
                radio.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ismale = true;
                    }
                });
            }
            else {
                radio = new JRadioButton("Female");
                radio.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ismale = false;
                    }
                });
            }

            buttonGroup.add(radio);
            panel.add(radio);
        }

        // Setze die Größe und Sichtbarkeit des JFrame
        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("BMI Calculator");

    }

    public double getBMI(double weight, double height){
        //BMI = (Körpergewicht in kg) / (Größe in m)2
        return weight / (height*height);
    }

    public static void main(String[] args) {
        // Erstelle ein neues JFrame
        BMI frame = new BMI();
    }
}



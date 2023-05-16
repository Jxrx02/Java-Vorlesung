package UI.layouts;
import java.awt.*;
import javax.swing.*;

public class BorderLayout_Example_BookManagement {
    public BorderLayout_Example_BookManagement() {
        JFrame jf = new JFrame("Book Management");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout(5, 5));


        JPanel top = new JPanel();
        top.setLayout(new GridLayout(4, 2, 2, 2));
        top.add(new JLabel("Author"));
        top.add(new JTextField(""));
        top.add(new JLabel("Title"));
        top.add(new JTextField(""));
        top.add(new JLabel("Year"));
        top.add(new JTextField(""));
        top.add(new JLabel("Publisher"));
        top.add(new JTextField(""));
        jf.add(top, BorderLayout.NORTH);


        JPanel mid = new JPanel();
        mid.add(new JButton("Save Entry"));
        jf.add(mid, BorderLayout.CENTER);


        JPanel bot = new JPanel();
        bot.setLayout(new FlowLayout());
        bot.add(new JLabel("Output sorted by:"));
        bot.add(new JButton("Author"));
        bot.add(new JButton("Title"));
        bot.add(new JButton("Year"));
        jf.add(bot, BorderLayout.SOUTH);

        jf.pack();
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        new BorderLayout_Example_BookManagement();
    }
}
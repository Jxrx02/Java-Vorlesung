package A_20_UI.menubar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TT {

  private JButton button2;

  private TT() {
    // put these objects in a class scope if there are problems
    JFrame frame = new JFrame();
    JPanel topPane = new JPanel();
    JPanel centerPane = new JPanel();
    JPanel bottomPane = new JPanel();

    topPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 10));
    centerPane.setLayout(new GridLayout(3, 4, 2, 2));
    frame.setLayout(new BorderLayout());
            /* other Layouts:
                - BorderLayout
                - BoxLayout
                - CardLayout
                - FlowLayout
                - GridBagLayout
                - GridLayout      new GridLayout(4, 2, 2, 2)
                - GroupLayout
             */
    JButton button = new JButton("Button");
    ActionListener actionListener = e -> {
      System.out.println("Button was pressed!");
    };
    button.addActionListener(actionListener);
    topPane.add(button);

    button2 = new JButton("Button2");
    button2.addActionListener(e -> {
      System.out.println("Button was pressed!");

    });


    centerPane.add(button2);

    frame.add(topPane, BorderLayout.PAGE_START);
    frame.add(centerPane, BorderLayout.CENTER);
    frame.add(bottomPane, BorderLayout.PAGE_END);

    frame.setTitle("Title of the windows");
    // frame.setSize(1000, 500);
    frame.pack(); // auto sizing
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    TT t = new TT();
  }


}
package AA_Klausuren.Probeklausr_SnatChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnatChatWindow implements SnatChatFrontend {
  private ChatMessagesComponent chatMessages;
  public SnatChatWindow(SnatChatRoom room, Account acc) {
    // put these objects in a class scope if there are problems
    var frame = new JFrame();
    var topPane = new JPanel();

    var label = new JLabel (acc.getName());
    label.setForeground(acc.getColor());
    topPane.add(label);


    var centerPane = new JPanel();
    chatMessages = new ChatMessagesComponent();
    centerPane.add(chatMessages);

    //radiobutton
    var radioPane = new JPanel();
    var buttonGroup = new ButtonGroup();            //für 1 anklickbaren button
    var radio1 = new JRadioButton("Available");
    radio1.setSelected(true);
    radio1.addActionListener(e -> {
      acc.setState(State.AVAILABLE);
      JOptionPane.showMessageDialog(null, String.format("Set state of '%s' is now '%s'", acc.getName(),acc.getState()));
      room.sendMessage(String.format("State of user '%s' is now '%s'",acc.getName(), acc.getState()));
    });
    buttonGroup.add(radio1);
    radioPane.add(radio1);
    var radio2 = new JRadioButton("Away");
    radio2.addActionListener(e -> {
      acc.setState(State.AWAY);
      JOptionPane.showMessageDialog(null, String.format("Set state of '%s' is now '%s'", acc.getName(),acc.getState()));
      room.sendMessage(String.format("State of user '%s' is now '%s'",acc.getName(), acc.getState()));
    });
    buttonGroup.add(radio2);
    radioPane.add(radio2);
    var radio3 = new JRadioButton("Do not disturb");
    radio3.addActionListener(e -> {
      acc.setState(State.DND);
      JOptionPane.showMessageDialog(null, String.format("Set state of '%s' is now '%s'", acc.getName(),acc.getState()));
      room.sendMessage(String.format("State of user '%s' is now '%s'",acc.getName(), acc.getState()));
    });
    buttonGroup.add(radio3);
    radioPane.add(radio3);
    centerPane.add(radioPane);


    JPanel bottomPane = new JPanel();
    JTextField textField = new JTextField();
    textField.setColumns(16);
    bottomPane.add(textField);
    var button = new JButton("Send");
    ActionListener actionListener = e -> {
      if(textField.getText().isBlank()){
        JOptionPane.showMessageDialog(null,
                "Dear " + acc.getName() +", please enter a message",
                "Warning!",
                JOptionPane.WARNING_MESSAGE);
      }
      else{
        var msg = new Message(acc, textField.getText());
        room.sendMessage(msg);
        textField.setText("");
      }
    };
    textField.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == KeyEvent.VK_ENTER && !textField.getText().isBlank()) {
            Message msg = new Message(acc, textField.getText());
            room.sendMessage(msg);
            textField.setText("");
            System.out.println("pressed enter");
          }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
      });

    button.addActionListener(actionListener);

    bottomPane.add(button);

    topPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));
    centerPane.setLayout(new GridLayout(2, 4, 2, 2));
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

    frame.add(topPane, BorderLayout.PAGE_START);
    frame.add(centerPane, BorderLayout.CENTER);
    frame.add(bottomPane, BorderLayout.PAGE_END);

    frame.setTitle(acc.getName()+  "(" + room.getRoomName() + ")");
    frame.setSize(1000, 500);
    //frame.pack(); // auto sizing
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  @Override
  public void receiveMessage(Message msg) {
    var a = new JLabel ( msg.getAccount().getName() +": " + msg.getText());
    a.setForeground(msg.getAccount().getColor());
    chatMessages.add(a);

    Runnable countdown = () -> {
      int start = 30;
      String origText = a.getText();
      for (int i = start; i > 0; i--) {
        a.setText(origText + " [" + i + "]");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
      }
      chatMessages.remove(a);
    };
    new Thread(countdown).start();
  }

  @Override
  public void recieveMessage(String text) {
    var a = new JLabel (text);
    a.setForeground(Color.GRAY);
    chatMessages.add(a);

    Runnable countdown = () -> {
        int start = 30;
        String origText = a.getText();
        for (int i = start; i > 0; i--) {
            a.setText(origText + " [" + i + "]");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        chatMessages.remove(a);
    };
    new Thread(countdown).start();
  }

  @Override
  public Account getAccount() {
    return null;
  }


}

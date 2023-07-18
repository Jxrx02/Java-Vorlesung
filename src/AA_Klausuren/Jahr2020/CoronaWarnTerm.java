package AA_Klausuren.Jahr2020;

import javax.swing.*;
import java.awt.*;

public class CoronaWarnTerm {
    private JPhone jPhone;
    private WarnStatus warnStatus = WarnStatus.UNKNOWN;
    private CoronaWarnClient coronaWarnClient = new CoronaWarnClient();

    public CoronaWarnTerm(JPhone phone1) {

        this.jPhone = phone1;
        coronaWarnClient.setChangingTokens(CoronaWarn.loadTokens(phone1));
        coronaWarnClient.setCurToken(new Token()); ;
        CoronaWarn.saveToken(phone1,coronaWarnClient.getCurrentToken());
        CoronaWarnAPI.sendToken(this.coronaWarnClient);

        JFrame jf = new JFrame(this.jPhone.getOwner());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout(5, 5));;

        JLabel label = new JLabel();
        label.setText(warnStatus.getText());
        label.setBackground(warnStatus.getColor());
        label.setOpaque(true);
        label.setPreferredSize(new java.awt.Dimension(0,100));
        label.setHorizontalAlignment(JLabel.CENTER);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(5, 1, 2, 2));
        JLabel seenTokens = new JLabel("Seen Tokens: " + coronaWarnClient.getAllSeenTokens().size());
        seenTokens.setToolTipText(coronaWarnClient.getCurrentToken().getValue() +" " +  coronaWarnClient.getCurrentToken().getDate());

        JButton btn_new = new JButton("New Token");
        btn_new.addActionListener(e -> {
            Token newToken = new Token();
            coronaWarnClient.setCurToken(newToken);
            CoronaWarnAPI.sendToken(this.coronaWarnClient);
            seenTokens.setToolTipText(coronaWarnClient.getCurrentToken().getValue() +" " +  coronaWarnClient.getCurrentToken().getDate());
            seenTokens.setText("Seen Tokens: " + coronaWarnClient.getAllSeenTokens().size());
        });
        JButton btn_check = new JButton("Check for Infections");
        btn_check.addActionListener(e -> {
            if(CoronaWarnAPI.checkInfection(this.coronaWarnClient)){
                warnStatus = WarnStatus.ALARM;
            }
            else {
                warnStatus = WarnStatus.OK;
            }

            label.setText(warnStatus.getText());
            label.setBackground(warnStatus.getColor());
        });
        JButton btn_clear = new JButton("Clear Tokens");
        btn_clear.addActionListener(e -> {
            coronaWarnClient.clearTokens();
            CoronaWarn.clearTokenStore(jPhone);
            //neues Token wie beim new-btn
            Token newToken = new Token();
            coronaWarnClient.setCurToken(newToken);
            CoronaWarnAPI.sendToken(this.coronaWarnClient);
            seenTokens.setToolTipText(coronaWarnClient.getCurrentToken().getValue() +" " +  coronaWarnClient.getCurrentToken().getDate());
            seenTokens.setText("Seen Tokens: " + coronaWarnClient.getAllSeenTokens().size());

        });
        JButton btn_report = new JButton("New Report Infections");
        btn_report.addActionListener(e -> {
            CoronaWarnAPI.reportInfection(this.coronaWarnClient);
            //deaktiviere Buttons
            btn_new.setEnabled(false);
            btn_clear.setEnabled(false);
            btn_report.setEnabled(false);
            btn_check.setEnabled(false);

            //aktualisiere Label
            warnStatus = WarnStatus.INFECTED;
            label.setText(warnStatus.getText());
            label.setBackground(warnStatus.getColor());
        });

        buttons.add(btn_new);
        buttons.add(btn_check);
        buttons.add(btn_clear);
        buttons.add(btn_report);
        buttons.add(seenTokens);

        jf.add(label, BorderLayout.NORTH);
        jf.add(buttons, BorderLayout.CENTER);



        jf.setSize(500, 300);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }


}

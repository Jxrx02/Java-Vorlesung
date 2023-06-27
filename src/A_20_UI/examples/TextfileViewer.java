package A_20_UI.examples;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextfileViewer extends JFrame {
    private static final ArrayList<String> lines = new ArrayList<String>();
    private static String path;
    public static String ChoosSingleFile(){
        javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() ||
                        f.getName().toLowerCase().endsWith(".txt");
            }
            @Override
            public String getDescription() {
                return "Text Files";
            }
        });
        int state = fc.showOpenDialog(null); // Varianten öffnen / zeigen
// int state = fc.showSaveDialog(null); // Variante speichern
// int state = fc.showDialog(null, "Delete"); // freie Variante
        if (state == javax.swing.JFileChooser.APPROVE_OPTION){
            System.out.println(fc.getSelectedFile().getAbsolutePath());
            return fc.getSelectedFile().getAbsolutePath();
        } else {
            System.out.println("No selection");
            return null;
        }

    }


    public static void readFileToDataStructure(){
        try ( BufferedReader br =
                      new BufferedReader(new FileReader(path)) ) {
            while (br.ready()) {
                String line = br.readLine();
                lines.add(line); // String-Daten an Liste anhängen
                lines.add(line);
            }
            System.out.print(lines);
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }

    public TextfileViewer(int pI){
        if(pI==0){
            JTextArea jTextArea = new JTextArea();

            //füge Text der TextArea hinzu
            for(int i =0; i < lines.size();i++){
                jTextArea.append(lines.get(i)+"\n");

            }

            this.add(jTextArea);

            //scrollpanel
            JScrollPane scrPane = new JScrollPane(jTextArea);
            this.add(scrPane);

        } else if (pI==1) {

            this.setLayout(new GridLayout(10,1,1,1));


            //label
            for(int i = 0; i<10; i++){
                JLabel label = new JLabel(lines.get(i));
                this.add(label);
            }

        }
        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(path);
    }

    public static void main(String[] args) {
        path = ChoosSingleFile();

        readFileToDataStructure();
        TextfileViewer tv = new TextfileViewer(0);
        TextfileViewer tv2 = new TextfileViewer(1);
    }
}

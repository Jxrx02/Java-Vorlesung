package A_20_UI.dialog;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class JFileChooser {


    public static void ChoosSingleFile(){
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
        } else {
            System.out.println("No selection");
        }

    }

    public static void ChooseMultipleFiles(){
        javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
        fc.setMultiSelectionEnabled(true);
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
        int state = fc.showOpenDialog(null);
        if (state == javax.swing.JFileChooser.APPROVE_OPTION){
            File[] selectedFiles = fc.getSelectedFiles();
            for (File f : selectedFiles)
                System.out.println(f.getAbsolutePath());
        } else {
            System.out.println("No selection");
        }
    }


    public static void main(String[] args) {
        ChooseMultipleFiles();
        ChooseMultipleFiles();
    }
}

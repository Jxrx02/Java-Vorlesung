package A_25_Datenstrukturen_Generics.Exercise.GasStation;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GasStation {


    /** ---------------------------------------Datentypen-----------------------------------------
     Set        - Mengencharakter, Keine Duplikate, keine Indexierung
     HashSet,TreeSet

     Sorted Set - Sortierte Mengen, keine Indexierung
     TreeSet

     List       - über Ints indiziert                                                       shuffle, sort, reverse, min, max, binarySearch
     Vector, ArrayList (Iteration), LinkedList(Hinzufügen,Löschen)

     Map        - Schlüssel zu Werten; Werte können Duplikate haben, Schlüssel nicht        put(), get(), size(); keySet(), values() remove, clear, containsKey/value, isEmpty,
     HashMap, WeakHashMap TreeMap Hashtable

     SortedMap  - Schlüssel sortiert
     TreeMap

     Stack      - Elemente oben drauf;

     Iterator   - Listen durchlaufen; Elemente können gelöscht werden
     */

    /** ----------------------------------Methoden,-die-alle-haben-----------------------------------------
     *  add(), addAll(), remove(), contains(), size()
     */


    public TreeMap<String, GasPrice> map = new TreeMap();

    public GasStation(){
        JFrame jf = new JFrame("Gas Station");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout(5, 5));
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(4, 2, 2, 2));

        top.add(new JLabel("Station Name"));
        JTextField stationField =  new JTextField("");
        top.add(stationField);

        top.add(new JLabel("Diesel"));
        JTextField dieselField =  new JTextField("");
        top.add(dieselField);

        top.add(new JLabel("Super E5"));
        JTextField superE5Field =  new JTextField("");
        top.add(superE5Field);

        top.add(new JLabel("Super E10"));
        JTextField superE10Field =  new JTextField("");
        top.add(superE10Field);

        JPanel buttons = new JPanel();
        Button btn_save = new Button("Save");
        btn_save.addActionListener(e -> {
            if(!stationField.getText().isBlank()) {
                try{
                    Double.parseDouble(dieselField.getText());
                }catch (Exception ex ){
                    dieselField.setText(String.valueOf(-1));
                }

                GasPrice gp = new GasPrice(stationField.getText(), dieselField.getText(), superE5Field.getText(), superE10Field.getText());
                JOptionPane.showMessageDialog(null, "Saved: " + gp);
                map.put((stationField.getText()), gp);
                System.out.println(map);
            }
            else{
                JOptionPane.showMessageDialog(null, "Bitte Station eingeben." );

            }

        });

        Button btn_showall = new Button("Show all");
        btn_showall.addActionListener(e ->{
            JOptionPane.showMessageDialog(null, "Show all: " + map);

        });

        buttons.add(btn_save);
        buttons.add((btn_showall));

        jf.add(top, BorderLayout.NORTH);
        jf.add(buttons, BorderLayout.CENTER);
        jf.setSize(300, 200);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new GasStation();



    }




}

package GUI;

import LOGIC.Controller;

import javax.swing.*;
import java.util.ArrayList;

public class SafheVaziatTahsiliDaneshjoo extends JPanel {
    JTable jTable;
    JScrollPane jScrollPane;

    String columns[] = {"ID","DARS","TEDADVAHED","NOMRE"};
    ArrayList<ArrayList<String>> data = new ArrayList<>();

    public SafheVaziatTahsiliDaneshjoo(){
        initPanle();
        initCopms();
        align2();


        GuiController.getInstance().addJpannel(this);
    }
    private void initPanle() {

        this.setBounds(0,30,800,770);
        this.setVisible(true);
        this.setLayout(null);



    }
    public void initCopms(){
        int tedadvahed = 0;
        double sum = 0;
        double counter = 0;
        double average = 0;
        data = Controller.getInstance().getListDorosGerefteshodeDaneshjoo();
        for (ArrayList<String> i:
             data) {
            try {
                sum = sum + (Double.parseDouble(i.get(3)) * Double.parseDouble(i.get(2)));
                counter++;
            }catch (Exception e2){


            }
            try {
                tedadvahed = tedadvahed + Integer.parseInt(i.get(2));
            }catch (Exception e1){


            }
        }
        if (!(counter == 0.0)){
            average = sum / counter;
        }
        ArrayList<String> k = new ArrayList<>();
        k.add("JAM/AVG");
        k.add("____");
        k.add(String.valueOf(tedadvahed));
        k.add(String.valueOf(average));
        data.add(k);
        String data1[][] = data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        jTable = new JTable(data1,columns);

        jScrollPane = new JScrollPane(jTable);
    }
    public void align2(){
        jScrollPane.setBounds(50,50,600,300);
        this.add(jScrollPane);
    }

}

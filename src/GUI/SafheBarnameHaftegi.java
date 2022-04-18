package GUI;

import LOGIC.Controller;
import LOGIC.Dars;
import LOGIC.RoozayeHafte;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SafheBarnameHaftegi extends JPanel {
    JTable jTable;
    JScrollPane jScrollPane;
    JButton namyesh;
    ArrayList<String> colomns;
    ArrayList<ArrayList<String>> data;
    String data1[][];
    String colomns1[] = {"SHANBE","YEKSHANBE","DOSHANBE","SESHANBE","CHARSHANBE","PANJSHANBE","JOME"};

    public SafheBarnameHaftegi(){
        initSafheBarnamePanel();
        initCopms();
        align();
        setActionListener();


        GuiController.getInstance().addJpannel(this);
    }
    public void initSafheBarnamePanel(){


        this.setBounds(0,30,800,770);
        this.setVisible(true);
        this.setLayout(null);




    }
    public void initCopms(){
        colomns = new ArrayList<>();
        data = new ArrayList<>();
        namyesh = new JButton("namayesh");
        for (RoozayeHafte i:
             RoozayeHafte.values()) {
            colomns.add(i.name());
        }
        for (int q = 0;q < 8;q++){
            data.add(new ArrayList<>());
            for (int w = 0; w < colomns.size();w++){
                data.get(q).add(null);
            }
        }
        jTable = null;
        jScrollPane = null;
        for (Dars i:
                Controller.getInstance().getDarsDaneshjoo()) {
            int rh = 0;
            int sd = 0;
            for (RoozayeHafte j:
                 i.getRoozClassDars()) {
                rh = Controller.getInstance().roozHafte(j);
                sd = Controller.getInstance().saatClass(i.getSaatClass());
                data.get(sd).set(rh,i.getName());
            }
        }
        data1 = data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

    }
    public void align(){
        namyesh.setBounds(100,100,150,30);
        this.add(namyesh);

    }
    public void setActionListener(){
        namyesh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTable = new JTable(data1,colomns1);
                jScrollPane = new JScrollPane(jTable);
                add(jScrollPane);
                System.out.println("eybaba");
            }
        });
    }

}

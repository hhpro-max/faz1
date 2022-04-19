package GUI;

import LOGIC.Controller;
import LOGIC.Ostad;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class SafheDarkhastTosieName extends JPanel {
    static final Logger logger = LogManager.getLogger(SafheDarkhastTosieName.class);
    JTable jTable;
    JScrollPane jScrollPane;
    JComboBox<String> asatid;
    ArrayList<Ostad> asatid1;
    JButton sabtDarkhast;
    String columns[] = {"ID","OSTAD","MOSHAHEDE NATIJE"};
    public ArrayList<ArrayList<String>> data = new ArrayList<>();
    JOptionPane jOptionPane;




    public SafheDarkhastTosieName(){
        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");
        initSafheDarkhastTosienamepane();
        initCopms();
        align();
        setActionListener();


        GuiController.getInstance().addJpannel(this);
    }



    public void initSafheDarkhastTosienamepane(){


        this.setBounds(0,30,800,770);
        this.setVisible(true);
        this.setLayout(null);


    }
    private void initCopms() {

        asatid1 = Controller.getInstance().getAsatidDaneshjoo();
        ArrayList<String> name = new ArrayList<>();
        if (!(asatid1 == null)){
        for (Ostad i:
             asatid1) {
            name.add(i.getName());
        }
        }
        String names[] = name.toArray(new String[0]);
        asatid = new JComboBox<>(names);
        sabtDarkhast = new JButton("SABT DARKHAST");
        jTable = null;
        jScrollPane = null;
        jOptionPane = new JOptionPane();
    }
    public void align(){
        sabtDarkhast.setBounds(10,50,150,30);
        this.add(sabtDarkhast);
        asatid.setBounds(200,50,150,30);
        this.add(asatid);
    }
    public void setActionListener(){
        sabtDarkhast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    if (!(jScrollPane==null)){
                        remove(jScrollPane);
                    }
                    repaint();
                    revalidate();

                    Controller.getInstance().addDarkhastTosieName(asatid1.get(asatid.getSelectedIndex()).getId());
                    data.add(new ArrayList<>());
                    for (ArrayList<String> i:
                            data) {
                        if (i.isEmpty()){
                            i.add(asatid1.get(asatid.getSelectedIndex()).getId());
                            i.add(asatid1.get(asatid.getSelectedIndex()).getName());
                            i.add("*");
                        }
                    }
                    String data1[][]= data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
                    jTable = new JTable(data1,columns);
                    jScrollPane = new JScrollPane(jTable);
                    jScrollPane.setBounds(50,200,600,400);
                    jScrollPane.repaint();
                    jScrollPane.revalidate();
                    add(jScrollPane);
                    repaint();
                    revalidate();


            }
        });
    }

}

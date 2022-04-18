package GUI;

import LOGIC.Controller;
import LOGIC.Dars;
import LOGIC.RoozayeHafte;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class SafheListEmtehanat extends JPanel {
    JTable jTable;
    JScrollPane jScrollPane;
    JButton namyesh;
    ArrayList<String> colomns;
    ArrayList<ArrayList<String>> data;
    String data1[][];
    String colomns1[] = {"NAMEDARS","TARIKH EMTEHAN"};

    public SafheListEmtehanat(){
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
        ArrayList<Dars> dars = Controller.getInstance().tartibBnadiTarikhEmt();
        int k = 0;
        for (Dars i:
             dars) {
            data.add(new ArrayList<>());
            data.get(k).add(i.getName());
            data.get(k).add( String.valueOf(i.getDateEmtehan().getYear())+" "+ String.valueOf(i.getDateEmtehan().getMonth())+" "+ String.valueOf(i.getDateEmtehan().getDate()));
            k++;
        }
        jTable = null;
        jScrollPane = null;
        data1 = data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

    }
    public void align(){
        namyesh.setBounds(10,70,150,30);
        this.add(namyesh);

    }
    public void setActionListener(){
        namyesh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTable = new JTable(data1,colomns1);
                jScrollPane = new JScrollPane(jTable);
                jScrollPane.setBounds(150,150,500,500);
                add(jScrollPane);
                repaint();
                revalidate();
            }
        });
    }



}

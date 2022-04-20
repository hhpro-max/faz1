package GUI;

import LOGIC.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SafheEnserafAzTahsil extends JPanel {
    JButton jButton;
    JOptionPane jOptionPane;
    String coloms[] ={"DARKHAST ENSERAF","MOSHADE NATIJE"};
    ArrayList<ArrayList<String>> data = new ArrayList<>();
    JTable jTable;
    JScrollPane jScrollPane;

    public SafheEnserafAzTahsil(){
        initPanel();
        initCopms();
        align1();
        setActionListener();

        GuiController.getInstance().addJpannel(this);
    }
    public void initPanel(){
        this.setBounds(0,30,800,770);
        this.setVisible(true);
        this.setLayout(null);
    }
    public void initCopms(){
        jButton = new JButton("SABT DARKHAST ENSERAF AZ TAHSIL");
        jOptionPane = new JOptionPane();
        jTable = null;
        jScrollPane = null;
    }
    public void align1(){
        jButton.setBounds(10,50,250,30);
        this.add(jButton);
    }
    public void setActionListener(){
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean check = Controller.getInstance().sendDarkhastEnseraf();
                if (check){
                    if (data.isEmpty()){
                        data.add(new ArrayList<>());
                        for (ArrayList<String> i:
                             data) {
                            if (i.isEmpty()){
                                i.add("DARKHAST SHOMA SABT SHOD");
                                i.add("MOSHAHEDE NATIJE");
                            }
                        }
                        String data1[][]= data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
                        jTable = new JTable(data1,coloms);
                        jScrollPane = new JScrollPane(jTable);
                        jScrollPane.setBounds(50,200,600,400);
                        jScrollPane.repaint();
                        jScrollPane.revalidate();
                        add(jScrollPane);
                        repaint();
                        revalidate();
                    }
                }else {
                    jOptionPane.showMessageDialog(GuiController.getFrame(),"MOAVEN AMOOESHI MOJOOD NAMIBASHAD");
                }

            }
        });
    }
}

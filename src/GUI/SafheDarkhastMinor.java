package GUI;

import LOGIC.Controller;
import LOGIC.DaneshKade;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SafheDarkhastMinor extends JPanel {
    JButton jButton;
    JComboBox<DaneshKade> jComboBox;
    JOptionPane jOptionPane;
    String coloms[] ={"Daneshkade Maghsad","Moshahede Natije"};
    ArrayList<ArrayList<String>> data = new ArrayList<>();
    JTable jTable;
    JScrollPane jScrollPane;

    public SafheDarkhastMinor(){
        initSafheDarkhastMinor();
        initComps();
        align1();
        setActionListener();

        GuiController.getInstance().addJpannel(this);
    }

    public void initSafheDarkhastMinor(){


        this.setBounds(0,30,800,770);
        this.setVisible(true);
        this.setLayout(null);


    }
    public void initComps(){
        jButton = new JButton("Sabt Darkhast");
        jComboBox = new JComboBox<>(DaneshKade.values());
        jOptionPane = new JOptionPane();
        jTable = null;
        jScrollPane = null;
        if (!Controller.getInstance().getMinorData().isEmpty()){
            data.addAll(Controller.getInstance().getMinorData());
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
    }
    public void align1(){
        jButton.setBounds(10,50,150,30);
        this.add(jButton);
        jComboBox.setBounds(200,50,150,30);
        add(jComboBox);

    }
    public void setActionListener(){
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(jScrollPane==null)){
                    remove(jScrollPane);
                }
                repaint();
                revalidate();
                boolean check = Controller.getInstance().checkShartMinor();
                boolean chek1 = Controller.getInstance().sendDarkhastMinor(jComboBox.getItemAt(jComboBox.getSelectedIndex()));
                if (check && chek1){
                    try {
                        data.add(new ArrayList<>());
                        for (ArrayList<String> i:
                                data) {
                            if (i.isEmpty()){
                                i.add(String.valueOf(jComboBox.getItemAt(jComboBox.getSelectedIndex())));
                                i.add("MOSHAHEDE NATIJE");
                            }
                        }
                        Set<ArrayList<String>> set = new HashSet<>(data);
                        data.clear();
                        data.addAll(set);
                        Controller.getInstance().setMinorData(data);
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
                    catch (Exception exception){
                        JOptionPane.showMessageDialog(GuiController.getFrame(),"S.TH WENT WRONG");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(GuiController.getFrame(),"MOJAZ NISTI MOADELET MALIDE YA DANESHKADE MAGHSAD NAMOTABARE");
                    return;
                }

            }
        });
    }
}

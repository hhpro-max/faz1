package GUI;

import LOGIC.Controller;
import LOGIC.Vaziat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SafheCheckEnserafia extends JPanel {
    JTable jTable;
    JScrollPane jScrollPane;

    JTextField jTextField;
    JLabel jLabel;
    JButton jButton;
    ArrayList<ArrayList<String>> data = new ArrayList<>();
    String column[] = {"ID","NAME"};
    JOptionPane jOptionPane;
    public SafheCheckEnserafia(){
        initPanle();
        initCopms();
        align1();
        setActionListener1();
        GuiController.getInstance().addJpannel(this);
    }
    private void initPanle() {

        this.setBounds(0,30,800,770);
        this.setVisible(true);
        this.setLayout(null);

    }
    public void initCopms(){
        jButton = new JButton("SABT TAGHIRAT");
        jTextField = new JTextField();
        jLabel = new JLabel("ID DANESHJOOO : ");
        data = Controller.getInstance().getListEnserafia();
        String data1[][] = data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        jTable = new JTable(data1,column);
        jScrollPane = new JScrollPane(jTable);
        jOptionPane=new JOptionPane();
    }
    public void align1(){
        jButton.setBounds(600,50,150,30);
        this.add(jButton);
        jLabel.setBounds(10,50,200,30);
        this.add(jLabel);
        jTextField.setBounds(200,50,150,30);
        this.add(jTextField);
        jScrollPane.setBounds(10,100,600,600);
        this.add(jScrollPane);
    }
    public void setActionListener1(){
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jTextField.getText().isEmpty()){
                    String id = jTextField.getText();
                    boolean a = Controller.getInstance().removeDaneshjoo(id);
                    if (a){
                        if (!(jScrollPane==null)){
                            remove(jScrollPane);
                        }
                        repaint();
                        revalidate();
                        data = Controller.getInstance().getListEnserafia();
                        String data1[][] = data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
                        jTable = new JTable(data1,column);
                        jScrollPane = new JScrollPane(jTable);
                        jScrollPane.setBounds(10,100,600,600);
                        add(jScrollPane);
                        jOptionPane.showMessageDialog(GuiController.getFrame(),"MOVAFAGIAT AMIZ BOOD");
                    }else {
                        jOptionPane.showMessageDialog(GuiController.getFrame(),"ID MOJOOD NIST");
                    }
                }else {
                    jOptionPane.showMessageDialog(GuiController.getFrame(),"FIELD ID RA POR KONID");
                }
            }
        });
    }
}

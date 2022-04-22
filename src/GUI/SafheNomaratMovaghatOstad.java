package GUI;

import LOGIC.Controller;

import javax.swing.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class SafheNomaratMovaghatOstad extends JPanel {

    JTable jTable;
    JScrollPane jScrollPane;
    JButton jButton;
    JButton jButton1;
    JButton jButton2;
    JTextField jTextField;
    JTextArea jTextArea;
    JLabel jLabel;
    JLabel jLabel1;
    String columns[] = {"ID DANESHJOO","NAME DANESHJOO","ID DARS","DARS","NOMRE"};
    public ArrayList<ArrayList<String>> data = new ArrayList<>();
    JOptionPane jOptionPane;

    public SafheNomaratMovaghatOstad(){
        initPanle();
        initComps();
        align1();

        GuiController.getInstance().addJpannel(this);

    }
    private void initPanle() {

        this.setBounds(0,30,800,770);
        this.setVisible(true);
        this.setLayout(null);

    }
    public void initComps(){
        jButton = new JButton("SABT PASOKH");
        jButton1 = new JButton("SABT NOMARAT");
        jButton2 = new JButton("SABT NAHAYY");
        jTextArea = new JTextArea();
        jTextField = new JTextField();
        jLabel = new JLabel("ID DANESHJOO :");
        jLabel1 = new JLabel("MATN PASOKH :");
        data = Controller.controller.getListDaneshjooOstad();
        String data1[][] = data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        jTable = new JTable(data1,columns);
        jScrollPane = new JScrollPane(jTable);
        jOptionPane = new JOptionPane();
    }
    public void align1(){
        jLabel.setBounds(10,50,100,30);
        this.add(jLabel);
        jTextField.setBounds(150,50,100,30);
        this.add(jTextField);
        jLabel1.setBounds(300,50,100,30);
        this.add(jLabel1);
        jTextArea.setBounds(420,50,300,100);
        this.add(jTextArea);
        jButton.setBounds(500,150,150,30);
        this.add(jButton);
        jScrollPane.setBounds(10,200,500,300);
        this.add(jScrollPane);
        jButton1.setBounds(600,600,150,30);
        this.add(jButton1);
        jButton2.setBounds(400,600,150,30);
        this.add(jButton2);
    }
}

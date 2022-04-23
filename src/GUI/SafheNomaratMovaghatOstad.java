package GUI;

import LOGIC.Controller;
import LOGIC.Dars;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class SafheNomaratMovaghatOstad extends JPanel {

    JTable jTable;
    JScrollPane jScrollPane;
    JButton jButton;
    JButton jButton1;
    JButton jButton2;
    JTextField jTextField;
    JTextField jTextField1;
    JTextArea jTextArea;
    JLabel jLabel;
    JLabel jLabel1;
    JLabel jLabel2;
    String columns[] = {"ID DANESHJOO","NAME DANESHJOO","ID DARS","DARS","NOMRE"};
    public ArrayList<ArrayList<String>> data = new ArrayList<>();
    JOptionPane jOptionPane;
    boolean sabtnahayy = false;
    JTextArea jTextArea1;
    JScrollPane jScrollPane1;

    public SafheNomaratMovaghatOstad(){
        initPanle();
        initComps();
        align1();
        setActionListener1();

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
        jTextField1 = new JTextField();
        jLabel2 = new JLabel("ID DARS");
        jTextArea = new JTextArea();
        jTextField = new JTextField();
        jLabel = new JLabel("ID DANESHJOO :");
        jLabel1 = new JLabel("MATN PASOKH :");
        data = Controller.controller.getListDaneshjooOstad();
        String data1[][] = data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        jTable = new JTable(data1,columns);
        jScrollPane = new JScrollPane(jTable);
        jOptionPane = new JOptionPane();
        jTextArea1 = new JTextArea();
        ArrayList<String> arrayList = Controller.getInstance().getEterazDaneshjoo();
        for (String i:
                arrayList) {
            jTextArea1.append(i + "\n");
        }
        jScrollPane1 = new JScrollPane(jTextArea1);
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
        jLabel2.setBounds(10,100,100,30);
        this.add(jLabel2);
        jTextField1.setBounds(150,100,100,30);
        this.add(jTextField1);
        jScrollPane1.setBounds(520,200,260,300);
        this.add(jScrollPane1);
    }
    public void setActionListener1(){
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jTextField1.getText().isEmpty() && !jTextArea.getText().isEmpty() && !jTextField.getText().isEmpty()){
                    String id = jTextField1.getText();
                    String idDaneshjoo = jTextField.getText();
                    Dars dars = Controller.getInstance().getDars1(id);
                    if (!(dars==null)){
                        String matn = "NAME DARS : " +  dars.getName() + " ID OSTAD : " + Controller.getInstance().getName() + " \n MATN ETERAZ :  "+ jTextArea.getText();
                        boolean a = Controller.getInstance().sabtNatijeEteraz(idDaneshjoo,matn);
                        if (a){
                            jOptionPane.showMessageDialog(GuiController.getFrame(),"SABT SHOD");
                        }
                        else {
                            jOptionPane.showMessageDialog(GuiController.getFrame(),"S.TH went WRONG");
                        }
                    }
                    else {
                        jOptionPane.showMessageDialog(GuiController.getFrame(),"ID IS WRONG");
                    }
                }
                else {
                    jOptionPane.showMessageDialog(GuiController.getFrame(),"HICH FIELDIO KHALI NAZAR");
                }
            }

        });
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int row = jTable.getRowCount();
                    int column = jTable.getColumnCount();
                    ArrayList<String> arrayList = new ArrayList<>();
                    for (int j = 0; j  < row; j++) {
                        for (int i = 0; i  < column; i++) {

                            if (jTable.getValueAt(j,i) == null){
                                jOptionPane.showMessageDialog(GuiController.getFrame(),"TAMAM NOMARAT RA VARED KONID");
                                return;
                            }else{
                                if (i == column -1){
                                    if (Double.parseDouble(jTable.getValueAt(j,i).toString()) >20 || Double.parseDouble(jTable.getValueAt(j,i).toString())<0){
                                        jOptionPane.showMessageDialog(GuiController.getFrame(),"NOMRE SABT SHODE NAMOTABAR AST");
                                        return;
                                    }
                                }
                                arrayList.add(jTable.getValueAt(j,i).toString());
                                if (arrayList.size() == 5){
                                    boolean b = Controller.getInstance().sabtNomaratMovaghat(arrayList);
                                    if (b){
                                        arrayList.clear();
                                    }
                                    else {
                                        jOptionPane.showMessageDialog(GuiController.getFrame(),"SOMETHING WENT WRONG");

                                    }
                                }
                            }
                        }

                    }
                    jOptionPane.showMessageDialog(GuiController.getFrame(),"MOVAFAGHIAT AMIZ BOOD");
                    sabtnahayy = true;
                }catch (Exception exception){
                    jOptionPane.showMessageDialog(GuiController.getFrame(),"MOSHKEL BOZORG TAR AZ IN HARFAS");
                }
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!sabtnahayy){
                        jOptionPane.showMessageDialog(GuiController.getFrame(),"AVAL SABT MOVAGHAT KON PLS");
                        return;
                    }
                    int row = jTable.getRowCount();
                    int column = jTable.getColumnCount();
                    ArrayList<String> arrayList = new ArrayList<>();
                    for (int j = 0; j  < row; j++) {
                        for (int i = 0; i  < column; i++) {

                            if (jTable.getValueAt(j,i) == null){
                                jOptionPane.showMessageDialog(GuiController.getFrame(),"TAMAM NOMARAT RA VARED KONID");
                                return;
                            }else{
                                if (i == column -1){
                                    if (Double.parseDouble(jTable.getValueAt(j,i).toString()) >20 || Double.parseDouble(jTable.getValueAt(j,i).toString())<0){
                                        jOptionPane.showMessageDialog(GuiController.getFrame(),"NOMRE SABT SHODE NAMOTABAR AST");
                                        return;
                                    }
                                }
                                arrayList.add(jTable.getValueAt(j,i).toString());
                                if (arrayList.size() == 5){
                                    boolean b = Controller.getInstance().sabtNomaratNahayy(arrayList);
                                    if (b){
                                        arrayList.clear();
                                    }
                                    else {
                                        jOptionPane.showMessageDialog(GuiController.getFrame(),"SOMETHING WENT WRONG");

                                    }
                                }
                            }
                        }

                    }
                    jOptionPane.showMessageDialog(GuiController.getFrame(),"MOVAFAGHIAT AMIZ BOOD");
                }catch (Exception exception){
                    jOptionPane.showMessageDialog(GuiController.getFrame(),"MOSHKEL BOZORG TAR AZ IN HARFAS");
                }
            }
        });
    }
}

package GUI;

import LOGIC.Controller;
import LOGIC.Dars;
import LOGIC.Ostad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SafheNomaratMovaghatDaneshjoo extends JPanel {
    JTable jTable;
    JScrollPane jScrollPane;
    JButton sabtEteraz;
    JTextField jTextField;
    JTextArea jTextArea;
    JLabel jLabel;
    JLabel jLabel1;
    String columns[] = {"ID","DARS","NOMRE"};
    public ArrayList<ArrayList<String>> data = new ArrayList<>();
    JOptionPane jOptionPane;

    public SafheNomaratMovaghatDaneshjoo(){
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
        sabtEteraz = new JButton("SABT ETERAZ");
        jLabel = new JLabel("ID DARS : ");
        jLabel1 = new JLabel("MATN ETERAZ : ");
        jTextArea = new JTextArea();
        jOptionPane = new JOptionPane();
        jTextField = new JTextField();
        data = Controller.getInstance().getListNomaratMovaghatDaneshjoo();
        String data1[][] = data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        jTable = new JTable(data1,columns);
        jScrollPane = new JScrollPane(jTable);
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
        sabtEteraz.setBounds(500,150,150,30);
        this.add(sabtEteraz);
        jScrollPane.setBounds(10,200,500,300);
        this.add(jScrollPane);
    }
    public void setActionListener1(){
        sabtEteraz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jTextField.getText().isEmpty() && !jTextArea.getText().isEmpty()){
                    String id = jTextField.getText();
                    Dars dars = Controller.getInstance().getDars1(id);
                    if (!(dars==null)){
                        String matn = "NAME DARS : " +  dars.getName() + " ID DANESHJOO : " + Controller.getInstance().getName() + " \n MATN ETERAZ :  "+ jTextArea.getText();
                        boolean a = Controller.getInstance().sabtEteraz(id,matn);
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
    }
}

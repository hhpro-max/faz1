package GUI;

import LOGIC.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafheDarkhastKhabGah extends JPanel {
    boolean check = false;
    JButton jButton;
    JTable jTable;
    JScrollPane jScrollPane;
    String columns[] = {"MOJAZ BE DASHTAN KHABGAH"};
    String data[][]={{"MOJAZI"}};
    JOptionPane jOptionPane;

    public SafheDarkhastKhabGah(){
        initPanel();
        initComps();
        setActionListener1();
        align1();
        GuiController.getInstance().addJpannel(this);
    }
    public void initPanel(){
        this.setBounds(0,30,800,770);
        this.setVisible(true);
        this.setLayout(null);
    }
    public void initComps(){
        jButton=new JButton("SABT DARKHAST KHANGAH");
        jTable=null;
        jScrollPane=null;
        jOptionPane = new JOptionPane();
        if (Controller.getInstance().getVaziatKhabgah()){
            jTable = new JTable(data,columns);
            jScrollPane = new JScrollPane(jTable);
            jScrollPane.setBounds(50,200,600,100);
            jScrollPane.repaint();
            jScrollPane.revalidate();
            this.add(jScrollPane);
            repaint();
            revalidate();
        }
    }
    public void align1(){
        jButton.setBounds(10,50,200,30);
        this.add(jButton);
    }
    public void setActionListener1(){
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check = Controller.getInstance().checkKhabgah();
                if (check){
                    jTable = new JTable(data,columns);
                    jScrollPane = new JScrollPane(jTable);
                    jScrollPane.setBounds(50,200,600,100);
                    jScrollPane.repaint();
                    jScrollPane.revalidate();
                    add(jScrollPane);
                    repaint();
                    revalidate();
                }else {
                    jOptionPane.showMessageDialog(GuiController.getFrame(),"MOJAZ NISTI OONGHADR DOKMARO BEZAN TA MOJAZ SHI=)");
                }
            }
        });
    }

}

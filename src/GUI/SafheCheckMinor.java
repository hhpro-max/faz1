package GUI;

import LOGIC.Controller;
import LOGIC.DaneshKade;
import LOGIC.Vaziat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SafheCheckMinor extends JPanel {

    JTable jTable;
    JScrollPane jScrollPane;
    JComboBox<Vaziat> jComboBox;
    JComboBox<DaneshKade> jComboBox1;
    JTextField jTextField;
    JLabel jLabel;
    JButton jButton;
    ArrayList<ArrayList<String>> data = new ArrayList<>();
    String column[] = {"DK.MABDA","DK.MAGHSAD","ID", "NAME", "VAZIAT DK.MABDA","VAZIAT DK.MAGHSAD"};
    JOptionPane jOptionPane;

    public SafheCheckMinor() {
        initPanle();
        initCopms();
        align1();
        setActionListener1();

        GuiController.getInstance().addJpannel(this);
    }

    private void initPanle() {

        this.setBounds(0, 30, 800, 770);
        this.setVisible(true);
        this.setLayout(null);


    }
    public void initCopms(){
        jButton = new JButton("SABT TAGHIRAT");
        jTextField = new JTextField();
        jLabel = new JLabel("ID DANESHJOOO : ");
        jComboBox = new JComboBox<>(Vaziat.values());
        jComboBox1 = new JComboBox<>(DaneshKade.values());
        data = Controller.getInstance().getMinorListMoaven();
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
        jComboBox.setBounds(400,50,150,30);
        this.add(jComboBox);
        jComboBox1.setBounds(400,100,150,30);
        this.add(jComboBox1);
        jScrollPane.setBounds(10,200,700,500);
        this.add(jScrollPane);
    }
    public void setActionListener1(){
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jTextField.getText().isEmpty()){
                    String id = jTextField.getText();
                    Vaziat vaziat = jComboBox.getItemAt(jComboBox.getSelectedIndex());
                    DaneshKade daneshKade = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());
                    boolean a = Controller.getInstance().setVaziatDarkhastMinorDaneshjoo(id,daneshKade,vaziat);
                    if (a){
                        if (!(jScrollPane==null)){
                            remove(jScrollPane);
                        }
                        repaint();
                        revalidate();
                        data = Controller.getInstance().getMinorListMoaven();
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

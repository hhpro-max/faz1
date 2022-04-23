package GUI;

import LOGIC.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SafheVaziatTahsiliMoaven extends JPanel {
    JTable jTable;
    JScrollPane jScrollPane;
    JTextField jTextField;
    JOptionPane jOptionPane;
    JButton jButton;

    String columns[] = {"ID DANESHJOO","NAME DANESHJOO","ID DARS","DARS","TEDADVAHED","NOMRE"};
    ArrayList<ArrayList<String>> data = new ArrayList<>();

    public SafheVaziatTahsiliMoaven(){
        initPanle();
        initComps2();
        align2();
        setActionListener2();

        GuiController.getInstance().addJpannel(this);
    }
    private void initPanle() {

        this.setBounds(0,30,800,770);
        this.setVisible(true);
        this.setLayout(null);



    }
    public void initComps2(){
        data = Controller.getInstance().getVaziatTahsilyList();
        String data1[][] = data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        jTable = new JTable(data1,columns);
        jScrollPane = new JScrollPane(jTable);
        jTextField = new JTextField();
        jButton = new JButton("SEARCH DANESHJOO");
        jOptionPane = new JOptionPane();

    }
    public void align2(){
        jTextField.setBounds(10,50,150,30);
        this.add(jTextField);
        jButton.setBounds(200,50,200,30);
        this.add(jButton);
        jScrollPane.setBounds(10,100,600,300);
        this.add(jScrollPane);
    }
    public void setActionListener2(){
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(jTextField.getText().isEmpty())){
                    remove(jScrollPane);
                    repaint();
                    revalidate();
                    data = Controller.getInstance().getVaziatTahsilyList();
                    ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
                    String id = jTextField.getText();

                    for (ArrayList<String> i:
                         data) {
                        if (i.get(0).equals(id)){
                            arrayLists.add(i);
                        }
                    }
                    String data1[][] = arrayLists.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
                    jTable = new JTable(data1,columns);
                    jScrollPane = new JScrollPane(jTable);
                    jScrollPane.setBounds(10,100,600,300);
                    jScrollPane.repaint();
                    jScrollPane.revalidate();
                    add(jScrollPane);
                    repaint();
                    revalidate();
                }
                else {

                    jOptionPane.showMessageDialog(GuiController.getFrame(),"ID DANESHJOO RA VARED KONID");
                }
            }
        });
    }
}

package GUI;

import LOGIC.Controller;
import LOGIC.Ostad;
import LOGIC.Vaziat;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class SafheDarkhastTosieName extends JPanel {
    static final Logger logger = LogManager.getLogger(SafheDarkhastTosieName.class);
    JTable jTable;
    JScrollPane jScrollPane;
    JComboBox<String> asatid;
    ArrayList<Ostad> asatid1;
    JButton sabtDarkhast;
    String columns[] = {"ID","OSTAD","NATIJE"};
    public ArrayList<ArrayList<String>> data = new ArrayList<>();
    JOptionPane jOptionPane;
    JButton jButton;




    public SafheDarkhastTosieName(){
        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");
        initSafheDarkhastTosienamepane();
        initCopms();
        align();
        setActionListener();


        GuiController.getInstance().addJpannel(this);
    }



    public void initSafheDarkhastTosienamepane(){


        this.setBounds(0,30,800,770);
        this.setVisible(true);
        this.setLayout(null);


    }
    private void initCopms() {

        asatid1 = Controller.getInstance().getAsatidDaneshjoo();
        ArrayList<String> name = new ArrayList<>();
        if (!(asatid1 == null)){
        for (Ostad i:
             asatid1) {
            name.add(i.getName());
        }
        }
        String names[] = name.toArray(new String[0]);
        asatid = new JComboBox<>(names);
        sabtDarkhast = new JButton("SABT DARKHAST");
        jTable = null;
        jScrollPane = null;
        if (!Controller.getInstance().getDarkhatTosieNameDaneshjoo().isEmpty()){
            String data1[][] = Controller.getInstance().getDarkhatTosieNameDaneshjoo().stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
            jTable = new JTable(data1,columns);
            jScrollPane = new JScrollPane(jTable);
            jScrollPane.setBounds(50,200,600,400);
            jScrollPane.repaint();
            jScrollPane.revalidate();
            add(jScrollPane);
            repaint();
            revalidate();
        }
        jOptionPane = new JOptionPane();
        jButton = new JButton("REFRESH TABLE");
    }
    public void align(){
        sabtDarkhast.setBounds(10,50,150,30);
        this.add(sabtDarkhast);
        asatid.setBounds(200,50,150,30);
        this.add(asatid);
        jButton.setBounds(400,50,150,30);
        this.add(jButton);
    }
    public void setActionListener(){
        sabtDarkhast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    ArrayList<String> checkTekrary = new ArrayList<>();
                    if (!(jScrollPane==null)){
                        remove(jScrollPane);
                    }
                    repaint();
                    revalidate();


                    data.add(new ArrayList<>());
                    for (ArrayList<String> i:
                            data) {
                        if (i.isEmpty()){
                            i.add(asatid1.get(asatid.getSelectedIndex()).getId());
                            i.add(asatid1.get(asatid.getSelectedIndex()).getName());
                            i.add(Vaziat.SABTSHODE.toString());
                            checkTekrary.addAll(i);
                            break;
                        }
                    }
                    int counter = 0;
                    boolean check1 = true;
                    for (ArrayList<String> i:
                            data    )   {
                        if (i.equals(checkTekrary)){
                            counter++;
                            if (counter == 2){
                                check1 = false;
                                data.remove(i);
                                break;
                            }
                        }
                    }
                    if (check1){
                        Controller.getInstance().addDarkhastTosieName(asatid1.get(asatid.getSelectedIndex()).getId());
                        Controller.getInstance().addDarkhastToseiNameDaneshjoo(checkTekrary);
                    }
                    String data1[][]= data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
                    jTable = new JTable(data1,columns);
                    jScrollPane = new JScrollPane(jTable);
                    jScrollPane.setBounds(50,200,600,400);
                    jScrollPane.repaint();
                    jScrollPane.revalidate();
                    add(jScrollPane);
                    repaint();
                    revalidate();


            }
        });
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Controller.getInstance().getDarkhatTosieNameDaneshjoo().isEmpty()){
                    if (!(jScrollPane==null)){
                        remove(jScrollPane);
                    }
                    repaint();
                    revalidate();
                    String data1[][] = Controller.getInstance().getDarkhatTosieNameDaneshjoo().stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
                    jTable = new JTable(data1,columns);
                    jScrollPane = new JScrollPane(jTable);
                    jScrollPane.setBounds(50,200,600,400);
                    jScrollPane.repaint();
                    jScrollPane.revalidate();
                    add(jScrollPane);
                    repaint();
                    revalidate();
                }
                else {
                    jOptionPane.showMessageDialog(GuiController.getFrame(),"TARIKHCHE NADARID");
                }
            }
        });
    }

}

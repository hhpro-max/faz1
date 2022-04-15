package GUI;

import LOGIC.DaneshKade;
import LOGIC.Dars;
import LOGIC.MaghtaDars;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SafheDoros extends JPanel {
    static final Logger logger = LogManager.getLogger(SafheDoros.class);

    JComboBox<DaneshKade> daneshKadeha;
    JLabel daneshkade1;

    JCheckBox maghtaDars;
    JComboBox<MaghtaDars> maghtaDarsha;
    JLabel maghtadars1;

    JCheckBox ostad;
    JTextField nameOstad;
    JLabel nameOstad1;

    JButton namayesh;

    JOptionPane jOptionPane;

    JTable dorosTable;

    JScrollPane sp;

    String ostadName;
    MaghtaDars maghtaInDars;
    DaneshKade daneshKadeDars;

    public SafheDoros(){
        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");
        initDorosPanel();
        initcomps();
        align();
        setActionListener();

        GuiController.getInstance().addJpannel(this);
    }
    public void initDorosPanel(){


        this.setBounds(0,30,800,770);
        this.setVisible(true);
        this.setLayout(null);


        logger.info("safhe Doros sakhte shod");

    }


    public void initcomps(){
        daneshKadeha = new JComboBox<>(DaneshKade.values());
        daneshkade1 = new JLabel("ENTEKHAB DANESHKADE : ");

        maghtaDarsha = new JComboBox<>(MaghtaDars.values());
        maghtaDars=new JCheckBox();
        maghtadars1=new JLabel("MAGHTA DARS : ");

        ostad = new JCheckBox();
        nameOstad=new JTextField();
        nameOstad1 = new JLabel("NAME OSTAD : ");

        namayesh=new JButton("NAMAYESH");

        jOptionPane=new JOptionPane();

        dorosTable = null;
        sp=null;
        ostadName=null;
        maghtaInDars=null;
        daneshKadeDars=null;
    }


    public void align(){
        maghtaDars.setBounds(5,55,20,20);
        this.add(maghtaDars);
        maghtadars1.setBounds(30,50,100,30);
        this.add(maghtadars1);
        maghtaDarsha.setBounds(150,50,100,30);
        this.add(maghtaDarsha);

        ostad.setBounds(5,100,20,20);
        this.add(ostad);
        nameOstad1.setBounds(30,95,100,30);
        this.add(nameOstad1);
        nameOstad.setBounds(150,95,100,30);
        this.add(nameOstad);

        daneshkade1.setBounds(300,70,200,30);
        this.add(daneshkade1);
        daneshKadeha.setBounds(450,70,100,30);
        this.add(daneshKadeha);

        namayesh.setBounds(570,70,100,30);
        this.add(namayesh);

    }

    public void setActionListener(){
        namayesh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(sp==null)){
                    remove(sp);
                }

                repaint();
                revalidate();
                daneshKadeDars = daneshKadeha.getItemAt(daneshKadeha.getSelectedIndex());
                if (maghtaDars.isSelected()){
                    maghtaInDars = maghtaDarsha.getItemAt(maghtaDarsha.getSelectedIndex());
                }else {
                    maghtaInDars=null;
                }
                if (ostad.isSelected() && !nameOstad.getText().isEmpty()){
                    ostadName = nameOstad.getText();
                }
                else {
                    ostadName=null;
                }
                int j = 0;
                if (ostadName == null && maghtaInDars == null){
                    ArrayList<ArrayList<String>> etelat = new ArrayList<>();
                    for (Dars i:
                         Dars.getDoros()) {
                        if (i.getDaneshkade().equals(daneshKadeDars)){
                            etelat.add(new ArrayList<>());
                            etelat.get(j).add(i.getId());
                            etelat.get(j).add(i.getName());
                            etelat.get(j).add(i.getPishniaz());
                            etelat.get(j).add(i.getOstad().getName());
                            etelat.get(j).add(i.getTedadVahed());
                            etelat.get(j).add(String.valueOf(i.getZarfiat()));
                            j++;
                        }

                    }
                    String colomns[] = {"ID","NAME","PISHNIAZ","OSTAD","VAHED","ZARFIAT"};
                    String rows[][] = etelat.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

                    dorosTable = new JTable(rows,colomns);


                }
                else if (!(ostadName == null) && maghtaInDars == null){
                    ArrayList<ArrayList<String>> etelat = new ArrayList<>();
                    for (Dars i:
                            Dars.getDoros()) {
                        if (i.getDaneshkade().equals(daneshKadeDars) && i.getOstad().getName().equals(ostadName)){
                            etelat.add(new ArrayList<>());
                            etelat.get(j).add(i.getId());
                            etelat.get(j).add(i.getName());
                            etelat.get(j).add(i.getPishniaz());
                            etelat.get(j).add(i.getOstad().getName());
                            etelat.get(j).add(i.getTedadVahed());
                            etelat.get(j).add(String.valueOf(i.getZarfiat()));
                            j++;
                        }



                    }
                    String colomns[] = {"ID","NAME","PISHNIAZ","OSTAD","VAHED","ZARFIAT"};
                    String rows[][] = etelat.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

                    dorosTable = new JTable(rows,colomns);

                }else if (ostadName == null && !(maghtaInDars == null)){
                    ArrayList<ArrayList<String>> etelat = new ArrayList<>();
                    for (Dars i:
                            Dars.getDoros()) {
                        if (i.getDaneshkade().equals(daneshKadeDars) && i.getMaghtaDars().equals(maghtaInDars)){
                            etelat.add(new ArrayList<>());
                            etelat.get(j).add(i.getId());
                            etelat.get(j).add(i.getName());
                            etelat.get(j).add(i.getPishniaz());
                            etelat.get(j).add(i.getOstad().getName());
                            etelat.get(j).add(i.getTedadVahed());
                            etelat.get(j).add(String.valueOf(i.getZarfiat()));
                            j++;
                        }



                    }
                    String colomns[] = {"ID","NAME","PISHNIAZ","OSTAD","VAHED","ZARFIAT"};
                    String rows[][] = etelat.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

                    dorosTable = new JTable(rows,colomns);

                }else if (!(ostadName == null) && !(maghtaInDars == null)){
                    ArrayList<ArrayList<String>> etelat = new ArrayList<>();
                    for (Dars i:
                            Dars.getDoros()) {
                        if (i.getDaneshkade().equals(daneshKadeDars) && i.getOstad().getName().equals(ostadName) && i.getMaghtaDars().equals(maghtaInDars)){
                            etelat.add(new ArrayList<>());
                            etelat.get(j).add(i.getId());
                            etelat.get(j).add(i.getName());
                            etelat.get(j).add(i.getPishniaz());
                            etelat.get(j).add(i.getOstad().getName());
                            etelat.get(j).add(i.getTedadVahed());
                            etelat.get(j).add(String.valueOf(i.getZarfiat()));
                            j++;
                        }



                    }
                    String colomns[] = {"ID","NAME","PISHNIAZ","OSTAD","VAHED","ZARFIAT"};
                    String rows[][] = etelat.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

                    dorosTable = new JTable(rows,colomns);

                }
                sp = new JScrollPane(dorosTable);
                sp.setBounds(50,200,600,400);
                sp.repaint();
                sp.revalidate();
                add(sp);
                repaint();
                revalidate();

            }
        });
    }
}


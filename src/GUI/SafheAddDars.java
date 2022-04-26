package GUI;

import LOGIC.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SafheAddDars extends JPanel {
    static final Logger logger = LogManager.getLogger(SafheAddDars.class);


        JTextField id,name,pishniaz,ostad,tedadVahed,zarfiat,saatClass,zamanPayanterm;
        JComboBox<DaneshKade> daneshkade;
        JComboBox<MaghtaDars> maghtaDars;
        JComboBox<RoozayeHafte> roozAval;
        JComboBox<RoozayeHafte> roozDovom;
        JButton virayesh,sabt;
        JLabel id1,name1,pishniaz1,ostad1,daneshkade1,tedadVahed1,maghtaDars1,zarfiat1,saatClass1,zamanPayanterm1,zamanPayanterm2;
        JOptionPane jOptionPane;

        public SafheAddDars(){
            PropertyConfigurator.configure("src/EDUFILES/log4j.properties");
            initAddDarsPanel();
            initComps();
            align();
            setActionListener();
            GuiController.getInstance().addJpannel(this);
        }

        public void initAddDarsPanel(){
            this.setBounds(0,30,800,770);
            this.setVisible(true);
            this.setLayout(null);


            logger.info("safhe addDars sakhte shod");
        }

        public void initComps(){
            id = new JTextField();
            id1 = new JLabel("ID DARS :");
            name = new JTextField();
            name1 = new JLabel("NAME DARS :");
            pishniaz = new JTextField();
            pishniaz1 = new JLabel("ID PISHNIAZ :");
            ostad = new JTextField();
            ostad1= new JLabel("ID OSTAD :");
            tedadVahed = new JTextField();
            tedadVahed1 = new JLabel("TEDAD VAHED :");
            zarfiat = new JTextField();
            zarfiat1 = new JLabel("ZARFIAT DARS :");
            daneshkade = new JComboBox<>(DaneshKade.values());
            daneshkade1 = new JLabel("DANESHKADE DARS :");
            maghtaDars = new JComboBox<>(MaghtaDars.values());
            maghtaDars1 = new JLabel("MAGHTA DARS :");
            virayesh = new JButton("VIRAYESH");
            sabt = new JButton("SABT");
            jOptionPane = new JOptionPane();
            saatClass = new JTextField();
            saatClass1 = new JLabel("SAAT CLASS :");
            zamanPayanterm = new JTextField();
            zamanPayanterm1 = new JLabel("TARIKH PAYANTERM :");
            zamanPayanterm2 = new JLabel("NEMONE : 1401 12 10");
            roozAval = new JComboBox<>(RoozayeHafte.values());
            roozDovom = new JComboBox<>(RoozayeHafte.values());

        }
        public void align(){
            id1.setBounds(0,70,100,30);
            this.add(id1);
            id.setBounds(150,70,150,30);
            this.add(id);
            pishniaz1.setBounds(0,120,100,30);
            this.add(pishniaz1);
            pishniaz.setBounds(150,120,150,30);
            this.add(pishniaz);
            name1.setBounds(0,170,100,30);
            this.add(name1);
            name.setBounds(150,170,150,30);
            this.add(name);
            ostad1.setBounds(0,220,100,30);
            this.add(ostad1);
            ostad.setBounds(150,220,150,30);
            this.add(ostad);
            tedadVahed1.setBounds(0,270,100,30);
            this.add(tedadVahed1);
            tedadVahed.setBounds(150,270,150,30);
            this.add(tedadVahed);
            zarfiat1.setBounds(0,320,100,30);
            this.add(zarfiat1);
            zarfiat.setBounds(150,320,150,30);
            this.add(zarfiat);
            daneshkade1.setBounds(0,370,150,30);
            this.add(daneshkade1);
            daneshkade.setBounds(150,370,150,30);
            this.add(daneshkade);
            maghtaDars1.setBounds(0,420,100,30);
            this.add(maghtaDars1);
            maghtaDars.setBounds(150,420,150,30);
            this.add(maghtaDars);
            roozAval.setBounds(150,470,150,30);
            this.add(roozAval);
            roozDovom.setBounds(150,520,150,30);
            this.add(roozDovom);
            saatClass1.setBounds(350,70,200,30);
            this.add(saatClass1);
            saatClass.setBounds(550,70,200,30);
            this.add(saatClass);
            zamanPayanterm1.setBounds(350,120,200,30);
            this.add(zamanPayanterm1);
            zamanPayanterm.setBounds(550,120,200,30);
            this.add(zamanPayanterm);
            zamanPayanterm2.setBounds(550,160,200,30);
            this.add(zamanPayanterm2);

            sabt.setBounds(500,500,150,30);
            this.add(sabt);


            virayesh.setBounds(300,500,150,30);
            this.add(virayesh);

        }
        public void setActionListener(){
            sabt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (id.getText().isEmpty() || name.getText().isEmpty() || ostad.getText().isEmpty()){
                        jOptionPane.showMessageDialog(GuiController.getFrame(),"FIELD HAYE ID , NAME VA OSTAD EJBARY HASTAND");
                    }
                    else {
                        String idDars = id.getText();
                        String nameDars = name.getText();
                        String pishNiazDars = pishniaz.getText();
                        Ostad ostadDars = null;
                        ArrayList<RoozayeHafte> roozayeHaftes = new ArrayList<>();
                        roozayeHaftes.add(roozAval.getItemAt(roozAval.getSelectedIndex()));
                        roozayeHaftes.add(roozDovom.getItemAt(roozDovom.getSelectedIndex()));

                        boolean a = Controller.getInstance().checkOstad(ostad.getText());
                        if (a){
                            ostadDars = Controller.controller.getOstad(ostad.getText());
                        }
                        else {
                            jOptionPane.showMessageDialog(GuiController.getFrame(),"OSTAD DARS MOJOOD NIST");
                            return;
                        }
                        DaneshKade daneshKadeDars = daneshkade.getItemAt(daneshkade.getSelectedIndex());
                        String tedadVahedDars = tedadVahed.getText();
                        MaghtaDars maghtaInDars = maghtaDars.getItemAt(maghtaDars.getSelectedIndex());
                        String zarfiatDars = "NADARAD";
                        if (!zarfiat.getText().isEmpty()) {
                            zarfiatDars =zarfiat.getText();
                        }else {
                            zarfiatDars = "0";
                        }
                        try {
                            boolean b = Controller.getInstance().addDars(idDars,nameDars,pishNiazDars,ostadDars,daneshKadeDars,tedadVahedDars,maghtaInDars,zarfiatDars,roozayeHaftes,saatClass.getText(),zamanPayanterm.getText());
                            if (b) {
                                JOptionPane.showMessageDialog(GuiController.getFrame(), "Dars Sakhte SHod");
                            }
                            else {
                                JOptionPane.showMessageDialog(GuiController.getFrame(), "NASHOD KE BESHE");
                            }
                        }catch (Exception e1){
                            logger.error("Khata dar AddDars : " + e1.getMessage() );
                        }
                    }
                }
            });
            virayesh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (id.getText().isEmpty()){
                        jOptionPane.showMessageDialog(GuiController.getFrame(),"FIELD ID EJBARIST");
                    }
                    else {
                        String idDars = id.getText();
                        String nameDars = name.getText();
                        String pishNiazDars = pishniaz.getText();
                        Ostad ostadDars = null;
                        boolean a = Controller.getInstance().checkOstad(ostad.getText());
                        if (a){
                            ostadDars = Controller.controller.getOstad(ostad.getText());
                        }
                        DaneshKade daneshKadeDars = daneshkade.getItemAt(daneshkade.getSelectedIndex());
                        String tedadVahedDars = tedadVahed.getText();
                        MaghtaDars maghtaInDars = maghtaDars.getItemAt(maghtaDars.getSelectedIndex());
                        String zarfiatDars = "";
                        if (!zarfiat.getText().isEmpty()) {
                            zarfiatDars =zarfiat.getText();
                        }
                        try {
                            boolean b = Controller.getInstance().virayeshDars(idDars,nameDars,pishNiazDars,ostadDars,daneshKadeDars,tedadVahedDars,maghtaInDars,zarfiatDars);
                            if(b) {
                                JOptionPane.showMessageDialog(GuiController.getFrame(), "Dars VIRAYESH SHod");
                            }
                            else {
                                jOptionPane.showMessageDialog(GuiController.getFrame(),"NASHOD KE BESHE");
                            }
                        }catch (Exception e1){
                            logger.error("Khata dar VirayeshDars : " + e1.getMessage() );
                        }
                    }
                }

            });
        }
}

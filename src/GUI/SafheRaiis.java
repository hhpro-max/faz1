package GUI;

import LOGIC.Controller;
import LOGIC.Ostad;
import LOGIC.RaiisDaneshkade;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafheRaiis extends SafheMoaven {

    JTextField hazfOsdat1;
    JButton hazfOstad;

    JButton virayeshVaEzafe;

    JButton upGradeOstad;



    JOptionPane jOptionPane;

    public SafheRaiis() {
        super();
        initEzafia();
        setActionListeneer();
    }
    public void initEzafia(){
        hazfOsdat1 = new JTextField();
        hazfOstad = new JButton("HAZF OSTAD");
        jOptionPane = new JOptionPane();

        upGradeOstad = new JButton("UGRADE TO MOAVEN");

        virayeshVaEzafe = new JButton("VIRAYESH VA EZAFE");
    }
    public void setActionListeneer(){
        for (ActionListener i : listAsatid.getActionListeners()){
            listAsatid.removeActionListener(i);
        }
        listAsatid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheListAsatid=new SafheListAsatid();
                hazfOsdat1.setBounds(150,50,150,30);
                safheListAsatid.add(hazfOsdat1);
                hazfOstad.setBounds(350,50,150,30);
                safheListAsatid.add(hazfOstad);
                virayeshVaEzafe.setBounds(250,100,200,30);
                safheListAsatid.add(virayeshVaEzafe);
                upGradeOstad.setBounds(550,50,200,30);
                safheListAsatid.add(upGradeOstad);

                add(safheListAsatid,1);
                logger.info("enter to the listAsatid");
                repaint();
                revalidate();
            }
        });
        virayeshVaEzafe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheAddOstad = new SafheAddOstad();
                add(safheAddOstad,1);
                logger.info("enter to the addOstad");
                repaint();
                revalidate();
            }
        });
        hazfOstad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean validDelete = false;
                if (hazfOsdat1.getText().isEmpty()){
                    jOptionPane.showMessageDialog(GuiController.getFrame(),"ID RA VARED KONID");
                }else {
                    String idOstad = hazfOsdat1.getText();


                    validDelete = Controller.getInstance().removeOstad(idOstad);

                    if (validDelete){
                        jOptionPane.showMessageDialog(GuiController.getFrame(),"karbar ba id :"+ idOstad + "hazfshod");
                    }else {
                        jOptionPane.showMessageDialog(GuiController.getFrame(),"ID IS WRONG");
                    }

                }
            }
        });
        upGradeOstad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean validUpgrade = false;
                if (hazfOsdat1.getText().isEmpty()) {
                    jOptionPane.showMessageDialog(GuiController.getFrame(), "ID RA VARED KONID");
                } else {
                    String idOstad = hazfOsdat1.getText();


                    validUpgrade = Controller.getInstance().upGradeOstad(idOstad);

                    if (validUpgrade) {
                        jOptionPane.showMessageDialog(GuiController.getFrame(), "karbar ba id :" + idOstad + "UpGradeshod");
                    } else {
                        jOptionPane.showMessageDialog(GuiController.getFrame(), "ID IS WRONG or MOAVEN DARIM");
                    }

                }
            }


        });

    }
}

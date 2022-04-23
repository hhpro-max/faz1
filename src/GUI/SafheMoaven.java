package GUI;

import LOGIC.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafheMoaven extends SafheOstad {
    SafheAddDaneshjoo safheAddDaneshjoo;
    SafheAddOstad safheAddOstad;
    JMenu sabtkarbar;
    JMenuItem addDaneshjoo;
    JMenuItem addOstad;
    JMenuItem checkMinor;
    JMenuItem checkEnserafi;
    JMenuItem checkNomarat;
    SafheDoros safheDoros;
    JButton sabtVavirayesh, deleteDars;
    JTextField deleteDars1;
    JOptionPane jOptionPane;
    SafheAddDars safheAddDars;
    SafheCheckMinor safheCheckMinor;
    SafheCheckEnserafia safheCheckEnserafia;
    SafheNomaratMovaghatMoaven safheNomaratMovaghatMoaven;


    public SafheMoaven() {
        super();
        initEzafi();
        this.setActionListenerr4();
    }

    public void initEzafi() {
        sabtkarbar = new JMenu("SABT KARBAR");
        addDaneshjoo = new JMenuItem("Daneshjoo");
        checkMinor = new JMenuItem("DARKHASTHAYE MINOR");
        checkEnserafi = new JMenuItem("DARKHASTHAYE ENSERAF");
        addOstad = new JMenuItem("Ostad");
        sabtVavirayesh = new JButton("SABT VA VIRAYESH");
        checkNomarat = new JMenuItem("CHECK NOMARAT");
        deleteDars = new JButton("HAZF DARS");
        deleteDars1 = new JTextField();
        jOptionPane = new JOptionPane();
        darkhastha.add(checkMinor);
        omoorKarname.add(checkNomarat);
        darkhastha.add(checkEnserafi);
        sabtkarbar.add(addOstad);
        sabtkarbar.add(addDaneshjoo);
        jMenuBar.add(sabtkarbar);


    }

    public void setActionListenerr4() {
        for (ActionListener i :
                listDoros.getActionListeners()) {
            listDoros.removeActionListener(i);
        }
        deleteDars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!deleteDars1.getText().isEmpty()) {
                    String id = deleteDars1.getText();
                    boolean a = Controller.getInstance().hazfDars(id);
                    if (a) {
                        jOptionPane.showMessageDialog(GuiController.getFrame(), "DARS BA ID :" + id + " HAZF SHOD");
                    } else {
                        jOptionPane.showMessageDialog(GuiController.getFrame(), "ID IS WRONG or NOT EXIST");
                    }
                } else {
                    jOptionPane.showMessageDialog(GuiController.getFrame(), "ID RA VARED KONID");
                }
            }
        });
        sabtVavirayesh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheAddDars = new SafheAddDars();
                add(safheAddDars, 1);
                logger.info("VOROOD BE ADDDARSPAGE");
                repaint();
                revalidate();
            }
        });
        listDoros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheDoros = new SafheDoros();
                deleteDars1.setBounds(50, 150, 150, 30);
                safheDoros.add(deleteDars1);
                deleteDars.setBounds(250, 150, 150, 30);
                safheDoros.add(deleteDars);
                sabtVavirayesh.setBounds(450, 150, 200, 30);
                safheDoros.add(sabtVavirayesh);

                add(safheDoros, 1);
                logger.info("enter to the safheDoros");
                repaint();
                revalidate();
            }
        });
        addDaneshjoo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheAddDaneshjoo = new SafheAddDaneshjoo();
                add(safheAddDaneshjoo, 1);

                logger.info("zirmenu adduDaneshjoo");

                repaint();
                revalidate();
            }
        });
        addOstad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheAddOstad = new SafheAddOstad();
                add(safheAddOstad, 1);
                logger.info("enter to the addOstad");
                repaint();
                revalidate();
            }
        });
        checkMinor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheCheckMinor = new SafheCheckMinor();
                add(safheCheckMinor, 1);
                repaint();
                revalidate();
            }
        });
        checkEnserafi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheCheckEnserafia = new SafheCheckEnserafia();
                add(safheCheckEnserafia, 1);
                repaint();
                revalidate();
            }
        });
        checkNomarat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheNomaratMovaghatMoaven = new SafheNomaratMovaghatMoaven();
                add(safheNomaratMovaghatMoaven,1);
                repaint();
                revalidate();
            }
        });
    }
}

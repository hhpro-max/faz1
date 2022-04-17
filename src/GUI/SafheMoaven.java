package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafheMoaven extends SafheOstad{
    SafheAddDaneshjoo safheAddDaneshjoo;
    SafheAddOstad safheAddOstad;
    JMenu sabtkarbar;
    JMenuItem addDaneshjoo;
    JMenuItem addOstad;
    SafheDoros safheDoros;
    JButton sabtVavirayesh,deleteDars;
    JTextField deleteDars1;


    public SafheMoaven(){
        super();
        initEzafi();
        this.setActionListenerr4();
    }
    public void initEzafi(){
        sabtkarbar = new JMenu("SABT KARBAR");
        addDaneshjoo = new JMenuItem("Daneshjoo");
        addOstad = new JMenuItem("Ostad");
        sabtVavirayesh = new JButton("SABT VA VIRAYESH");
        deleteDars = new JButton("HAZF DARS");
        deleteDars1 = new JTextField();

        sabtkarbar.add(addOstad);
        sabtkarbar.add(addDaneshjoo);
        jMenuBar.add(sabtkarbar);


    }
    public void setActionListenerr4(){
        for (ActionListener i:
             listDoros.getActionListeners()) {
            listDoros.removeActionListener(i);
        }
        listDoros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheDoros = new SafheDoros();
                deleteDars1.setBounds(50,150,150,30);
                safheDoros.add(deleteDars1);
                deleteDars.setBounds(250,150,150,30);
                safheDoros.add(deleteDars);
                sabtVavirayesh.setBounds(450,150,200,30);
                safheDoros.add(sabtVavirayesh);

                add(safheDoros,1);
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
                add(safheAddDaneshjoo,1);

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
                add(safheAddOstad,1);
                logger.info("enter to the addOstad");
                repaint();
                revalidate();
            }
        });
    }
}

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


    public SafheMoaven(){
        super();
        initEzafi();
        this.setAction();
    }
    public void initEzafi(){
        sabtkarbar = new JMenu("SABT KARBAR");
        addDaneshjoo = new JMenuItem("Daneshjoo");
        addOstad = new JMenuItem("Ostad");
        sabtkarbar.add(addOstad);
        sabtkarbar.add(addDaneshjoo);
        jMenuBar.add(sabtkarbar);


    }
    public void setAction(){
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

package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafheMoaven extends SafheOstad{
    SafheAddDaneshjoo safheAddDaneshjoo;
    JMenu sabtkarbar;
    JMenuItem addDaneshjoo;

    public SafheMoaven(){
        super();
        initEzafi();
        this.setAction();
    }
    public void initEzafi(){
        sabtkarbar = new JMenu("SABT KARBAR");
        addDaneshjoo = new JMenuItem("Daneshjoo");
        sabtkarbar.add(addDaneshjoo);
        jMenuBar.add(sabtkarbar);

    }
    public void setAction(){
        addDaneshjoo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                safheAddDaneshjoo = new SafheAddDaneshjoo();
                add(safheAddDaneshjoo,1);

                logger.info("zirmenu adduser");

                repaint();
                revalidate();
            }
        });
    }
}

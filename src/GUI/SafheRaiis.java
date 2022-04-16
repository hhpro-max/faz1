package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafheRaiis extends SafheMoaven {

    JLabel test;

    public SafheRaiis() {
        super();
        initEzafia();
        setActionListeneer();
    }
    public void initEzafia(){
        test = new JLabel("TEST");
    }
    public void setActionListeneer(){
        listAsatid.removeActionListener(listAsatid.getActionListeners());
        listAsatid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheListAsatid=new SafheListAsatid();
                test.setBounds(200,200,100,30);
                safheListAsatid.add(test,1);
                add(safheListAsatid,1);
                logger.info("enter to the listAsatid");
                repaint();
                revalidate();
            }
        });
    }
}

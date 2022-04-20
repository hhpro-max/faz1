package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafheDaneshjooArshad extends SafheDaneshjoo{
    public JMenuItem darkhastKhabGah;
    public SafheDarkhastKhabGah safheDarkhastKhabGah;

    public SafheDaneshjooArshad(){
        super();
        initezafia1();
        setActionListener6();
    }
    public void initezafia1(){
        darkhastKhabGah=new JMenuItem("DARKHAST KHAB GAH");
        khadamatAmoozeshi.remove(darkhastMinor);
        khadamatAmoozeshi.add(darkhastKhabGah);

    }
    public void setActionListener6(){
        darkhastKhabGah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheDarkhastKhabGah = new SafheDarkhastKhabGah();
                add(safheDarkhastKhabGah,1);
                repaint();
                revalidate();
            }
        });
    }
}

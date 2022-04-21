package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafheDaneshjooDoctora extends SafheDaneshjoo{
    public JMenuItem nobatDefa;
    public SafheNobatDefaAzPayanName safheNobatDefaAzPayanName;


    public SafheDaneshjooDoctora(){
        super();
        initEzafia1();
        setActionlistener1();
    }
    public void initEzafia1(){
        nobatDefa = new JMenuItem("DARKHAST NOBAT DEFA");
        darKhastha.add(nobatDefa);
        darKhastha.remove(darkhastMinor);
        darKhastha.remove(darkhastTosiename);
    }
    public void setActionlistener1(){
        nobatDefa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                if (safheNobatDefaAzPayanName == null) {
                    safheNobatDefaAzPayanName = new SafheNobatDefaAzPayanName();
                }else {
                    safheNobatDefaAzPayanName.setVisible(true);
                }
                add(safheNobatDefaAzPayanName,1);
                repaint();
                revalidate();

            }
        });
    }
}

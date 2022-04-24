package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class SafheNobatDefaAzPayanName extends JPanel {
    Date date;
    JButton jButton;
    JLabel jLabel;
    int day;
    int month;
    int year;

    public SafheNobatDefaAzPayanName(){
        initPanel();
        initCopms();
        align1();
        setActionListener1();

        GuiController.getInstance().addJpannel(this);
    }


    public void initPanel(){
        this.setBounds(0,30,800,770);
        this.setVisible(true);
        this.setLayout(null);
    }
    public void initCopms(){
        date = new Date();
        jButton = new JButton("SABT DARKHAST DEFA");
        day = date.getDate();
        month = date.getMonth() + 1;
        year = date.getYear();
        if (month > 12){
          month =  0;
          year = year + 1;
        }
        jLabel = null;



    }
    public void align1(){
        jButton.setBounds(10,50,200,30);
        this.add(jButton);
    }
    public void setActionListener1(){
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jLabel == null) {
                    jLabel = new JLabel("TARIKH NOBAT DEFA SHOMA : " + year + " / " + month + " / " + day);

                    jLabel.setBounds(30, 100, 400, 30);
                    add(jLabel);
                    repaint();
                    revalidate();
                }

            }
        });
    }
}

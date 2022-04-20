package GUI;

import LOGIC.Controller;
import LOGIC.Daneshjoo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;
import java.util.Date;

public class SafheGovahiEshteghalBetahsil extends JPanel {
    static final Logger logger = LogManager.getLogger(SafheGovahiEshteghalBetahsil.class);
    JTextArea jTextArea;
    String matnGovahi;
    JButton jButton;
    Date date;

    public SafheGovahiEshteghalBetahsil() {
        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");
        initSafheDarkhastGovahi();
        initComps();
        align1();
        setActionListener();
        GuiController.getInstance().addJpannel(this);
    }

    public void initSafheDarkhastGovahi() {


        this.setBounds(0, 30, 800, 770);
        this.setVisible(true);
        this.setLayout(null);


    }

    public void initComps() {
        Daneshjoo daneshjoo = Controller.getInstance().getDaneshjoo();
        date = new Date();
        jButton = new JButton("NAMAYESH DARKHAST");
        int day = date.getDate();
        int month = date.getMonth();
        int year = date.getYear();
        String tarikhSodor = year + "/" + month + "/" + day;
        String matnGovahi1 = "GOVAHI MISHAVAD KE AGHA/KHANOM % BE SHOMARE DANESHJOOEE * MASHGHOOL BE TAHSIL DAR RESHTE $ \n DARDANESHGAH SANATI SHARIF AST TARIKH SODOR GOVAHI : =";
        try {

            String matngovahi2 = matnGovahi1.replace("%", daneshjoo.getName());
            String matngovai3 = matngovahi2.replace("*", daneshjoo.getId());
            String matngovvahi4 = matngovai3.replace("$", daneshjoo.getDaneshKade().toString());
            matnGovahi = matngovvahi4.replace("=", tarikhSodor);
        } catch (Exception e) {
            logger.warn("error is :" + e.getMessage());
        }

    }

    public void align1() {
        jButton.setBounds(10, 50, 200, 30);
        this.add(jButton);
    }

    public void setActionListener() {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea = new JTextArea(matnGovahi);
                jTextArea.setBounds(20, 100, 700, 200);
                add(jTextArea);
                repaint();
                revalidate();
            }
        });
    }

}

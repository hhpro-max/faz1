package GUI;

import LOGIC.Controller;
import LOGIC.Daneshjoo;
import LOGIC.GetVaziatTahsili;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafheDaneshjoo extends SafheAsli {
    static final Logger logger = LogManager.getLogger(SafheDaneshjoo.class);

    public JTable vaZiatAmoozeshi;
    public JLabel showVaziat;
    public JMenuBar jMenuBar;


    public JMenu omoorSabtnam;
    public JMenu khadamatAmoozeshi;
    public JMenu omoorKarname;
    public JMenu profileKarbar;
    public JButton safheAsli;
    public JMenuItem listDoros;
    public JMenuItem listAsatid;

    public SafheDoros safheDoros;

    SafheListAsatid safheListAsatid;

    public SafheDaneshjoo() {

        super();
        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");

        initTable();
        initmenubar();
        setActionListener4();
    }

    public void initTable() {
        logger.info("table being initializing");
        showVaziat = new JLabel("VAZAIAT AMOOZASHI");
        showVaziat.setBounds(200,170,250,30);
        this.add(showVaziat);
        Daneshjoo daneshjoo = (Daneshjoo) Controller.getInstance().getAzayeDaneshgah();
        String vaziatTahsili = GetVaziatTahsili.getInstance().getVaziatTahsili(daneshjoo.getVazittahsily());
        String ostadRahnama = daneshjoo.getOstadRahnama().getName();
        String mojavezSabtnam = "NAMALOOM";
        if (daneshjoo.isMojavezSabtnam()) {
            mojavezSabtnam = "MOJAZ BE SABTNAM";
        } else {
            mojavezSabtnam = "MOJAZ NISTI";
        }
        String saatSabtnam = daneshjoo.getSaatSabtnam();


        String data[][] = {
                {"VazitTahsili :", vaziatTahsili},
                {"Ostad Rahnama :",ostadRahnama},
                {"Mojavez sabnam :",mojavezSabtnam},
                {"Saat Sabtnam :",saatSabtnam}
        };
        
        String column[] = {"VAZIAT AMOOZESHI","_"};
        vaZiatAmoozeshi = new JTable(data,column);
        vaZiatAmoozeshi.setBounds(200,200,500,70);
        JScrollPane jScrollPane = new JScrollPane(vaZiatAmoozeshi);
        this.add(vaZiatAmoozeshi);


        logger.info("initializing table has finished");
    }
    public void initmenubar(){

        jMenuBar = new JMenuBar();
        jMenuBar.setBounds(80,0,720,30);
        omoorSabtnam = new JMenu("OMOOR SABTNAM");
        listAsatid = new JMenuItem("Asatid");
        listDoros=new JMenuItem("Doros");
        omoorSabtnam.add(listDoros);
        omoorSabtnam.add(listAsatid);
        omoorKarname = new JMenu("OMOOR KARNAME");
        khadamatAmoozeshi = new JMenu("KHADAMAT AMOOZESHI");
        profileKarbar = new JMenu("PROFILE");
        safheAsli = new JButton("SAFHE ASLI");
        safheAsli.setBounds(680,0,100,30);
        this.add(safheAsli);
        jMenuBar.add(omoorKarname);
        jMenuBar.add(khadamatAmoozeshi);
        jMenuBar.add(profileKarbar);
        jMenuBar.add(omoorSabtnam);
        this.add(jMenuBar);

    }
    public void setActionListener4(){
        safheAsli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
            }
        });


        listDoros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheDoros=new SafheDoros();
                add(safheDoros,1);
                logger.info("enter to the listdoros");
                repaint();
                revalidate();
            }
        });
        listAsatid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheListAsatid=new SafheListAsatid();
                add(safheListAsatid,1);
                logger.info("enter to the listAsatid");
                repaint();
                revalidate();
            }
        });

    }

}

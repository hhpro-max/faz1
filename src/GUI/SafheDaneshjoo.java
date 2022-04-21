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
    public JMenuItem barnameHaftegi;
    public JMenuItem listEmtehnat;
    public JMenu darKhastha;
    public JMenuItem darkhastGobahiEshteghal;
    public JMenuItem darkhastMinor;
    public JMenuItem darkhastenseraf;
    public JMenuItem darkhastTosiename;
    public JMenuItem nomaratMovaghat;

    public SafheDoros safheDoros;
    public  SafheBarnameHaftegi safheBarnameHaftegi;
    public SafheListEmtehanat safheListEmtehanat;
    public SafheDarkhastTosieName safheDarkhastTosieName;
    public SafheGovahiEshteghalBetahsil safheGovahiEshteghalBetahsil;
    public SafheDarkhastMinor safheDarkhastMinor;
    public SafheEnserafAzTahsil safheEnserafAzTahsil;
    public SafheNomaratMovaghatDaneshjoo safheNomaratMovaghatDaneshjoo;

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
        barnameHaftegi = new JMenuItem("BARNAME HAFTEGI");
        listEmtehnat = new JMenuItem("LIST EMTEHANAT");
        nomaratMovaghat = new JMenuItem("LIST NOMARAT MOVAGHAT");
        darKhastha = new JMenu("DARKHAT HA");
        darkhastenseraf = new JMenuItem("ENSERAF");
        darkhastMinor = new JMenuItem("MINOR");
        darkhastGobahiEshteghal = new JMenuItem("GOVAHI ESHTEGHAL");
        darkhastTosiename = new JMenuItem("DARKHAST TOSIENAME");
        darKhastha.add(darkhastenseraf);
        darKhastha.add(darkhastTosiename);
        darKhastha.add(darkhastMinor);
        darKhastha.add(darkhastGobahiEshteghal);
        listAsatid = new JMenuItem("Asatid");
        listDoros=new JMenuItem("Doros");
        omoorSabtnam.add(listDoros);
        omoorSabtnam.add(listAsatid);
        omoorKarname = new JMenu("OMOOR KARNAME");
        omoorKarname.add(nomaratMovaghat);
        khadamatAmoozeshi = new JMenu("KHADAMAT AMOOZESHI");
        profileKarbar = new JMenu("PROFILE");
        safheAsli = new JButton("SAFHE ASLI");
        khadamatAmoozeshi.add(barnameHaftegi);
        khadamatAmoozeshi.add(listEmtehnat);
        khadamatAmoozeshi.add(darKhastha);
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
        barnameHaftegi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheBarnameHaftegi = new SafheBarnameHaftegi();
                add(safheBarnameHaftegi,1);
                repaint();
                revalidate();
            }
        });
        listEmtehnat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheListEmtehanat = new SafheListEmtehanat();
                add(safheListEmtehanat,1);
                repaint();
                revalidate();
            }
        });
        darkhastTosiename.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                if (safheDarkhastTosieName == null) {
                    safheDarkhastTosieName = new SafheDarkhastTosieName();
                }
                else {
                    safheDarkhastTosieName.setVisible(true);
                }
                add(safheDarkhastTosieName,1);
                repaint();
                revalidate();
            }
        });
        darkhastGobahiEshteghal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheGovahiEshteghalBetahsil = new SafheGovahiEshteghalBetahsil();
                add(safheGovahiEshteghalBetahsil,1);
                repaint();
                revalidate();
            }
        });
        darkhastMinor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                if (safheDarkhastMinor == null) {
                    safheDarkhastMinor = new SafheDarkhastMinor();
                }else {
                    safheDarkhastMinor.setVisible(true);
                }
                add(safheDarkhastMinor,1);
                repaint();
                revalidate();
            }
        });
        darkhastenseraf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                if (safheEnserafAzTahsil == null) {
                    safheEnserafAzTahsil = new SafheEnserafAzTahsil();
                }else {
                    safheEnserafAzTahsil.setVisible(true);
                }
                add(safheEnserafAzTahsil,1);
                repaint();
                revalidate();

            }
        });
        nomaratMovaghat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheNomaratMovaghatDaneshjoo = new SafheNomaratMovaghatDaneshjoo();
                add(safheNomaratMovaghatDaneshjoo,1);
                repaint();
                revalidate();
            }
        });


    }

}

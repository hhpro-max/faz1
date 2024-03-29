package GUI;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafheOstad extends SafheAsli{
    static final Logger logger = LogManager.getLogger(SafheOstad.class);

    public JMenuBar jMenuBar;


    public JMenu omoorSabtnam;
    public JMenu khadamatAmoozeshi;
    public JMenu omoorKarname;
    public JMenu profileKarbar;
    public JButton safheAsli;
    public JMenuItem listDoros;
    public JMenuItem listAsatid;
    public JMenuItem barnameHaftegi;
    public JMenuItem listEmtehanat;
    public JMenu darkhastha;
    public JMenuItem darkhastHayeTosieName;
    public JMenuItem nomaratMovaghat;
    public JMenuItem profileKarbar1;

    SafheDoros safheDoros;
    SafheListAsatid safheListAsatid;
    public SafheBarnameHaftegi safheBarnameHaftegi;
    public SafheListEmtehanat safheListEmtehanat;
    public SafheCheckTosieNameOstad safheCheckTosieNameOstad;
    public SafheNomaratMovaghatOstad safheNomaratMovaghatOstad;
    public SafheProfileOstad safheProfileOstad;

    public SafheOstad(){
        super();
        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");


        initmenubar();
        setActionListener3();
    }
    public void initmenubar(){

        jMenuBar = new JMenuBar();
        jMenuBar.setBounds(80,0,720,30);
        omoorSabtnam = new JMenu("OMOOR SABTNAM");
        omoorKarname = new JMenu("OMOOR KARNAME");
        nomaratMovaghat = new JMenuItem("NOMARAT");
        darkhastHayeTosieName = new JMenuItem("DARKHASTHAYE TOSIENAME");
        khadamatAmoozeshi = new JMenu("KHADAMAT AMOOZESHI");
        profileKarbar1 = new JMenuItem("PROFILE");
        barnameHaftegi = new JMenuItem("BARNAME HAFTEGI");
        khadamatAmoozeshi.add(barnameHaftegi);
        listEmtehanat = new JMenuItem("EMTEHANAT");
        khadamatAmoozeshi.add(listEmtehanat);
        darkhastha = new JMenu("DARKHASTHA");
        darkhastha.add(darkhastHayeTosieName);
        khadamatAmoozeshi.add(darkhastha);
        profileKarbar = new JMenu("PROFILE");
        safheAsli = new JButton("SAFHE ASLI");
        listAsatid = new JMenuItem("Asatid");
        listDoros=new JMenuItem("Doros");
        omoorSabtnam.add(listDoros);
        omoorSabtnam.add(listAsatid);
        omoorKarname.add(nomaratMovaghat);
        profileKarbar.add(profileKarbar1);
        jMenuBar.add(omoorKarname);
        jMenuBar.add(khadamatAmoozeshi);
        jMenuBar.add(profileKarbar);
        jMenuBar.add(omoorSabtnam);
        safheAsli.setBounds(680,0,100,30);
        this.add(safheAsli);
        this.add(jMenuBar);

    }
    public void setActionListener3(){
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
                add(safheBarnameHaftegi ,1);
                repaint();
                revalidate();
            }
        });
        listEmtehanat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheListEmtehanat = new SafheListEmtehanat();
                add(safheListEmtehanat , 1);
                repaint();
                revalidate();
            }
        });
        darkhastHayeTosieName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheCheckTosieNameOstad = new SafheCheckTosieNameOstad();
                add(safheCheckTosieNameOstad,1);
                repaint();
                revalidate();
            }
        });
        nomaratMovaghat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheNomaratMovaghatOstad = new SafheNomaratMovaghatOstad();
                add(safheNomaratMovaghatOstad,1);
                repaint();
                revalidate();
            }
        });
        profileKarbar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiController.getInstance().resetJpanels();
                safheProfileOstad = new SafheProfileOstad();
                add(safheProfileOstad,1);
                repaint();
                revalidate();
            }
        });
    }


}

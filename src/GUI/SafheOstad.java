package GUI;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;

public class SafheOstad extends SafheAsli{
    static final Logger logger = LogManager.getLogger(SafheOstad.class);

    public JMenuBar jMenuBar;


    public JMenu omoorSabtnam;
    public JMenu khadamatAmoozeshi;
    public JMenu omoorKarname;
    public JMenu profileKarbar;
    public JMenu bazgasht;


    public SafheOstad(){
        super();
        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");


        initmenubar();
    }
    public void initmenubar(){

        jMenuBar = new JMenuBar();
        jMenuBar.setBounds(80,0,720,30);
        omoorSabtnam = new JMenu("OMOOR SABTNAM");
        omoorKarname = new JMenu("OMOOR KARNAME");
        khadamatAmoozeshi = new JMenu("KHADAMAT AMOOZESHI");
        profileKarbar = new JMenu("PROFILE");
        bazgasht = new JMenu("SAFHE ASLI");
        jMenuBar.add(bazgasht);
        jMenuBar.add(omoorKarname);
        jMenuBar.add(khadamatAmoozeshi);
        jMenuBar.add(profileKarbar);
        jMenuBar.add(omoorSabtnam);
        this.add(jMenuBar);

    }


}

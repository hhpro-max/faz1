package GUI;

import LOGIC.Controller;
import LOGIC.Daneshjoo;
import LOGIC.GetVaziatTahsili;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;

public class SafheDaneshjoo extends SafheAsli {
    static final Logger logger = LogManager.getLogger(SafheDaneshjoo.class);

    public JTable vaZiatAmoozeshi;
    public JLabel showVaziat;


    public SafheDaneshjoo() {

        super();
        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");

        initTable();
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

}

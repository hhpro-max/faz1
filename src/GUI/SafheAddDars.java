package GUI;

import LOGIC.DaneshKade;
import LOGIC.MaghtaDars;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;

public class SafheAddDars extends JPanel {
    static final Logger logger = LogManager.getLogger(SafheAddDars.class);


        JTextField id,name,pishniaz,ostad,tedadVahed,zarfiat;
        JComboBox<DaneshKade> daneshkade;
        JComboBox<MaghtaDars> maghtaDars;
        JButton virayesh,sabt;
        JLabel id1,name1,pishniaz1,ostad1,daneshkade1,tedadVahed1,maghtaDars1,zarfiat1;

        public SafheAddDars(){
            PropertyConfigurator.configure("src/EDUFILES/log4j.properties");
            initAddDarsPanel();
            initComps();
            align();

            GuiController.getInstance().addJpannel(this);
        }

        public void initAddDarsPanel(){
            this.setBounds(0,30,800,770);
            this.setVisible(true);
            this.setLayout(null);


            logger.info("safhe addDars sakhte shod");
        }

        public void initComps(){
            id = new JTextField();
            id1 = new JLabel("ID DARS :");
            name = new JTextField();
            name1 = new JLabel("NAME DARS :");
            pishniaz = new JTextField();
            pishniaz1 = new JLabel("ID PISHNIAZ :");
            ostad = new JTextField();
            ostad1= new JLabel("ID OSTAD :");
            tedadVahed = new JTextField();
            tedadVahed1 = new JLabel("TEDAD VAHED :");
            zarfiat = new JTextField();
            zarfiat1 = new JLabel("ZARFIAT DARS :");
            daneshkade = new JComboBox<>(DaneshKade.values());
            daneshkade1 = new JLabel("DANESHKADE DARS :");
            maghtaDars = new JComboBox<>(MaghtaDars.values());
            maghtaDars1 = new JLabel("MAGHTA DARS :");
            virayesh = new JButton("VIRAYESH");
            sabt = new JButton("SABT");

        }
        public void align(){
            id1.setBounds(0,70,50,30);
            this.add(id1);
            id.setBounds(150,70,150,30);
            this.add(id);
            pishniaz1.setBounds(0,120,100,30);
            this.add(pishniaz1);
            pishniaz.setBounds(150,120,150,30);
            this.add(pishniaz);
            name1.setBounds(0,170,100,30);
            this.add(name1);
            name.setBounds(150,170,150,30);
            this.add(name);
            ostad1.setBounds(0,220,100,30);
            this.add(ostad1);
            ostad.setBounds(150,220,150,30);
            this.add(ostad);
            tedadVahed1.setBounds(0,270,100,30);
            this.add(tedadVahed1);
            tedadVahed.setBounds(150,270,150,30);
            this.add(tedadVahed);
            zarfiat1.setBounds(0,320,100,30);
            this.add(zarfiat1);
            zarfiat.setBounds(150,320,150,30);
            this.add(zarfiat1);
            daneshkade1.setBounds(0,370,100,30);
            this.add(daneshkade1);
            daneshkade.setBounds(150,370,150,30);
            this.add(daneshkade);
            maghtaDars1.setBounds(0,420,100,30);
            this.add(maghtaDars1);
            maghtaDars.setBounds(150,420,150,30);
            this.add(maghtaDars);

            sabt.setBounds(500,500,150,30);
            this.add(sabt);


            virayesh.setBounds(300,500,150,30);
            this.add(virayesh);

        }
}

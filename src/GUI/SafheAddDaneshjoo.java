package GUI;

import LOGIC.Vazittahsily;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;

public class SafheAddDaneshjoo extends JPanel{
    static final Logger logger = LogManager.getLogger(SafheAddDaneshjoo.class);


    JTextField id, pass, name, email,saatSabtnam,ostadRahnama;
    JLabel id1, pass1, name1, email1,saatSabtnam1,ostadRahnama1,chooseFIle,vaziattahsili1,mojavezsabtnam1;
    JComboBox<Vazittahsily> vaziattahsili;
    JButton fileChooser;
    JCheckBox mojavezSabtnam;



    public SafheAddDaneshjoo(){

        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");
        initAdduserpanel();
        initcomps();
        align();


        GuiController.getInstance().addJpannel(this);
    }

    public void initAdduserpanel(){


        this.setBounds(0,30,800,770);
        this.setVisible(true);
        this.setLayout(null);







        logger.info("safhe adduser sakhte shod");

    }

    public void initcomps(){
        id= new JTextField();
        pass=new JTextField();
        name=new JTextField();
        email=new JTextField();
        saatSabtnam = new JTextField();
        ostadRahnama=new JTextField();

        id1= new JLabel("ID :");
        pass1= new JLabel("PASSWORD :");
        name1= new JLabel("NAME :");
        email1= new JLabel("EMAIL :");
        saatSabtnam1 =  new JLabel("SAAT SABT NAM :");
        ostadRahnama1= new JLabel("ID OSTAD RAHNAMA :");
        chooseFIle = new JLabel("ENTEKHAB AKS KARBAR :");
        vaziattahsili1=new JLabel("VAZIATTAHSILI :");
        mojavezsabtnam1=new JLabel("MOJAZ BE SABTNAM :");


        vaziattahsili = new JComboBox<>(Vazittahsily.values());
        fileChooser = new JButton("CHOOSE FILE");
        mojavezSabtnam = new JCheckBox();



    }
    public void align(){
        id1.setBounds(0,70,50,30);
        this.add(id1);
        id.setBounds(150,70,150,30);
        this.add(id);
        pass1.setBounds(0,120,100,30);
        this.add(pass1);
        pass.setBounds(150,120,150,30);
        this.add(pass);
        name1.setBounds(0,170,100,30);
        this.add(name1);
        name.setBounds(150,170,150,30);
        this.add(name);
        email1.setBounds(0,220,100,30);
        this.add(email1);
        email.setBounds(150,220,150,30);
        this.add(email);
        saatSabtnam1.setBounds(0,270,150,30);
        this.add(saatSabtnam1);
        saatSabtnam.setBounds(150,270,150,30);
        this.add(saatSabtnam);
        ostadRahnama1.setBounds(0,320,150,30);
        this.add(ostadRahnama1);
        ostadRahnama.setBounds(150,320,150,30);
        this.add(ostadRahnama);


        chooseFIle.setBounds(0,370,150,30);
        this.add(chooseFIle);
        fileChooser.setBounds(150,370,150,30);
        this.add(fileChooser);

        vaziattahsili1.setBounds(0,420,150,30);
        this.add(vaziattahsili1);
        vaziattahsili.setBounds(150,420,150,30);
        this.add(vaziattahsili);

        mojavezsabtnam1.setBounds(0,470,150,30);
        this.add(mojavezsabtnam1);
        mojavezSabtnam.setBounds(150,470,30,30);
        this.add(mojavezSabtnam);



    }

}


package GUI;

import LOGIC.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SafheAddDaneshjoo extends JPanel{
    static final Logger logger = LogManager.getLogger(SafheAddDaneshjoo.class);


    JTextField id, pass, name, email,saatSabtnam,ostadRahnama,kodeMeli,phoneNumber,saalVorod;
    JLabel id1, pass1, name1, email1,saatSabtnam1,ostadRahnama1,chooseFIle,vaziattahsili1,mojavezsabtnam1,aksKarbar1,kodeMeli1,phoneNumber1,saalVorod1;
    JComboBox<Vazittahsily> vaziattahsili;
    JComboBox<MaghtaDars> maghtaDars;
    JButton fileChooser,sabtNam;
    JCheckBox mojavezSabtnam;
    JOptionPane jOptionPane;
    boolean mojavez=false;


    public SafheAddDaneshjoo(){

        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");
        initAdduserpanel();
        initcomps();
        align();
        setActionListener1();


        GuiController.getInstance().addJpannel(this);
    }

    public void initAdduserpanel(){


        this.setBounds(0,30,800,770);
        this.setVisible(true);
        this.setLayout(null);







        logger.info("safhe addDaneshjoo sakhte shod");

    }

    public void initcomps(){
        id= new JTextField();
        pass=new JTextField();
        name=new JTextField();
        email=new JTextField();
        saatSabtnam = new JTextField();
        ostadRahnama=new JTextField();
        kodeMeli = new JTextField();
        phoneNumber = new JTextField();
        saalVorod = new JTextField();

        id1= new JLabel("ID :");
        pass1= new JLabel("PASSWORD :");
        name1= new JLabel("NAME :");
        email1= new JLabel("EMAIL :");
        saatSabtnam1 =  new JLabel("SAAT SABT NAM :");
        ostadRahnama1= new JLabel("ID OSTAD RAHNAMA :");
        chooseFIle = new JLabel("ENTEKHAB AKS KARBAR :");
        vaziattahsili1=new JLabel("VAZIATTAHSILI :");
        mojavezsabtnam1=new JLabel("MOJAZ BE SABTNAM :");
        kodeMeli1 = new JLabel("KODE MELI :");
        phoneNumber1 = new JLabel("SHOMARE TAMAS :");
        saalVorod1 = new JLabel("SAAL VOROOD");

        sabtNam=new JButton("SABT KARBAR");

        vaziattahsili = new JComboBox<>(Vazittahsily.values());
        maghtaDars = new JComboBox<>(MaghtaDars.values());
        fileChooser = new JButton("CHOOSE FILE");
        mojavezSabtnam = new JCheckBox();

        jOptionPane = new JOptionPane();


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

        kodeMeli1.setBounds(350,70,200,30);
        this.add(kodeMeli1);
        kodeMeli.setBounds(500,70,200,30);
        this.add(kodeMeli);


        phoneNumber1.setBounds(350,120,200,30);
        this.add(phoneNumber1);
        phoneNumber.setBounds(500,120,200,30);
        this.add(phoneNumber);

        saalVorod1.setBounds(350,170,150,30);
        this.add(saalVorod1);
        saalVorod.setBounds(500,170,150,30);
        this.add(saalVorod);

        maghtaDars.setBounds(350,220,200,30);
        this.add(maghtaDars);

        sabtNam.setBounds(500,500,150,30);
        this.add(sabtNam);
        aksKarbar1 = null;


    }
    public void setActionListener1(){
        mojavezSabtnam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (mojavezSabtnam.isSelected()){
                    mojavez = true;
                }else {
                    mojavez = false;
                }
            }
        });
        fileChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == fileChooser){
                        JFileChooser fc = new JFileChooser();
                        int i = fc.showOpenDialog(GuiController.getFrame());
                        if (i == JFileChooser.APPROVE_OPTION){
                            File f = fc.getSelectedFile();
                            String filepath = f.getPath();
                            try {
                                BufferedImage bi = ImageIO.read(new File(filepath));
                                aksKarbar1 = new JLabel(new ImageIcon(bi));
                                aksKarbar1.setBounds(350,10,400,400);
                                add(aksKarbar1);
                                repaint();
                                revalidate();

                        }catch (Exception ex){
                                logger.warn("filemored nazar kharab bood" + ex.getMessage());
                                jOptionPane.showMessageDialog(GuiController.getFrame(),"FILE ENTEKHABI AKS BASHAD");
                            }
                        }
                    }
            }
        });

        sabtNam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vazittahsily vazittahsily2 = vaziattahsili.getItemAt(vaziattahsili.getSelectedIndex());
                ImageIcon aksKarbar2 = null;
                if (!(aksKarbar1 == null) && !(aksKarbar1.getIcon() == null)){
                    aksKarbar2 = (ImageIcon) aksKarbar1.getIcon();
                }
                MoavenAmoozeshi moavenAmoozeshi = (MoavenAmoozeshi) Controller.getInstance().getAzayeDaneshgah();
                AzayeDaneshgah ostad2 = null;
                for (AzayeDaneshgah i :
                        AzayeDaneshgah.getAzayeDaneshgahs()) {
                    if (ostadRahnama.getText().equals(i.getId()) && i instanceof Ostad) {
                        ostad2 = (Ostad) i;
                    }
                }
                if (!(ostad2 == null) && !(pass.getText().isEmpty()) && !(id.getText().isEmpty())){
                    try {
                        moavenAmoozeshi.addDaneshjoo(
                                id.getText(),
                                pass.getText(),
                                name.getText(),
                                aksKarbar2,
                                email.getText(),
                                kodeMeli.getText(),
                                phoneNumber.getText(),
                                vazittahsily2,
                                ostad2,
                                mojavez,
                                saatSabtnam.getText(),
                                saalVorod.getText(),
                                maghtaDars.getItemAt(maghtaDars.getSelectedIndex())
                        );
                        jOptionPane.showMessageDialog(GuiController.getFrame(),"SAKHTE SHOD");
                        logger.info("Daneshjoo ba id : " + id.getText() + " va pasword : " + pass.getText() + " sakhte shod.");

                    } catch (Exception e1) {
                        jOptionPane.showMessageDialog(GuiController.getFrame(), "s.th wnt wrong");
                        logger.warn("error is :" + e1.getMessage());
                    }
            }else {
                    jOptionPane.showMessageDialog(GuiController.getFrame(),"fieldhaye id va pass va ostad ejbary hastand");
                }

            }
        });
    }

}


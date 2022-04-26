package GUI;

import LOGIC.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class SafheAddOstad extends JPanel {
    static final Logger logger = LogManager.getLogger(SafheAddOstad.class);

    boolean edit = false;

    JTextField id, pass, name, email,kodeMeli,phoneNumber,shOtagh;
    JLabel id1, pass1, name1, email1,chooseFIle ,aksKarbar1,kodeMeli1,phoneNumber1,shOtagh1;
    JButton fileChooser,sabtNam,virayesh;
    JOptionPane jOptionPane;
    JComboBox<DarajeOstadi> darajeOstadi;
    MoavenAmoozeshi moavenAmoozeshi;
    RaiisDaneshkade raiisDaneshkade;


   public SafheAddOstad(){
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


        logger.info("safhe addOstad sakhte shod");

    }
    public void initcomps(){
        id= new JTextField();
        pass=new JTextField();
        name=new JTextField();
        email=new JTextField();
        kodeMeli = new JTextField();
        phoneNumber = new JTextField();
        shOtagh = new JTextField();

        id1= new JLabel("ID :");
        pass1= new JLabel("PASSWORD :");
        name1= new JLabel("NAME :");
        email1= new JLabel("EMAIL :");
        kodeMeli1 = new JLabel("KODE MELI :");
        phoneNumber1 = new JLabel("SHOMARE TAMAS :");
        shOtagh1 = new JLabel("SHOMARE OTAGH :");

        darajeOstadi = new JComboBox<>(DarajeOstadi.values());

        chooseFIle = new JLabel("ENTEKHAB AKS KARBAR :");
        virayesh = new JButton("VIRAYESH");
        sabtNam=new JButton("SABT KARBAR");
        fileChooser = new JButton("CHOOSE FILE");
        jOptionPane = new JOptionPane();
        moavenAmoozeshi=null;
        raiisDaneshkade=null;
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
        kodeMeli1.setBounds(0,270,200,30);
        this.add(kodeMeli1);
        kodeMeli.setBounds(150,270,200,30);
        this.add(kodeMeli);
        phoneNumber1.setBounds(0,320,200,30);
        this.add(phoneNumber1);
        phoneNumber.setBounds(150,320,200,30);
        this.add(phoneNumber);
        shOtagh1.setBounds(0,370,200,30);
        this.add(shOtagh1);
        shOtagh.setBounds(150,370,200,30);
        this.add(shOtagh);
        darajeOstadi.setBounds(0,420,200,30);
        this.add(darajeOstadi);



        chooseFIle.setBounds(0,370,150,30);
        this.add(chooseFIle);
        fileChooser.setBounds(150,370,150,30);
        this.add(fileChooser);



        sabtNam.setBounds(500,500,150,30);
        this.add(sabtNam);
        aksKarbar1 = null;

        virayesh.setBounds(300,500,150,30);
        this.add(virayesh);

    }
    public void setActionListener1(){

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

                ImageIcon aksKarbar2 = null;
                if (!(aksKarbar1 == null) && !(aksKarbar1.getIcon() == null)){
                    aksKarbar2 = (ImageIcon) aksKarbar1.getIcon();
                }
                if (Controller.getInstance().getAzayeDaneshgah() instanceof MoavenAmoozeshi) {
                    moavenAmoozeshi = (MoavenAmoozeshi) Controller.getInstance().getAzayeDaneshgah();
                }else if(Controller.getInstance().getAzayeDaneshgah() instanceof RaiisDaneshkade){
                    raiisDaneshkade = (RaiisDaneshkade) Controller.getInstance().getAzayeDaneshgah();
                }

                if (!(pass.getText().isEmpty()) && !(id.getText().isEmpty())){
                    try {
                        if (!(moavenAmoozeshi == null)) {
                            moavenAmoozeshi.addOstad(
                                    id.getText(),
                                    pass.getText(),
                                    name.getText(),
                                    aksKarbar2,
                                    email.getText(),
                                    kodeMeli.getText(),
                                    phoneNumber.getText(),
                                    darajeOstadi.getItemAt(darajeOstadi.getSelectedIndex()),
                                    shOtagh.getText()
                            );
                        }else if (!(raiisDaneshkade == null)){
                            raiisDaneshkade.addOstad(
                                    id.getText(),
                                    pass.getText(),
                                    name.getText(),
                                    aksKarbar2,
                                    email.getText(),
                                    kodeMeli.getText(),
                                    phoneNumber.getText(),
                                    darajeOstadi.getItemAt(darajeOstadi.getSelectedIndex()),
                                    shOtagh.getText()
                            );
                        }
                        jOptionPane.showMessageDialog(GuiController.getFrame(),"SAKHTE SHOD");
                        logger.info("Ostad ba id : " + id.getText() + " va pasword : " + pass.getText() + " sakhte shod.");

                    } catch (Exception e1) {
                        jOptionPane.showMessageDialog(GuiController.getFrame(), "s.th wnt wrong");
                        logger.warn("error is :" + e1.getMessage());
                    }
                }else {
                    jOptionPane.showMessageDialog(GuiController.getFrame(),"fieldhaye id va pass ejbary hastand");
                }

            }
        });
        virayesh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon aksKarbar2 = null;
                if (!(aksKarbar1 == null) && !(aksKarbar1.getIcon() == null)){
                    aksKarbar2 = (ImageIcon) aksKarbar1.getIcon();
                }
                if (Controller.getInstance().getAzayeDaneshgah() instanceof MoavenAmoozeshi) {
                    moavenAmoozeshi = (MoavenAmoozeshi) Controller.getInstance().getAzayeDaneshgah();
                }else if(Controller.getInstance().getAzayeDaneshgah() instanceof RaiisDaneshkade){
                    raiisDaneshkade = (RaiisDaneshkade) Controller.getInstance().getAzayeDaneshgah();
                }
                try {
                    if (!(moavenAmoozeshi == null)) {
                        jOptionPane.showMessageDialog(GuiController.getFrame(),"MOJAZ NISTID");
                    }else if (!(raiisDaneshkade == null)){
                       edit = raiisDaneshkade.virayeshOstad(id.getText(),
                                pass.getText(),
                                name.getText(),
                                aksKarbar2,
                                email.getText());
                    }
                    if (edit) {
                        jOptionPane.showMessageDialog(GuiController.getFrame(), "Virayesh shod");
                        logger.info("Ostad ba id : " + id.getText() + " va pasword : " + pass.getText() + " Virayesh shod.");
                    }else {
                        jOptionPane.showMessageDialog(GuiController.getFrame(), "id morede nazar yaft nashod");
                    }
                } catch (Exception e1) {
                    jOptionPane.showMessageDialog(GuiController.getFrame(), "s.th wnt wrong");
                    logger.warn("error is :" + e1.getMessage());
                }
            }
        });
    }


}

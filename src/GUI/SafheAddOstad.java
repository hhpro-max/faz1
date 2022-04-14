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


    JTextField id, pass, name, email;
    JLabel id1, pass1, name1, email1,chooseFIle ,aksKarbar1;
    JButton fileChooser,sabtNam;
    JOptionPane jOptionPane;


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

        id1= new JLabel("ID :");
        pass1= new JLabel("PASSWORD :");
        name1= new JLabel("NAME :");
        email1= new JLabel("EMAIL :");

        chooseFIle = new JLabel("ENTEKHAB AKS KARBAR :");
        sabtNam=new JButton("SABT KARBAR");
        fileChooser = new JButton("CHOOSE FILE");
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



        chooseFIle.setBounds(0,370,150,30);
        this.add(chooseFIle);
        fileChooser.setBounds(150,370,150,30);
        this.add(fileChooser);



        sabtNam.setBounds(500,500,150,30);
        this.add(sabtNam);
        aksKarbar1 = null;


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
                MoavenAmoozeshi moavenAmoozeshi = (MoavenAmoozeshi) Controller.getInstance().getAzayeDaneshgah();


                if (!(pass.getText().isEmpty()) && !(id.getText().isEmpty())){
                    try {
                        moavenAmoozeshi.addOstad(
                                id.getText(),
                                pass.getText(),
                                name.getText(),
                                aksKarbar2,
                                email.getText()
                        );
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
    }


}

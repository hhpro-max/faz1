package GUI;

import EDUFILES.Emtehan;
import RESOURCES.ImageResource;
import RESOURCES.ResourceManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;
import java.util.ArrayList;

public class SafheVorod extends JPanel {
    static final Logger logger = LogManager.getLogger(Emtehan.class);

    ArrayList<JLabel> capchas = new ArrayList<>();
    public JLabel capcha1;
    public JLabel capcha2;
    public JLabel capcha3;
    public JLabel capcha4;
    public JLabel capcha5;
    public JLabel capcha6;

    int width = 800;
    int height = 800;

    public JButton vorood;
    public JPasswordField passwordField;
    public JTextField usernameField;

    public JLabel nameLabel;
    public JLabel passLabel;
    public JLabel showpass;

    public JCheckBox checkpassBox;

    public SafheVorod() {
        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");
        logger.info("enter to the constructor");

        initpanel();
        initcom();
        align();

        logger.info("exit from constructor");
    }

    public void initpanel() {
        logger.info("enter to the initpanel()");
        this.setBounds(0, 0, width, height);
        this.setVisible(true);
        this.setLayout(null);


        logger.info("exit from initpanel()");
    }

    public void initcom() {
        logger.info("enter to the initcom()");
        vorood = new JButton("VOROOD");
        passwordField = new JPasswordField();
        usernameField = new JTextField();
        nameLabel = new JLabel("namKarbary  :");
        passLabel = new JLabel("ramzOboor  :");
        checkpassBox = new JCheckBox();
        showpass = new JLabel("show");


        capcha1 = new JLabel();
        capcha1.setIcon(new ImageIcon(ResourceManager.get(ImageResource.CAPCHA1)));
        capcha1.setName("3a4d");

        capcha2 = new JLabel();
        capcha2.setIcon(new ImageIcon(ResourceManager.get(ImageResource.CAPCHA2)));
        capcha2.setName("xoe");

        capcha3 = new JLabel();
        capcha3.setIcon(new ImageIcon(ResourceManager.get(ImageResource.CAPCHA3)));
        capcha3.setName("pls");

        capcha4 = new JLabel();
        capcha4.setIcon(new ImageIcon(ResourceManager.get(ImageResource.CAPCHA4)));
        capcha4.setName("help");

        capcha5 = new JLabel();
        capcha5.setIcon(new ImageIcon(ResourceManager.get(ImageResource.CAPCHA5)));
        capcha5.setName("me");

        capcha6 = new JLabel();
        capcha6.setIcon(new ImageIcon(ResourceManager.get(ImageResource.CAPCHA6)));
        capcha6.setName("sos");

        capchas.add(capcha1);
        capchas.add(capcha2);
        capchas.add(capcha3);
        capchas.add(capcha4);
        capchas.add(capcha5);
        capchas.add(capcha6);

        logger.info("exit from initcom()");
    }

    public void align() {
        logger.info("vorood be align()");

        nameLabel.setBounds(100, 250, 90, 30);
        this.add(nameLabel);
        usernameField.setBounds(230, 250, 150, 30);
        this.add(usernameField);
        passLabel.setBounds(100, 350, 90, 30);
        this.add(passLabel);
        passwordField.setBounds(230, 350, 150, 30);
        this.add(passwordField);
        vorood.setBounds(350, 450, 150, 60);
        this.add(vorood);
        showpass.setBounds(400, 350, 50, 30);
        this.add(showpass);
        checkpassBox.setBounds(450, 350, 30, 30);
        this.add(checkpassBox);


        logger.info("khoroj az align()");
    }

    public void initcapcha() {


    }
}

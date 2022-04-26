package GUI;

import LOGIC.Controller;
import LOGIC.Daneshjoo;
import RESOURCES.ImageResource;
import RESOURCES.ResourceManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class SafheVorod extends JPanel {
    static final Logger logger = LogManager.getLogger(SafheVorod.class);

    public static int capchacounter = 0;
    public static JLabel thiscapcha;

    SendLoginInfo sendLoginInfo;
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
    public JButton refreshcapcha;
    public JTextField capchafield;
    public JPasswordField passwordField;
    public JTextField usernameField;

    public JLabel nameLabel;
    public JLabel passLabel;
    public JLabel showpass;


    //timer
    public Timer timer;
    public JLabel showTime;

    public JOptionPane jOptionPane;

    public JCheckBox checkpassBox;

    SafheTaghirPass safheTaghirPass;

    MainFrame frame;
    SafheAsli safheAsli;

    public SafheVorod(MainFrame frame) {
        this.frame = frame;
        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");
        logger.info("enter to the constructor");

        initpanel();
        initcom();
        align();
        setListener();

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
        refreshcapcha = new JButton("next");
        capchafield = new JTextField();


        //timer
        showTime = new JLabel();

        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showTime.setText(new Date().toString());
            }
        });
        timer.start();







        capcha1 = new JLabel();
        ImageIcon imageIcon = new ImageIcon(ResourceManager.get(ImageResource.CAPCHA1));
        imageIcon.getImage().flush();
        capcha1.setIcon(imageIcon);
        capcha1.setName("3a4d");

        capcha2 = new JLabel();
        ImageIcon imageIcon1 = new ImageIcon(ResourceManager.get(ImageResource.CAPCHA2));
        imageIcon1.getImage().flush();
        capcha2.setIcon(imageIcon1);
        capcha2.setName("xoe");

        capcha3 = new JLabel();
        ImageIcon imageIcon2 = new ImageIcon(ResourceManager.get(ImageResource.CAPCHA3));
        imageIcon2.getImage().flush();
        capcha3.setIcon(imageIcon2);
        capcha3.setName("pls");

        capcha4 = new JLabel();
        ImageIcon imageIcon3 = new ImageIcon(ResourceManager.get(ImageResource.CAPCHA4));
        imageIcon3.getImage().flush();
        capcha4.setIcon(imageIcon3);
        capcha4.setName("help");

        capcha5 = new JLabel();
        ImageIcon imageIcon4 = new ImageIcon(ResourceManager.get(ImageResource.CAPCHA5));
        imageIcon4.getImage().flush();
        capcha5.setIcon(imageIcon4);
        capcha5.setName("me");

        capcha6 = new JLabel();
        ImageIcon imageIcon5 = new ImageIcon(ResourceManager.get(ImageResource.CAPCHA6));
        imageIcon5.getImage().flush();
        capcha6.setIcon(imageIcon5);
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
        vorood.setBounds(550, 650, 150, 60);
        this.add(vorood);
        showpass.setBounds(400, 350, 50, 30);
        this.add(showpass);
        checkpassBox.setBounds(450, 350, 30, 30);
        this.add(checkpassBox);
        thiscapcha = new JLabel();
        thiscapcha.setIcon(capchas.get(0).getIcon());
        thiscapcha.setName(capchas.get(0).getName());
        thiscapcha.setBounds(200, 420,100,80);
        this.add(thiscapcha);
        refreshcapcha.setBounds(240,510,80,50);
        this.add(refreshcapcha);
        capchafield.setBounds(200,590,100,30);
        this.add(capchafield);
        jOptionPane = new JOptionPane();
        this.add(jOptionPane);
        //timer
        showTime.setBounds(100,200,200,30);
        this.add(showTime);



        logger.info("khoroj az align()");
    }




    public void setListener(){
        checkpassBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkpassBox.isSelected()){
                    passwordField.setEchoChar((char)0);
                }else {
                    passwordField.setEchoChar('*');
                }
            }
        });

        refreshcapcha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    capchacounter++;

                    capcharesetcheck();

                    thiscapcha.setIcon(capchas.get(capchacounter).getIcon());
                    thiscapcha.setName(capchas.get(capchacounter).getName());
                    update();
                    frame.update();


                    logger.info("new capcha is :" + thiscapcha.getName() + "and counter is"+capchacounter);


            }
        });

        vorood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String capcha = capchafield.getText();
                String name = usernameField.getText();
                String pass = passwordField.getText();
                if (capcha.equals(thiscapcha.getName())){
                    if (!name.isEmpty() && !pass.isEmpty()){
                        Date date = new Date();
                        int hour = date.getHours();



                        String zamanvorood = String.valueOf(hour);
                        sendLoginInfo = new SendLoginInfo(name,pass,zamanvorood);
                        Controller.getInstance().login(sendLoginInfo);
                        if (Controller.getInstance().chekvalidlogin()){
                            Controller.getInstance().initZamanVorood();

                            int lasHour = Integer.parseInt(Controller.getInstance().getZamanvorood());
                            if (hour - lasHour >= 3){
                                Controller.getInstance().setChangedPass(false);
                                safheTaghirPass = new SafheTaghirPass();
                                frame.add(safheTaghirPass,1);
                                repaint();
                                revalidate();
                                setVisible(false);
                                return;
                            }else {
                                Controller.getInstance().setAkharinZamanVorood();
                            }

                            safheAsli = Controller.getInstance().getPage();
                            frame.add(safheAsli);
                            setVisible(false);
                            logger.info("vorood karbar "+ Controller.getInstance().getName() +"dar zaman"+ showTime.getText() +"movafaghiat amiz bood");
                        }else {
                            jOptionPane.showMessageDialog(frame,"name karbary ya ramz oboor eshtebah ast");
                        }
                    }else {
                        jOptionPane.showMessageDialog(frame,"hich fieldy ra khali nagozarid");
                    }


                }else {
                    jOptionPane.showMessageDialog(frame,"captcha is wrong");
                }
            }
        });
    }
    void capcharesetcheck(){
        if (capchacounter > 5){
            capchacounter = 0;
        }
    }

    public void update(){

        this.repaint();
        this.revalidate();

    }




}

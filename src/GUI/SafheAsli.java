package GUI;

import EDUFILES.Emtehan;
import LOGIC.Controller;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class SafheAsli extends JPanel {
    static final Logger logger = LogManager.getLogger(SafheAsli.class);
    int width = 800;
    int height = 800;


    public Timer timer;
    public JLabel showTime;
    public JButton khoroj;
    public JLabel zamanakharinvorood;
    public JLabel akskarbar;
    public JLabel namekarbar;
    public JLabel emailkarbar;
    MainFrame frame;



    public SafheAsli(){
        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");
        logger.info("enter to the constructor");

        initpanel();
        initcom();
        align();
        setListener();
    }


    public void initpanel() {
        logger.info("enter to the initpanel()");
        this.setBounds(0, 0, width, height);
        this.setVisible(true);
        this.setLayout(null);


        logger.info("exit from initpanel()");
    }

    public void initcom(){
        showTime = new JLabel();

        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showTime.setText(new Date().toString());
            }
        });
        timer.start();

        khoroj = new JButton("EXIT");
        zamanakharinvorood = new JLabel(Controller.getInstance().getZamanvorood());
        akskarbar = new JLabel(Controller.getInstance().getAzayeDaneshgah().getAkskarbar());
        namekarbar = new JLabel("yourName : " + Controller.getInstance().getAzayeDaneshgah().getName());
        emailkarbar = new JLabel("yourEmail : " +Controller.getInstance().getAzayeDaneshgah().getEmail());

        frame = (MainFrame) GuiController.getFrame();

    }
    public void align(){
        showTime.setBounds(0,175,200,30);
        this.add(showTime);
        khoroj.setBounds(0,0,80,30);
        this.add(khoroj);
        akskarbar.setBounds(0,70,100,100);
        this.add(akskarbar);
        namekarbar.setBounds(0,200,200,30);
        this.add(namekarbar);
        emailkarbar.setBounds(0,230,300,30);
        this.add(emailkarbar);
    }

    public void setListener(){
        khoroj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SafheVorod safheVorod = new SafheVorod(frame);
                setVisible(false);
                frame.add(safheVorod);

            }
        });
    }


}

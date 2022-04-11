package GUI;

import EDUFILES.Emtehan;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    static final Logger logger = LogManager.getLogger(MainFrame.class);




    int width=800;
    int height = 800;

    SafheVorod safheVorod;

    public MainFrame(){
        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");
        logger.info("enter in constructor of Mainframe");
        initframe();
        safheVorod = new SafheVorod(this);
        this.add(safheVorod);


        update();


        logger.info("exit of constructor");
    }


    public void initframe(){
        logger.info("enter to the initframe()");

            this.setVisible(true);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setLayout(null);
            this.setResizable(false);
            this.setSize(new Dimension(width,height));


        logger.info("exit of the initframe()");
    }


    public void update(){
        logger.info("vorood be update");
        this.repaint();
        this.revalidate();
    }
    public Frame getFrame(){
        return this;
    }

}

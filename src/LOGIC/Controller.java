package LOGIC;

import EDUFILES.Emtehan;
import GUI.SendLoginIngo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Controller {
    static final Logger logger = LogManager.getLogger(Emtehan.class);

    public static Controller controller;
    private Controller(){
        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");

    }
    public static Controller getInstance(){
        if (controller==null){
            controller = new Controller();
        }
        return controller;
    }



    public void login(SendLoginIngo sendLoginIngo){
        String name = sendLoginIngo.getName();
        String pass = sendLoginIngo.getPass();

    }

}

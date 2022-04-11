package LOGIC;

import EDUFILES.Emtehan;
import GUI.SendLoginIngo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Controller {
    static final Logger logger = LogManager.getLogger(Emtehan.class);

    String name;
    String pass;
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
         this.name = sendLoginIngo.getName();
         this.pass = sendLoginIngo.getPass();

    }
    public boolean chekvalidlogin(){
        LoginCheck loginCheck = new LoginCheck();
        loginCheck.check();
        logger.info("checked login is :" + String.valueOf(LoginCheck.isvalidLogin) );
        return LoginCheck.isvalidLogin;

    }









    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

package LOGIC;

import EDUFILES.Emtehan;
import GUI.SendLoginIngo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Controller {
    static final Logger logger = LogManager.getLogger(Controller.class);

    String name;
    String pass;
    String zamanvorood;
    AzayeDaneshgah azayeDaneshgah;
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
         this.zamanvorood = sendLoginIngo.getZamanvorood();
    }
    public boolean chekvalidlogin(){
        LoginCheck loginCheck = new LoginCheck();
        loginCheck.check();
        logger.info("checked login is :" + String.valueOf(LoginCheck.isvalidLogin) );
        if (LoginCheck.isvalidLogin){
            azayeDaneshgah = LoginCheck.azayeDaneshgah;
        }
        return LoginCheck.isvalidLogin;

    }







    public AzayeDaneshgah getAzayeDaneshgah() {
        return azayeDaneshgah;
    }

    public void setAzayeDaneshgah(AzayeDaneshgah azayeDaneshgah) {
        this.azayeDaneshgah = azayeDaneshgah;
    }

    public String getZamanvorood() {
        return zamanvorood;
    }

    public void setZamanvorood(String zamanvorood) {
        this.zamanvorood = zamanvorood;
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

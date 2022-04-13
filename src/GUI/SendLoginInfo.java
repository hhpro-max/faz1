package GUI;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SendLoginInfo {
    static final Logger logger = LogManager.getLogger(SendLoginInfo.class);
    public String name;
    public String pass;
    public String zamanvorood;

    public SendLoginInfo(String name, String pass, String zamanvorood){
        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");
        logger.info("enter to the constructor");
        this.name=name;
        this.pass=pass;
        this.zamanvorood=zamanvorood;
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

package GUI;


import EDUFILES.Emtehan;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SendLoginIngo {
    static final Logger logger = LogManager.getLogger(Emtehan.class);
    public String name;
    public String pass;

    public SendLoginIngo(String name,String pass){
        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");
        logger.info("enter to the constructor");
        this.name=name;
        this.pass=pass;
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

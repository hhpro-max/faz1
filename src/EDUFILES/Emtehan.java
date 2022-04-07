package EDUFILES;


import com.google.gson.Gson;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.log4j.*;



public class Emtehan {
    static final Logger logger = LogManager.getLogger(Emtehan.class);


    public String name;
    public String family;
    public int age;
    public boolean haveShityLife;

    public Emtehan(String name,String family,int age,boolean haveShityLife){

        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");





        this.name = name;
        this.age = age;
        this.family = family;
        this.haveShityLife = haveShityLife;

    }

}

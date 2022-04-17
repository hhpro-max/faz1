package LOGIC;

import GUI.SendLoginInfo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;

public class Controller {
    static final Logger logger = LogManager.getLogger(Controller.class);
    ArrayList<AzayeDaneshgah> azayeDaneshgahs = AzayeDaneshgah.getAzayeDaneshgahs();
    String name;
    String pass;
    String zamanvorood;
    AzayeDaneshgah azayeDaneshgah;
    public static Controller controller;
    private Controller(){
        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");
        azayeDaneshgahs = AzayeDaneshgah.getAzayeDaneshgahs();
    }
    public static Controller getInstance(){
        if (controller==null){
            controller = new Controller();
        }
        return controller;
    }



    public void login(SendLoginInfo sendLoginInfo){
         this.name = sendLoginInfo.getName();
         this.pass = sendLoginInfo.getPass();
         this.zamanvorood = sendLoginInfo.getZamanvorood();
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
    public boolean removeOstad(String id){
        if (azayeDaneshgah instanceof RaiisDaneshkade) {
            RaiisDaneshkade raiisDaneshkade = (RaiisDaneshkade) azayeDaneshgah;
            boolean a = raiisDaneshkade.deleteOstad(id);
            return a;
        }
       return false;
    }
    public boolean upGradeOstad(String id){
        if (azayeDaneshgah instanceof RaiisDaneshkade) {
            RaiisDaneshkade raiisDaneshkade = (RaiisDaneshkade) azayeDaneshgah;
            boolean a = raiisDaneshkade.upGradetoMoaven(id);
            return a;
        }
        return false;
    }
    public boolean addDars(String id,
                           String name,
                           String pishniaz,
                           AzayeDaneshgah ostad,
                           DaneshKade daneshkade,
                           String tedadVahed,
                           MaghtaDars maghtaDars,
                           String zarfiat){
        if (azayeDaneshgah instanceof MoavenAmoozeshi){
            MoavenAmoozeshi moavenAmoozeshi = (MoavenAmoozeshi) azayeDaneshgah;
            boolean a = moavenAmoozeshi.addDars(id,name,pishniaz,ostad,daneshkade,tedadVahed,maghtaDars,zarfiat);
            return a;
        }
        return false;
    }
    public boolean hazfDars(String id){
        if (azayeDaneshgah instanceof MoavenAmoozeshi){
            MoavenAmoozeshi moavenAmoozeshi = (MoavenAmoozeshi) azayeDaneshgah;
            boolean a = moavenAmoozeshi.hazfDars(id);
            return a;
        }
        return false;
    }
    public boolean checkOstad(String id){
        for (AzayeDaneshgah i:
             azayeDaneshgahs) {
            if (i.getId().equals(id) && i instanceof Ostad){

                return true;
            }
        }
        return false;
    }
    public AzayeDaneshgah getOstad(String id){
        boolean a = checkOstad(id);
        if (a){
            for (AzayeDaneshgah i:
                    azayeDaneshgahs) {
                if (i.getId().equals(id) && i instanceof Ostad){
                    return i;
                }
            }
        }
        return null;
    }
    public boolean virayeshDars(String id,
                                String name,
                                String pishniaz,
                                AzayeDaneshgah ostad,
                                DaneshKade daneshkade,
                                String tedadVahed,
                                MaghtaDars maghtaDars,
                                String zarfiat){
        if (azayeDaneshgah instanceof MoavenAmoozeshi){
            MoavenAmoozeshi moavenAmoozeshi =(MoavenAmoozeshi) azayeDaneshgah;
            boolean a = moavenAmoozeshi.virayeshDars(id, name, pishniaz, ostad, daneshkade, tedadVahed, maghtaDars, zarfiat);
            return a;
        }
        return false;
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

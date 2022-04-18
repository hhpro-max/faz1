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
    public ArrayList<Dars> getDarsDaneshjoo(){
        if (azayeDaneshgah instanceof Daneshjoo){
            Daneshjoo daneshjoo = (Daneshjoo) azayeDaneshgah;
            ArrayList<Dars> dars = new ArrayList<>();
            for (Dars i:
                 daneshjoo.getDars()) {
                dars.add(i);
            }
            return dars;
        }
       return null;
    }
    public int roozHafte(RoozayeHafte roozayeHafte){
        switch (roozayeHafte){
            case SHANBE: return 0;
            case YEKSHANBE: return 1;
            case DOSHANBE:return 2;
            case SESHANBE:return 3;
            case CHARSHANBE:return 4;
            case PANJSHANBE:return 5;
            case JOME:return 6;
        }
        return 0;
    }
    public int saatClass(String saat){
        switch (saat){
            case "9":return 0;
            case "10.5":return 1;
            case "12":return 2;
            case "1.5":return 3;
            case  "3":return 4;
            case   "4.5":return 5;
            case "6":return 6;
            case "7.5":return 7;
        }
        return 0;
    }
    public ArrayList<Dars> tartibBnadiTarikhEmt(){
        ArrayList<Dars> dars = getDarsDaneshjoo();
        Dars a = null;
        Dars b = null;
        int key = dars.size() + 1;
        while (true) {
            try {
                loop:
                for (Dars i :
                        dars) {
                    b = a;
                    a = i;
                    int indexb = 0 ;
                    int indexa = 0 ;
                    if (!(b==null && a==null)){
                        indexb = dars.indexOf(b);
                        indexa = dars.indexOf(a);
                    }

                    if (!(b == null) && a.getDateEmtehan().getYear() > b.getDateEmtehan().getYear() && dars.indexOf(a) < dars.indexOf(b)) {
                        dars.remove(b);
                        dars.add(indexb, a);
                        dars.remove(a);
                        dars.add(indexa, b);
                        break loop;
                    }
                    else if (!(b == null) && a.getDateEmtehan().getMonth() > b.getDateEmtehan().getMonth() && dars.indexOf(a) < dars.indexOf(b)) {
                        dars.remove(b);
                        dars.add(indexb, a);
                        dars.remove(a);
                        dars.add(indexa, b);
                        break loop;
                    }
                    else if (!(b == null) && a.getDateEmtehan().getDate() > b.getDateEmtehan().getDate() && dars.indexOf(a) < dars.indexOf(b)) {
                        dars.remove(b);
                        dars.add(indexb, a);
                        dars.remove(a);
                        dars.add(indexa, b);
                        break loop;
                    }

                }

            }catch (Exception e){
                logger.error("error is " + e.getMessage());
                break;
            }
            key--;
            if (key <= 0){
                break;
            }

        }
        logger.info("moratabShod");
        return dars;

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

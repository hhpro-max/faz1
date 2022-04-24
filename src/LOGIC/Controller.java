package LOGIC;

import GUI.SendLoginInfo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Random;

public class Controller {
    static final Logger logger = LogManager.getLogger(Controller.class);
    ArrayList<AzayeDaneshgah> azayeDaneshgahs = AzayeDaneshgah.getAzayeDaneshgahs();
    String name;
    String pass;
    String zamanvorood;
    AzayeDaneshgah azayeDaneshgah;
    public static Controller controller;

    private Controller() {
        PropertyConfigurator.configure("src/EDUFILES/log4j.properties");
        azayeDaneshgahs = AzayeDaneshgah.getAzayeDaneshgahs();
    }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }


    public void login(SendLoginInfo sendLoginInfo) {
        this.name = sendLoginInfo.getName();
        this.pass = sendLoginInfo.getPass();
        this.zamanvorood = sendLoginInfo.getZamanvorood();
    }

    public boolean chekvalidlogin() {
        LoginCheck loginCheck = new LoginCheck();
        loginCheck.check();
        logger.info("checked login is :" + String.valueOf(LoginCheck.isvalidLogin));
        if (LoginCheck.isvalidLogin) {
            azayeDaneshgah = LoginCheck.azayeDaneshgah;
        }
        return LoginCheck.isvalidLogin;

    }

    public boolean removeOstad(String id) {
        if (azayeDaneshgah instanceof RaiisDaneshkade) {
            RaiisDaneshkade raiisDaneshkade = (RaiisDaneshkade) azayeDaneshgah;
            boolean a = raiisDaneshkade.deleteOstad(id);
            return a;
        }
        return false;
    }

    public boolean upGradeOstad(String id) {
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
                           String zarfiat) {
        if (azayeDaneshgah instanceof MoavenAmoozeshi) {
            MoavenAmoozeshi moavenAmoozeshi = (MoavenAmoozeshi) azayeDaneshgah;
            boolean a = moavenAmoozeshi.addDars(id, name, pishniaz, ostad, daneshkade, tedadVahed, maghtaDars, zarfiat);
            return a;
        }
        return false;
    }

    public boolean hazfDars(String id) {
        if (azayeDaneshgah instanceof MoavenAmoozeshi) {
            MoavenAmoozeshi moavenAmoozeshi = (MoavenAmoozeshi) azayeDaneshgah;
            boolean a = moavenAmoozeshi.hazfDars(id);
            return a;
        }
        return false;
    }

    public boolean checkOstad(String id) {
        for (AzayeDaneshgah i :
                azayeDaneshgahs) {
            if (i.getId().equals(id) && i instanceof Ostad) {

                return true;
            }
        }
        return false;
    }

    public AzayeDaneshgah getOstad(String id) {
        boolean a = checkOstad(id);
        if (a) {
            for (AzayeDaneshgah i :
                    azayeDaneshgahs) {
                if (i.getId().equals(id) && i instanceof Ostad) {
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
                                String zarfiat) {
        if (azayeDaneshgah instanceof MoavenAmoozeshi) {
            MoavenAmoozeshi moavenAmoozeshi = (MoavenAmoozeshi) azayeDaneshgah;
            boolean a = moavenAmoozeshi.virayeshDars(id, name, pishniaz, ostad, daneshkade, tedadVahed, maghtaDars, zarfiat);
            return a;
        }
        return false;
    }

    public ArrayList<Dars> getDarsDaneshjoo() {
        if (azayeDaneshgah instanceof Daneshjoo) {
            Daneshjoo daneshjoo = (Daneshjoo) azayeDaneshgah;
            ArrayList<Dars> dars = new ArrayList<>();
            for (Dars i :
                    daneshjoo.getDars()) {
                dars.add(i);
            }
            return dars;
        } else if (azayeDaneshgah instanceof Ostad) {
            Ostad ostad = (Ostad) azayeDaneshgah;
            ArrayList<Dars> dars = new ArrayList<>();
            for (Dars i :
                    ostad.getDarsha()) {
                dars.add(i);
            }
            return dars;
        }
        return null;
    }

    public int roozHafte(RoozayeHafte roozayeHafte) {
        switch (roozayeHafte) {
            case SHANBE:
                return 0;
            case YEKSHANBE:
                return 1;
            case DOSHANBE:
                return 2;
            case SESHANBE:
                return 3;
            case CHARSHANBE:
                return 4;
            case PANJSHANBE:
                return 5;
            case JOME:
                return 6;
        }
        return 0;
    }

    public int saatClass(String saat) {
        switch (saat) {
            case "9":
                return 0;
            case "10.5":
                return 1;
            case "12":
                return 2;
            case "1.5":
                return 3;
            case "3":
                return 4;
            case "4.5":
                return 5;
            case "6":
                return 6;
            case "7.5":
                return 7;
        }
        return 0;
    }

    public ArrayList<Dars> tartibBnadiTarikhEmt() {
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
                    int indexb = 0;
                    int indexa = 0;
                    if (!(b == null && a == null)) {
                        indexb = dars.indexOf(b);
                        indexa = dars.indexOf(a);
                    }

                    if (!(b == null) && a.getDateEmtehan().getYear() > b.getDateEmtehan().getYear() && dars.indexOf(a) < dars.indexOf(b)) {
                        dars.remove(b);
                        dars.add(indexb, a);
                        dars.remove(a);
                        dars.add(indexa, b);
                        break loop;
                    } else if (!(b == null) && a.getDateEmtehan().getMonth() > b.getDateEmtehan().getMonth() && dars.indexOf(a) < dars.indexOf(b)) {
                        dars.remove(b);
                        dars.add(indexb, a);
                        dars.remove(a);
                        dars.add(indexa, b);
                        break loop;
                    } else if (!(b == null) && a.getDateEmtehan().getDate() > b.getDateEmtehan().getDate() && dars.indexOf(a) < dars.indexOf(b)) {
                        dars.remove(b);
                        dars.add(indexb, a);
                        dars.remove(a);
                        dars.add(indexa, b);
                        break loop;
                    }

                }

            } catch (Exception e) {
                logger.error("error is " + e.getMessage());
                break;
            }
            key--;
            if (key <= 0) {
                break;
            }

        }
        logger.info("moratabShod");
        return dars;

    }

    public ArrayList<Ostad> getAsatidDaneshjoo() {
        if (azayeDaneshgah instanceof Daneshjoo) {
            Daneshjoo daneshjoo = (Daneshjoo) azayeDaneshgah;
            ArrayList<Ostad> asatid = new ArrayList<>();
            for (Dars i :
                    daneshjoo.getDars()) {
                loop:
                for (Ostad j : asatid) {
                    if (j.getId().equals(i.getOstad().getId())) {
                        asatid.remove(j);
                        break loop;
                    }
                }
                asatid.add((Ostad) i.getOstad());

            }
            return asatid;
        }
        return null;
    }

    public Daneshjoo getDaneshjoo() {
        if (azayeDaneshgah instanceof Daneshjoo) {
            return (Daneshjoo) azayeDaneshgah;
        }
        return null;
    }

    public void addDarkhastTosieName(String id) {
        Ostad ostad = (Ostad) getOstad(id);
        if (azayeDaneshgah instanceof Daneshjoo) {
            ostad.getDarkhastTosieName().put((Daneshjoo) azayeDaneshgah, Vaziat.SABTSHODE);
        }
    }

    public void addDarkhastToseiNameDaneshjoo(ArrayList<String> i) {
        if (azayeDaneshgah instanceof Daneshjoo) {
            ((Daneshjoo) azayeDaneshgah).getDarkhastTosieName().add(i);
        }
    }

    public ArrayList<ArrayList<String>> getDarkhatTosieNameDaneshjoo() {
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        if (azayeDaneshgah instanceof Daneshjoo) {
            if (!((Daneshjoo) azayeDaneshgah).getDarkhastTosieName().isEmpty()) {
                return ((Daneshjoo) azayeDaneshgah).getDarkhastTosieName();
            }
        }
        return arrayLists;
    }

    public ArrayList<ArrayList<String>> getOstadTosieNameList() {
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        if (azayeDaneshgah instanceof Ostad) {
            for (Map.Entry<Daneshjoo, Vaziat> i :
                    ((Ostad) azayeDaneshgah).getDarkhastTosieName().entrySet()) {
                arrayLists.add(new ArrayList<>());
                for (ArrayList<String> j :
                        arrayLists) {
                    if (j.isEmpty()) {
                        j.add(i.getKey().getId());
                        j.add(i.getKey().getName());
                        j.add(i.getValue().toString());
                    }
                }
            }
            return arrayLists;
        }


        return arrayLists;
    }

    public boolean setVaziatDarkhastDaneshjoo(String id, Vaziat vaziat) {
        for (AzayeDaneshgah i :
                azayeDaneshgahs) {
            if (i instanceof Daneshjoo && i.getId().equals(id)) {
                for (ArrayList<String> j :
                        ((Daneshjoo) i).getDarkhastTosieName()) {
                    if (j.get(0).equals(azayeDaneshgah.getId())) {
                        j.set(2, vaziat.toString());
                        if (azayeDaneshgah instanceof Ostad) {
                            ((Ostad) azayeDaneshgah).getDarkhastTosieName().replace((Daneshjoo) i, vaziat);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean setVaziatDarkhastMinorDaneshjoo(String id, DaneshKade daneshKade, Vaziat vaziat) {
        for (AzayeDaneshgah i :
                azayeDaneshgahs) {
            if (i instanceof Daneshjoo && i.getId().equals(id) && azayeDaneshgah instanceof MoavenAmoozeshi) {
                if (((Daneshjoo) i).getDaneshKade().equals(((MoavenAmoozeshi) azayeDaneshgah).getDaneshKade())) {
                    ArrayList<Vaziat> vaziats = new ArrayList<>();
                    vaziats.addAll(((Daneshjoo) i).getDarkhastMinor().get(daneshKade));
                    vaziats.set(0, vaziat);
                    ((Daneshjoo) i).getDarkhastMinor().replace(daneshKade, vaziats);
                    return true;
                } else {
                    ArrayList<Vaziat> vaziats = new ArrayList<>();
                    vaziats.addAll(((Daneshjoo) i).getDarkhastMinor().get(daneshKade));
                    vaziats.set(1, vaziat);
                    ((Daneshjoo) i).getDarkhastMinor().replace(daneshKade, vaziats);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<ArrayList<String>> getListEnserafia() {
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        if (azayeDaneshgah instanceof MoavenAmoozeshi) {
            for (Daneshjoo i : ((MoavenAmoozeshi) azayeDaneshgah).getDaneshjooDarkhastEnseraf()) {
                arrayLists.add(new ArrayList<>());
                for (ArrayList<String> j : arrayLists) {
                    if (j.isEmpty()) {
                        j.add(i.getId());
                        j.add(i.getName());
                    }
                }

            }
        }
        return arrayLists;
    }

    public boolean removeDaneshjoo(String id) {
        if (azayeDaneshgah instanceof MoavenAmoozeshi) {
            return ((MoavenAmoozeshi) azayeDaneshgah).hazfDaneshjooEnserafi(id);
        }
        return false;
    }

    public ArrayList<ArrayList<String>> getListNomaratMovaghatDaneshjoo() {
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        if (azayeDaneshgah instanceof Daneshjoo) {
            for (Map.Entry<Dars, String> i :
                    ((Daneshjoo) azayeDaneshgah).getListNomaratMovaghat().entrySet()) {
                arrayLists.add(new ArrayList<>());
                for (ArrayList<String> j :
                        arrayLists) {
                    if (j.isEmpty()) {
                        j.add(i.getKey().getId());
                        j.add(i.getKey().getName());
                        j.add(i.getValue());
                    }
                }
            }
        }
        return arrayLists;
    }

    public boolean sabtEteraz(String id, String matn) {
        Ostad ostad = null;
        if (azayeDaneshgah instanceof Daneshjoo) {
            for (Dars i :
                    ((Daneshjoo) azayeDaneshgah).getDars()) {
                if (i.getId().equals(id)) {
                    ostad = (Ostad) i.getOstad();
                }
            }
            if (!(ostad == null)) {
                ostad.getEterazat().add(matn);
                return true;
            }
        }
        return false;
    }

    public boolean sabtNatijeEteraz(String id, String matn) {
        Daneshjoo daneshjoo = null;
        if (azayeDaneshgah instanceof Ostad) {
            for (AzayeDaneshgah i : azayeDaneshgahs) {
                if (i.getId().equals(id)) {
                    daneshjoo = (Daneshjoo) i;
                }
            }
        }
        if (!(daneshjoo == null)) {
            daneshjoo.getNatijeEteraz().add(matn);
            return true;
        }
        return false;
    }

    public ArrayList<ArrayList<String>> getListDaneshjooOstad() {
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        if (azayeDaneshgah instanceof Ostad) {
            arrayLists = ((Ostad) azayeDaneshgah).getListDaneshjoo();
        }
        return arrayLists;
    }

    public ArrayList<ArrayList<String>> getListDaneshjooMoaven() {
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        if (azayeDaneshgah instanceof MoavenAmoozeshi) {
            arrayLists = ((MoavenAmoozeshi) azayeDaneshgah).checkDaneshjooha();
        }
        return arrayLists;
    }

    public Dars getDars1(String id) {
        Dars dars = null;
        for (Dars i :
                Dars.getDoros()) {
            if (i.getId().equals(id)) {
                dars = i;
            }
        }
        return dars;
    }

    public ArrayList<ArrayList<String>> getMinorListMoaven() {
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        if (azayeDaneshgah instanceof MoavenAmoozeshi) {
            for (Daneshjoo i : ((MoavenAmoozeshi) azayeDaneshgah).getDaneshjooDarkhastMinor()) {
                for (Map.Entry<DaneshKade, ArrayList<Vaziat>> j :
                        i.getDarkhastMinor().entrySet()) {
                    arrayLists.add(new ArrayList<>());
                    for (ArrayList<String> k :
                            arrayLists) {
                        if (k.isEmpty()) {
                            k.add(i.getDaneshKade().toString());
                            k.add(j.getKey().toString());
                            k.add(i.getId());
                            k.add(i.getName());
                            k.add(j.getValue().get(0).toString());
                            k.add(j.getValue().get(1).toString());

                        }
                    }
                }
            }
            return arrayLists;
        }
        return arrayLists;
    }

    public boolean checkShartMinor() {
        if (azayeDaneshgah instanceof Daneshjoo) {
            try {
                Daneshjoo daneshjoo = (Daneshjoo) azayeDaneshgah;
                double moadel = Double.parseDouble(daneshjoo.getMoadel());
                if (moadel >= 15.0) {
                    return true;
                }
            } catch (Exception e4) {
                logger.warn("error is : " + e4.getMessage());
            }

        }
        return false;
    }

    public boolean sendDarkhastMinor(DaneshKade daneshKade) {
        if (azayeDaneshgah instanceof Daneshjoo) {
            DaneshKade daneshKadeMabda = ((Daneshjoo) azayeDaneshgah).getDaneshKade();
            DaneshKade daneshKadeMaghsad = daneshKade;
            ArrayList<Vaziat> vaziats = new ArrayList<>();
            vaziats.add(Vaziat.SABTSHODE);
            vaziats.add(Vaziat.SABTSHODE);

            for (AzayeDaneshgah i :
                    AzayeDaneshgah.getAzayeDaneshgahs()) {
                if (i instanceof MoavenAmoozeshi && daneshKadeMabda.equals(((MoavenAmoozeshi) i).getDaneshKade()) && !(daneshKadeMabda.equals(daneshKadeMaghsad))) {
                    ((MoavenAmoozeshi) i).getDaneshjooDarkhastMinor().add((Daneshjoo) azayeDaneshgah);
                    break;
                }
            }
            for (AzayeDaneshgah i :
                    AzayeDaneshgah.getAzayeDaneshgahs()) {
                if (i instanceof MoavenAmoozeshi && daneshKadeMaghsad.equals(((MoavenAmoozeshi) i).getDaneshKade()) && !(daneshKadeMabda.equals(daneshKadeMaghsad))) {
                    ((MoavenAmoozeshi) i).getDaneshjooDarkhastMinor().add((Daneshjoo) azayeDaneshgah);
                    ((Daneshjoo) azayeDaneshgah).getDarkhastMinor().put(daneshKadeMaghsad, vaziats);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean sendDarkhastEnseraf() {
        if (azayeDaneshgah instanceof Daneshjoo) {
            DaneshKade daneshKadeMabda = ((Daneshjoo) azayeDaneshgah).getDaneshKade();
            for (AzayeDaneshgah i :
                    AzayeDaneshgah.getAzayeDaneshgahs()) {
                if (i instanceof MoavenAmoozeshi && daneshKadeMabda.equals(((MoavenAmoozeshi) i).getDaneshKade())) {
                    ((MoavenAmoozeshi) i).getDaneshjooDarkhastEnseraf().add((Daneshjoo) azayeDaneshgah);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkKhabgah() {
        Double a = Math.random() * 20;
        Double b = Math.random() * 20;

        if (azayeDaneshgah instanceof DaneshjooArshad) {
            DaneshjooArshad daneshjooArshad = (DaneshjooArshad) azayeDaneshgah;
            if (daneshjooArshad.isDarkhastKhabgah()) {
                return daneshjooArshad.isDarkhastKhabgah();
            }
            daneshjooArshad.setDarkhastKhabgah(a > b);
        }
        return a > b;
    }


    public boolean sabtNomaratMovaghat(ArrayList<String> arrayList) {
        try {
            String idDaneshjoo = arrayList.get(0);
            String idDars = arrayList.get(2);
            String nomre = arrayList.get(4);
            Daneshjoo daneshjoo = null;
            Dars dars = null;
            for (AzayeDaneshgah i : AzayeDaneshgah.getAzayeDaneshgahs()) {
                if (i instanceof Daneshjoo && i.getId().equals(idDaneshjoo)) {
                    daneshjoo = (Daneshjoo) i;
                }
            }
            for (Dars i :
                    Dars.getDoros()) {
                if (i.getId().equals(idDars)) {
                    dars = i;
                }
            }
            if (!(dars == null) && !(daneshjoo == null)) {
                boolean a = true;
                for (Map.Entry<Dars, String> j :
                        daneshjoo.getListNomaratMovaghat().entrySet()) {
                    if (j.getKey() == dars) {
                        daneshjoo.getListNomaratMovaghat().replace(dars, nomre);
                        a = false;
                    }
                }
                if (a) {
                    daneshjoo.getListNomaratMovaghat().put(dars, nomre);
                }
                return true;
            }
        } catch (Exception e) {
            logger.error("error da tabe sabt nomarat movaghat" + e.getMessage());
            return false;
        }
        return false;
    }

    public boolean sabtNomaratNahayy(ArrayList<String> arrayList) {
        try {
            String idDaneshjoo = arrayList.get(0);
            String idDars = arrayList.get(2);
            String nomre = arrayList.get(4);
            Daneshjoo daneshjoo = null;
            Dars dars = null;
            for (AzayeDaneshgah i : AzayeDaneshgah.getAzayeDaneshgahs()) {
                if (i instanceof Daneshjoo && i.getId().equals(idDaneshjoo)) {
                    daneshjoo = (Daneshjoo) i;
                }
            }
            for (Dars i :
                    Dars.getDoros()) {
                if (i.getId().equals(idDars)) {
                    dars = i;
                }
            }
            if (!(dars == null) && !(daneshjoo == null)) {
                boolean a = true;
                for (Map.Entry<Dars, String> j :
                        daneshjoo.getListNomaratNahayy().entrySet()) {
                    if (j.getKey() == dars) {
                        daneshjoo.getListNomaratNahayy().replace(dars, nomre);
                        a = false;
                    }
                }
                if (a) {
                    daneshjoo.getListNomaratNahayy().put(dars, nomre);
                }
                return true;
            }
        } catch (Exception e) {
            logger.error("error da tabe sabt nomarat Nahayy" + e.getMessage());
            return false;
        }
        return false;
    }

    public ArrayList<String> getEterazDaneshjoo() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (azayeDaneshgah instanceof Ostad && !(azayeDaneshgah instanceof MoavenAmoozeshi)) {
            arrayList = ((Ostad) azayeDaneshgah).getEterazat();
        } else if (azayeDaneshgah instanceof MoavenAmoozeshi) {
            for (AzayeDaneshgah i :
                    AzayeDaneshgah.getAzayeDaneshgahs()) {
                if (i instanceof Ostad && ((Ostad) i).getDaneshKade().equals(((MoavenAmoozeshi) azayeDaneshgah).getDaneshKade())) {
                    for (String j : ((Ostad) i).getEterazat()) {
                        arrayList.add("ETERAZ :" + j);
                    }
                }
                if (i instanceof Daneshjoo && ((Daneshjoo) i).getDaneshKade().equals(((MoavenAmoozeshi) azayeDaneshgah).getDaneshKade())) {
                    for (String k :
                            ((Daneshjoo) i).getNatijeEteraz()) {
                        arrayList.add("PASOKH : " + k);
                    }
                }
            }
        }
        return arrayList;
    }

    public ArrayList<String> getPasokhOstad() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (azayeDaneshgah instanceof Daneshjoo) {
            arrayList = ((Daneshjoo) azayeDaneshgah).getNatijeEteraz();
        }
        return arrayList;
    }

    public String getKholaseDars(String id) {
        String a = "KHOLASE MOJOOD NIST";
        if (azayeDaneshgah instanceof MoavenAmoozeshi) {
            a = ((MoavenAmoozeshi) azayeDaneshgah).getKholaseDars(id);
        }
        return a;
    }

    public ArrayList<ArrayList<String>> getListDorosGerefteshodeDaneshjoo() {
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        if (azayeDaneshgah instanceof Daneshjoo) {
            arrayLists = ((Daneshjoo) azayeDaneshgah).getListDorosGozarande();
        }
        return arrayLists;
    }

    public ArrayList<ArrayList<String>> getVaziatTahsilyList() {
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        if (azayeDaneshgah instanceof MoavenAmoozeshi) {
            arrayLists = ((MoavenAmoozeshi) azayeDaneshgah).getVaziatTahsiliList();
        }
        return arrayLists;
    }

    public void setModelDaneshjoo(String moadel) {
        if (azayeDaneshgah instanceof Daneshjoo) {
            ((Daneshjoo) azayeDaneshgah).setMoadel(moadel);
        }
    }

    public ArrayList<String> getEtelatProfileDaneshjoo() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (azayeDaneshgah instanceof Daneshjoo) {
            arrayList.add(((Daneshjoo) azayeDaneshgah).getMoadel());
            arrayList.add(((Daneshjoo) azayeDaneshgah).getOstadRahnama().getName());
            arrayList.add(((Daneshjoo) azayeDaneshgah).getSaalVorod());
            arrayList.add(((Daneshjoo) azayeDaneshgah).getMaghtaDars().toString());
            arrayList.add(((Daneshjoo) azayeDaneshgah).getVazittahsily().toString());
        }
        return arrayList;
    }

    public ArrayList<String> getEtelatProlfileOstad() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (azayeDaneshgah instanceof Ostad) {
            arrayList.add(((Ostad) azayeDaneshgah).getShomareOtagh());
            arrayList.add(((Ostad) azayeDaneshgah).getDarajeOstadi().toString());
        }
        return arrayList;
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

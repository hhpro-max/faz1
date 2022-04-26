package LOGIC;

import java.util.ArrayList;
import java.util.Date;

public class Dars {
    public static ArrayList<Dars> doros = new ArrayList<>();

    String id;
    String name;
    String pishniaz;
    AzayeDaneshgah ostad;
    DaneshKade daneshkade;
    String tedadVahed;
    MaghtaDars maghtaDars;
    String zarfiat;
    ArrayList<RoozayeHafte> roozClassDars = new ArrayList<>();
    String saatClass;
    int month;
    int day;
    int year;
    String zamanEmtehanPayanterm = "";
    Date dateEmtehan;


    public Dars(String id, String name, String pishniaz, AzayeDaneshgah ostad, DaneshKade daneshkade, String tedadVahed, MaghtaDars maghtaDars, String zarfiat, ArrayList<RoozayeHafte> roozClassDars, String saatClass, String zamanEmtehanPayanterm) {
        this.id = id;
        this.name = name;
        this.pishniaz = pishniaz;
        this.ostad = ostad;
        this.daneshkade = daneshkade;
        this.tedadVahed = tedadVahed;
        this.maghtaDars = maghtaDars;
        this.zarfiat = zarfiat;
        this.roozClassDars = roozClassDars;
        this.saatClass = saatClass;
        this.zamanEmtehanPayanterm = zamanEmtehanPayanterm;
    }

    public boolean setTarikhEmtehan(){
        if (!zamanEmtehanPayanterm.isEmpty()){
            String[] tarikh = zamanEmtehanPayanterm.split(" ");
            try {
                year = Integer.parseInt(tarikh[0]);
                month =Integer.parseInt(tarikh[1]);
                day = Integer.parseInt(tarikh[2]);
                dateEmtehan = new Date(year,month,day);
                return true;
            }catch (Exception e){
                return false;
            }

        }
        return false;
    }



    public Date getDateEmtehan() {
        setTarikhEmtehan();
        return dateEmtehan;
    }

    public void setDateEmtehan(Date dateEmtehan) {
        this.dateEmtehan = dateEmtehan;
        setTarikhEmtehan();
    }

    public String getZamanEmtehanPayanterm() {
        setTarikhEmtehan();
        return "PAYANTERM"+" "+ zamanEmtehanPayanterm;
    }

    public void setZamanEmtehanPayanterm(String zamanEmtehanPayanterm) {
        this.zamanEmtehanPayanterm = zamanEmtehanPayanterm;
        setTarikhEmtehan();
    }

    public String getSaatClass() {
        return saatClass;
    }

    public void setSaatClass(String saatClass) {
        this.saatClass = saatClass;
    }

    public ArrayList<RoozayeHafte> getRoozClassDars() {
        return roozClassDars;
    }

    public void setRoozClassDars(ArrayList<RoozayeHafte> roozClassDars) {
        this.roozClassDars = roozClassDars;
    }

    public MaghtaDars getMaghtaDars() {
        return maghtaDars;
    }

    public void setMaghtaDars(MaghtaDars maghtaDars) {
        this.maghtaDars = maghtaDars;
    }

    public String getZarfiat() {
        return zarfiat;
    }

    public void setZarfiat(String zarfiat) {
        this.zarfiat = zarfiat;
    }

    public String getTedadVahed() {
        return tedadVahed;
    }

    public void setTedadVahed(String tedadVahed) {
        this.tedadVahed = tedadVahed;
    }

    public static ArrayList<Dars> getDoros() {
        return doros;
    }

    public static void setDoros(ArrayList<Dars> doros) {
        Dars.doros = doros;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPishniaz() {
        return pishniaz;
    }

    public void setPishniaz(String pishniaz) {
        this.pishniaz = pishniaz;
    }

    public AzayeDaneshgah getOstad() {
        return ostad;
    }

    public void setOstad(AzayeDaneshgah ostad) {
        this.ostad = ostad;
    }

    public DaneshKade getDaneshkade() {
        return daneshkade;
    }

    public void setDaneshkade(DaneshKade daneshkade) {
        this.daneshkade = daneshkade;
    }
}

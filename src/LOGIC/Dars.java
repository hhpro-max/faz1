package LOGIC;

import java.util.ArrayList;

public class Dars {
    public static ArrayList<Dars> doros = new ArrayList<>();

    String id;
    String name;
    String pishniaz;
    AzayeDaneshgah ostad;
    String daneshkade;

    public Dars(String id,
    String name,
    String pishniaz,
    AzayeDaneshgah ostad,
    String daneshkade){

        this.id=id;
        this.pishniaz=pishniaz;
        this.name=name;
        this.ostad=ostad;
        this.daneshkade=daneshkade;



        doros.add(this);
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

    public String getDaneshkade() {
        return daneshkade;
    }

    public void setDaneshkade(String daneshkade) {
        this.daneshkade = daneshkade;
    }
}

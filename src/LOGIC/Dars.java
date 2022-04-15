package LOGIC;

import java.util.ArrayList;

public class Dars {
    public static ArrayList<Dars> doros = new ArrayList<>();

    String id;
    String name;
    String pishniaz;
    AzayeDaneshgah ostad;
    DaneshKade daneshkade;
    String tedadVahed;
    MaghtaDars maghtaDars;
    int zarfiat;


    public Dars(String id,
    String name,
    String pishniaz,
    AzayeDaneshgah ostad,
    DaneshKade daneshkade,
                String tedadVahed,
                MaghtaDars maghtaDars,
                int zarfiat){

        this.id=id;
        this.pishniaz=pishniaz;
        this.name=name;
        this.ostad=ostad;
        this.daneshkade=daneshkade;
        this.tedadVahed=tedadVahed;
        this.maghtaDars=maghtaDars;
        this.zarfiat=zarfiat;



        doros.add(this);
    }


    public MaghtaDars getMaghtaDars() {
        return maghtaDars;
    }

    public void setMaghtaDars(MaghtaDars maghtaDars) {
        this.maghtaDars = maghtaDars;
    }

    public int getZarfiat() {
        return zarfiat;
    }

    public void setZarfiat(int zarfiat) {
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

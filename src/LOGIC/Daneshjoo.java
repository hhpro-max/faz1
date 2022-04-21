package LOGIC;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Daneshjoo extends AzayeDaneshgah{
    ArrayList<Dars> dars = new ArrayList<>();

    Vazittahsily vazittahsily;
    AzayeDaneshgah ostadRahnama;
    boolean mojavezSabtnam;
    String saatSabtnam;
    DaneshKade daneshKade;
    String moadel;
    ArrayList<ArrayList<String>> DarkhastTosieName = new ArrayList<>();
    Map<DaneshKade,ArrayList<Vaziat>> darkhastMinor = new HashMap<>();
    Map<Dars,String> listNomaratMovaghat = new HashMap<>();



    public Daneshjoo(String id, String pass, String name, ImageIcon akskarbar, String email,Vazittahsily vazittahsily,AzayeDaneshgah ostadRahnama,boolean mojavezSabtnam,String saatSabtnam) {
        super(id, pass, name, akskarbar, email);
        this.vazittahsily = vazittahsily;
        this.ostadRahnama = ostadRahnama;
        this.mojavezSabtnam = mojavezSabtnam;
        this.saatSabtnam=saatSabtnam;

    }


    public Map<Dars, String> getListNomaratMovaghat() {
        return listNomaratMovaghat;
    }

    public void setListNomaratMovaghat(Map<Dars, String> listNomaratMovaghat) {
        this.listNomaratMovaghat = listNomaratMovaghat;
    }

    public Map<DaneshKade, ArrayList<Vaziat>> getDarkhastMinor() {
        return darkhastMinor;
    }

    public void setDarkhastMinor(Map<DaneshKade, ArrayList<Vaziat>> darkhastMinor) {
        this.darkhastMinor = darkhastMinor;
    }

    public ArrayList<ArrayList<String>> getDarkhastTosieName() {
        return DarkhastTosieName;
    }

    public void setDarkhastTosieName(ArrayList<ArrayList<String>> darkhastTosieName) {
        DarkhastTosieName = darkhastTosieName;
    }

    public String getMoadel() {
        return moadel;
    }

    public void setMoadel(String moadel) {
        this.moadel = moadel;
    }

    public void setOstadRahnama(AzayeDaneshgah ostadRahnama) {
        this.ostadRahnama = ostadRahnama;
    }

    public DaneshKade getDaneshKade() {
        return daneshKade;
    }

    public void setDaneshKade(DaneshKade daneshKade) {
        this.daneshKade = daneshKade;
    }

    public ArrayList<Dars> getDars() {
        return dars;
    }

    public void setDars(ArrayList<Dars> dars) {
        this.dars = dars;
    }

    public Vazittahsily getVazittahsily() {
        return vazittahsily;
    }

    public void setVazittahsily(Vazittahsily vazittahsily) {
        this.vazittahsily = vazittahsily;
    }

    public AzayeDaneshgah getOstadRahnama() {
        return ostadRahnama;
    }

    public void setOstadRahnama(Ostad ostadRahnama) {
        this.ostadRahnama = ostadRahnama;
    }

    public boolean isMojavezSabtnam() {
        return mojavezSabtnam;
    }

    public void setMojavezSabtnam(boolean mojavezSabtnam) {
        this.mojavezSabtnam = mojavezSabtnam;
    }

    public String getSaatSabtnam() {
        return saatSabtnam;
    }

    public void setSaatSabtnam(String saatSabtnam) {
        this.saatSabtnam = saatSabtnam;
    }
}

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

    String moadel;
    String saalVorod;
    MaghtaDars maghtaDars;
    ArrayList<ArrayList<String>> DarkhastTosieName = new ArrayList<>();
    Map<DaneshKade,ArrayList<Vaziat>> darkhastMinor = new HashMap<>();
    Map<Dars,String> listNomaratMovaghat = new HashMap<>();
    Map<Dars,String> listNomaratNahayy = new HashMap<>();
    ArrayList<String> natijeEteraz = new ArrayList<>();
    ArrayList<ArrayList<String>> darkhastMinorData = new ArrayList<>();
    ArrayList<ArrayList<String>> darkhastEnserafData = new ArrayList<>();

    public Daneshjoo(String id, String pass, String name, ImageIcon akskarbar, String email, String kodMeli, String phoneNumber, DaneshKade daneshKade, Vazittahsily vazittahsily, AzayeDaneshgah ostadRahnama, boolean mojavezSabtnam, String saatSabtnam, String saalVorod, MaghtaDars maghtaDars) {
        super(id, pass, name, akskarbar, email, kodMeli, phoneNumber, daneshKade);
        this.vazittahsily = vazittahsily;
        this.ostadRahnama = ostadRahnama;
        this.mojavezSabtnam = mojavezSabtnam;
        this.saatSabtnam = saatSabtnam;
        this.saalVorod = saalVorod;
        this.maghtaDars = maghtaDars;
    }




    public ArrayList<ArrayList<String>> getListDorosGozarande(){
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        for (Dars i:
             dars) {
            arrayLists.add(new ArrayList<>());
            for (ArrayList<String> j:
                 arrayLists) {
                if (j.isEmpty()){
                    j.add(i.getId());
                    j.add(i.getName());
                    j.add(i.getTedadVahed());
                    try {
                        if (!(listNomaratNahayy.get(i) == null)) {
                            j.add(listNomaratNahayy.get(i));
                        }else {
                            j.add("N/A");
                        }
                    }catch (Exception e){

                    }

                }
            }
        }
        return arrayLists;
    }

    public MaghtaDars getMaghtaDars() {
        return maghtaDars;
    }

    public String getSaalVorod() {
        return saalVorod;
    }

    public void setSaalVorod(String saalVorod) {
        this.saalVorod = saalVorod;
    }

    public void setMaghtaDars(MaghtaDars maghtaDars) {
        this.maghtaDars = maghtaDars;
    }

    public Map<Dars, String> getListNomaratNahayy() {
        return listNomaratNahayy;
    }

    public void setListNomaratNahayy(Map<Dars, String> listNomaratNahayy) {
        this.listNomaratNahayy = listNomaratNahayy;
    }

    public ArrayList<ArrayList<String>> getDarkhastMinorData() {
        return darkhastMinorData;
    }

    public void setDarkhastMinorData(ArrayList<ArrayList<String>> darkhastMinorData) {
        this.darkhastMinorData = darkhastMinorData;
    }

    public ArrayList<ArrayList<String>> getDarkhastEnserafData() {
        return darkhastEnserafData;
    }

    public void setDarkhastEnserafData(ArrayList<ArrayList<String>> darkhastEnserafData) {
        this.darkhastEnserafData = darkhastEnserafData;
    }

    public ArrayList<String> getNatijeEteraz() {
        return natijeEteraz;
    }

    public void setNatijeEteraz(ArrayList<String> natijeEteraz) {
        this.natijeEteraz = natijeEteraz;
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

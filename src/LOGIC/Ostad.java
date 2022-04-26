package LOGIC;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ostad extends AzayeDaneshgah{

    DarajeOstadi darajeOstadi;
    String shomareOtagh;
    public Map<Daneshjoo,Vaziat> DarkhastTosieName = new HashMap<>();
    public ArrayList<Dars> darsha = new ArrayList<>();
    public ArrayList<String> eterazat = new ArrayList<>();

    public Ostad(String id, String pass, String name, ImageIcon akskarbar, String email, String kodMeli, String phoneNumber, DaneshKade daneshKade, DarajeOstadi darajeOstadi, String shomareOtagh) {
        super(id, pass, name, akskarbar, email, kodMeli, phoneNumber, daneshKade);
        this.darajeOstadi = darajeOstadi;
        this.shomareOtagh = shomareOtagh;
    }

    public ArrayList<ArrayList<String>> getListDaneshjoo(){
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        for (Dars i:
             darsha) {
            for (AzayeDaneshgah j:
                 AzayeDaneshgah.getAzayeDaneshgahs()) {
                if (j instanceof Daneshjoo){
                    for (Dars k:
                         ((Daneshjoo) j).getDars()) {
                        if (i.getId().equals(k.getId())){
                            arrayLists.add(new ArrayList<>());
                            for (ArrayList<String> l:
                                 arrayLists) {
                                if (l.isEmpty()){
                                    l.add(j.getId());
                                    l.add(j.getName());
                                    l.add(i.getId());
                                    l.add(i.getName());
                                    l.add(((Daneshjoo) j).getListNomaratMovaghat().get(i));
                                }
                            }
                        }
                    }
                }
            }
        }
        return arrayLists;
    }

    public String getShomareOtagh() {
        return shomareOtagh;
    }

    public void setShomareOtagh(String shomareOtagh) {
        this.shomareOtagh = shomareOtagh;
    }

    public ArrayList<String> getEterazat() {
        return eterazat;
    }

    public void setEterazat(ArrayList<String> eterazat) {
        this.eterazat = eterazat;
    }

    public ArrayList<Dars> getDarsha() {
        return darsha;
    }

    public void setDarsha(ArrayList<Dars> darsha) {
        this.darsha = darsha;
    }

    public Map<Daneshjoo, Vaziat> getDarkhastTosieName() {
        if (this.DarkhastTosieName == null){
            DarkhastTosieName = new HashMap<>();
        }
        return DarkhastTosieName;
    }

    public void setDarkhastTosieName(Map<Daneshjoo, Vaziat> darkhastTosieName) {
        DarkhastTosieName = darkhastTosieName;
    }



    public DarajeOstadi getDarajeOstadi() {
        return darajeOstadi;
    }

    public void setDarajeOstadi(DarajeOstadi darajeOstadi) {
        this.darajeOstadi = darajeOstadi;
    }


}

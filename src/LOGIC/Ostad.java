package LOGIC;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ostad extends AzayeDaneshgah{
    DaneshKade daneshKade;
    DarajeOstadi darajeOstadi;
    String shomareTamas;
    public Map<Daneshjoo,Vaziat> DarkhastTosieName = new HashMap<>();
    public ArrayList<Dars> darsha = new ArrayList<>();

    public Ostad(String id, String pass, String name, ImageIcon akskarbar, String email) {
        super(id, pass, name, akskarbar, email);

    }


    public ArrayList<Dars> getDarsha() {
        return darsha;
    }

    public void setDarsha(ArrayList<Dars> darsha) {
        this.darsha = darsha;
    }

    public Map<Daneshjoo, Vaziat> getDarkhastTosieName() {
        return DarkhastTosieName;
    }

    public void setDarkhastTosieName(Map<Daneshjoo, Vaziat> darkhastTosieName) {
        DarkhastTosieName = darkhastTosieName;
    }

    public DaneshKade getDaneshKade() {
        return daneshKade;
    }

    public void setDaneshKade(DaneshKade daneshKade) {
        this.daneshKade = daneshKade;
    }

    public DarajeOstadi getDarajeOstadi() {
        return darajeOstadi;
    }

    public void setDarajeOstadi(DarajeOstadi darajeOstadi) {
        this.darajeOstadi = darajeOstadi;
    }

    public String getShomareTamas() {
        return shomareTamas;
    }

    public void setShomareTamas(String shomareTamas) {
        this.shomareTamas = shomareTamas;
    }
}

package LOGIC;

import javax.swing.*;

public class Ostad extends AzayeDaneshgah{
    DaneshKade daneshKade;
    DarajeOstadi darajeOstadi;
    String shomareTamas;

    public Ostad(String id, String pass, String name, ImageIcon akskarbar, String email) {
        super(id, pass, name, akskarbar, email);
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

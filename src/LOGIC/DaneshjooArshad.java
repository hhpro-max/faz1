package LOGIC;

import javax.swing.*;

public class DaneshjooArshad extends Daneshjoo{

    boolean darkhastKhabgah = false;

    public DaneshjooArshad(String id, String pass, String name, ImageIcon akskarbar, String email, String kodMeli, String phoneNumber, DaneshKade daneshKade, Vazittahsily vazittahsily, AzayeDaneshgah ostadRahnama, boolean mojavezSabtnam, String saatSabtnam, String saalVorod, MaghtaDars maghtaDars) {
        super(id, pass, name, akskarbar, email, kodMeli, phoneNumber, daneshKade, vazittahsily, ostadRahnama, mojavezSabtnam, saatSabtnam, saalVorod, maghtaDars);
    }


    public boolean isDarkhastKhabgah() {
        return darkhastKhabgah;
    }

    public void setDarkhastKhabgah(boolean darkhastKhabgah) {
        this.darkhastKhabgah = darkhastKhabgah;
    }
}

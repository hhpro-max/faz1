package LOGIC;

import javax.swing.*;

public class DaneshjooArshad extends Daneshjoo{

    boolean darkhastKhabgah = false;
    public DaneshjooArshad(String id, String pass, String name, ImageIcon akskarbar, String email, Vazittahsily vazittahsily, AzayeDaneshgah ostadRahnama, boolean mojavezSabtnam, String saatSabtnam) {
        super(id, pass, name, akskarbar, email, vazittahsily, ostadRahnama, mojavezSabtnam, saatSabtnam);
    }

    public boolean isDarkhastKhabgah() {
        return darkhastKhabgah;
    }

    public void setDarkhastKhabgah(boolean darkhastKhabgah) {
        this.darkhastKhabgah = darkhastKhabgah;
    }
}

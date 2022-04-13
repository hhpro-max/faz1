package LOGIC;

import javax.swing.*;
import java.util.ArrayList;

public class Daneshjoo extends AzayeDaneshgah{
    ArrayList<Dars> dars = new ArrayList<>();

    Vazittahsily vazittahsily;
    Ostad ostadRahnama;
    boolean mojavezSabtnam;
    String saatSabtnam;

    public Daneshjoo(String id, String pass, String name, ImageIcon akskarbar, String email,Vazittahsily vazittahsily,Ostad ostadRahnama,boolean mojavezSabtnam,String saatSabtnam) {
        super(id, pass, name, akskarbar, email);
        this.vazittahsily = vazittahsily;
        this.ostadRahnama = ostadRahnama;
        this.mojavezSabtnam = mojavezSabtnam;
        this.saatSabtnam=saatSabtnam;
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

    public Ostad getOstadRahnama() {
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

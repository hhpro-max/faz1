package LOGIC;

import java.util.ArrayList;

public class Daneshjoo extends AzayeDaneshgah{
    ArrayList<Dars> dars = new ArrayList<>();

    Vazittahsily vazittahsily;
    Ostad ostadRahnama;
    boolean mojavezSabtnam;
    String saatSabtnam;





    public Daneshjoo(String id, String pass, String name) {
        super(id, pass, name);
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

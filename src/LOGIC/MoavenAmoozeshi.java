package LOGIC;

import javax.swing.*;

public class MoavenAmoozeshi extends Ostad{


    public MoavenAmoozeshi(String id, String pass, String name, ImageIcon akskarbar, String email) {
        super(id, pass, name, akskarbar, email);
    }

    public void addDaneshjoo(String id, String pass, String name,  ImageIcon aksKarbar,String email , Vazittahsily vazittahsily, Ostad ostadrahnama, boolean mojavezSabtnam, String saatSabtnam ){
        AzayeDaneshgah azayeDaneshgah = new Daneshjoo(id,pass,name,aksKarbar,email,vazittahsily,ostadrahnama,mojavezSabtnam,saatSabtnam);
    }
    public void addOstad(String id, String pass, String name, ImageIcon akskarbar, String email){
        AzayeDaneshgah azayeDaneshgah = new Ostad(id, pass, name, akskarbar, email);
    }
}

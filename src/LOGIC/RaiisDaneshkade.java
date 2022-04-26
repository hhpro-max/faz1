package LOGIC;

import javax.swing.*;

public class RaiisDaneshkade extends Ostad{


    public RaiisDaneshkade(String id, String pass, String name, ImageIcon akskarbar, String email, String kodMeli, String phoneNumber, DaneshKade daneshKade, DarajeOstadi darajeOstadi, String shomareOtagh) {
        super(id, pass, name, akskarbar, email, kodMeli, phoneNumber, daneshKade, darajeOstadi, shomareOtagh);
    }

    public boolean deleteOstad(String id){
        for (AzayeDaneshgah i:
             AzayeDaneshgah.getAzayeDaneshgahs()) {
            if (i.getId().equals(id) && i instanceof Ostad && i.getDaneshKade().equals(this.daneshKade)){
                AzayeDaneshgah.getAzayeDaneshgahs().remove(i);
                return true;
            }
        }
        return false;
    }
    public void addOstad(String id, String pass, String name, ImageIcon akskarbar, String email,String kMeli,String pNumber,DarajeOstadi darajeOstadi1,String shOtagh){
        AzayeDaneshgah azayeDaneshgah = new Ostad(id, pass, name, akskarbar, email,kMeli,pNumber,this.daneshKade,darajeOstadi1,shOtagh);
    }

    public boolean upGradetoMoaven(String id){
        MoavenAmoozeshi moavenAmoozeshi;
        for (AzayeDaneshgah i:
             AzayeDaneshgah.getAzayeDaneshgahs()) {
            if (i instanceof MoavenAmoozeshi){
                AzayeDaneshgah.getAzayeDaneshgahs().remove(i);
                break;
            }
        }
        for (AzayeDaneshgah j:
             AzayeDaneshgah.getAzayeDaneshgahs()) {
            if (j.getId().equals(id) && j instanceof Ostad && !(j instanceof RaiisDaneshkade)){
                moavenAmoozeshi = new MoavenAmoozeshi(j.getId(),j.getPass(),j.getName(),j.getAkskarbar(),j.getEmail(),j.getKodMeli(),j.getPhoneNumber(),j.getDaneshKade(),((Ostad) j).getDarajeOstadi(),((Ostad) j).getShomareOtagh());
                AzayeDaneshgah.getAzayeDaneshgahs().remove(j);
                return true;
            }
        }
        return false;
    }

    public boolean virayeshOstad(String id, String pass, String name, ImageIcon akskarbar, String email){
        String password;
        String esm;
        ImageIcon aks;
        String gmail;
        AzayeDaneshgah azayeDaneshgah = null;
        for (AzayeDaneshgah i:
             AzayeDaneshgah.getAzayeDaneshgahs()) {
            if (i.getId().equals(id) && i instanceof Ostad){
                azayeDaneshgah = i;
                break;
            }
        }
        if (!(azayeDaneshgah == null)) {
            if (pass.isEmpty()){
                password = azayeDaneshgah.getPass();
            }
            else {
                password = pass;
            }
            if (name.isEmpty()){
                esm = azayeDaneshgah.getName();
            }else {
                esm = name;
            }
            if (akskarbar == null){
                aks = azayeDaneshgah.getAkskarbar();
            }
            else {
                aks = akskarbar;
            }if (email.isEmpty()){
                gmail = azayeDaneshgah.getEmail();
            }else {
                gmail=email;
            }
        }else {
            return false;
        }
        azayeDaneshgah.setName(esm);
        azayeDaneshgah.setAkskarbar(aks);
        azayeDaneshgah.setEmail(gmail);
        azayeDaneshgah.setPass(password);
        return true;
    }
    public void addDaneshjoo(String id, String pass, String name, ImageIcon aksKarbar, String email,String kMeli,String pNumber , Vazittahsily vazittahsily, AzayeDaneshgah ostadrahnama, boolean mojavezSabtnam, String saatSabtnam,String sVorod,MaghtaDars maghtaDars1 ){
        AzayeDaneshgah azayeDaneshgah = new Daneshjoo(id,pass,name,aksKarbar,email,kMeli,pNumber,this.daneshKade,vazittahsily,ostadrahnama,mojavezSabtnam,saatSabtnam,sVorod,maghtaDars1);
    }
}

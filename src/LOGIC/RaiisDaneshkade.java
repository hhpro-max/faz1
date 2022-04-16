package LOGIC;

import javax.swing.*;

public class RaiisDaneshkade extends Ostad{


    public RaiisDaneshkade(String id, String pass, String name, ImageIcon akskarbar, String email) {
        super(id, pass, name, akskarbar, email);
    }

    public boolean deleteOstad(String id){//todo if(this.daneshkade == i.getdaneshkade)
        for (AzayeDaneshgah i:
             AzayeDaneshgah.getAzayeDaneshgahs()) {
            if (i.getId().equals(id) && i instanceof Ostad){
                AzayeDaneshgah.getAzayeDaneshgahs().remove(i);
                return true;
            }
        }
        return false;
    }
    public void addOstad(String id, String pass, String name, ImageIcon akskarbar, String email){
        AzayeDaneshgah ostad= new Ostad(id, pass, name, akskarbar, email);
    }

    public boolean upGradetoMoaven(String id){
        MoavenAmoozeshi moavenAmoozeshi;
        for (AzayeDaneshgah i:
             AzayeDaneshgah.getAzayeDaneshgahs()) {
            if (i instanceof MoavenAmoozeshi){
                return false;
            }
        }
        for (AzayeDaneshgah j:
             AzayeDaneshgah.getAzayeDaneshgahs()) {
            if (j.getId().equals(id) && j instanceof Ostad && !(j instanceof RaiisDaneshkade)){
                moavenAmoozeshi = new MoavenAmoozeshi(j.getId(),j.getPass(),j.getName(),j.getAkskarbar(),j.getEmail());
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
        azayeDaneshgah.setEmail(email);
        azayeDaneshgah.setPass(password);
        return true;
    }
}

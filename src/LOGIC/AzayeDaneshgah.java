package LOGIC;

import RESOURCES.ImageResource;
import RESOURCES.ResourceManager;

import javax.swing.*;
import java.util.ArrayList;

public class AzayeDaneshgah {
    public static ArrayList<AzayeDaneshgah> azayeDaneshgahs = new ArrayList<>();

    public String id;
    public String pass;
    public String name;
    public String akharinzamanvorood = "0";
    public ImageIcon akskarbar = null;
    public String email;
    public String kodMeli;
    public String phoneNumber;
    DaneshKade daneshKade;

    public AzayeDaneshgah(String id,String pass,String name,ImageIcon akskarbar,String email){
        this.id=id;
        this.pass=pass;
        this.name=name;
        this.akskarbar = akskarbar;
        this.email = email;
        azayeDaneshgahs.add(this);
    }


    public DaneshKade getDaneshKade() {
        return daneshKade;
    }

    public void setDaneshKade(DaneshKade daneshKade) {
        this.daneshKade = daneshKade;
    }

    public String getKodMeli() {
        return kodMeli;
    }

    public void setKodMeli(String kodMeli) {
        this.kodMeli = kodMeli;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static ArrayList<AzayeDaneshgah> getAzayeDaneshgahs() {
        return azayeDaneshgahs;
    }

    public static void setAzayeDaneshgahs(ArrayList<AzayeDaneshgah> azayeDaneshgahs) {
        AzayeDaneshgah.azayeDaneshgahs = azayeDaneshgahs;
    }


    public ImageIcon getAkskarbar() {

        if (akskarbar == null){
            ImageIcon imageIcon = new ImageIcon(ResourceManager.get(ImageResource.NULL_PROFILE));
            return imageIcon ;
        }
        return akskarbar;
    }

    public void setAkskarbar(ImageIcon akskarbar) {
        this.akskarbar = akskarbar;
    }

    public String getAkharinzamanvorood() {
        return akharinzamanvorood;
    }

    public void setAkharinzamanvorood(String akharinzamanvorood) {
        this.akharinzamanvorood = akharinzamanvorood;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

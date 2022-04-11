package LOGIC;

import javax.swing.*;
import java.util.ArrayList;

public class AzayeDaneshgah {
    public static ArrayList<AzayeDaneshgah> azayeDaneshgahs = new ArrayList<>();

    public String id;
    public String pass;
    public String name;
    public String akharinzamanvorood;
    public ImageIcon akskarbar;
    public String email;

    public AzayeDaneshgah(String id,String pass,String name){
        this.id=id;
        this.pass=pass;
        this.name=name;
        azayeDaneshgahs.add(this);
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

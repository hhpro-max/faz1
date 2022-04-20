package LOGIC;

import javax.swing.*;
import java.util.ArrayList;

public class MoavenAmoozeshi extends Ostad{
    ArrayList<Daneshjoo> daneshjooDarkhastMinor = new ArrayList<>();
    ArrayList<Daneshjoo> daneshjooDarkhastEnseraf = new ArrayList<>();

    public MoavenAmoozeshi(String id, String pass, String name, ImageIcon akskarbar, String email) {
        super(id, pass, name, akskarbar, email);
    }

    public void addDaneshjoo(String id, String pass, String name,  ImageIcon aksKarbar,String email , Vazittahsily vazittahsily, AzayeDaneshgah ostadrahnama, boolean mojavezSabtnam, String saatSabtnam ){
        AzayeDaneshgah azayeDaneshgah = new Daneshjoo(id,pass,name,aksKarbar,email,vazittahsily,ostadrahnama,mojavezSabtnam,saatSabtnam);
    }
    public void addOstad(String id, String pass, String name, ImageIcon akskarbar, String email){
        AzayeDaneshgah azayeDaneshgah = new Ostad(id, pass, name, akskarbar, email);
    }
    public boolean hazfDars(String id){
        for (Dars i:
             Dars.getDoros()) {
            if (i.getId().equals(id)){
                Dars.getDoros().remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean addDars(String id,
                           String name,
                           String pishniaz,
                           AzayeDaneshgah ostad,
                           DaneshKade daneshkade,
                           String tedadVahed,
                           MaghtaDars maghtaDars,
                           String zarfiat){
        try {
            Dars dars = new Dars(id,name,pishniaz,ostad,daneshkade,tedadVahed,maghtaDars,zarfiat);
            return true;
        }catch (Exception e){

            return false;
        }

    }

    public boolean virayeshDars(String id,
                                String name,
                                String pishniaz,
                                AzayeDaneshgah ostad,
                                DaneshKade daneshkade,
                                String tedadVahed,
                                MaghtaDars maghtaDars,
                                String zarfiat){
        Dars dars = null;
        String nameDars;
        String pishniazDars;
        AzayeDaneshgah ostadDars = null;
        DaneshKade daneshKadeDars = null;
        MaghtaDars maghtaDars1 = null;
        String tedadVahedDars;
        String zarfiatDars;
        for (Dars i:
             Dars.getDoros()) {
            if (id.equals(i.getId())){
                dars = i;
                break;
            }
        }
        if (!(dars == null)){
            if (name.isEmpty()){
                nameDars = dars.getName();
            }
            else {
                nameDars = name;
            }
            if (pishniaz.isEmpty()){
                pishniazDars = dars.getPishniaz();
            }else {
                pishniazDars = pishniaz;
            }
            if (ostad == null){
                ostadDars = dars.getOstad();
            }else {
                ostadDars = ostad;
            }
            if (daneshkade == null){
                daneshKadeDars = dars.getDaneshkade();
            }
            else {
                daneshKadeDars = daneshkade;
            }
            if (tedadVahed.isEmpty()){
                tedadVahedDars = dars.getTedadVahed();
            }
            else {
                tedadVahedDars = tedadVahed;
            }
            if (maghtaDars == null){
                maghtaDars1 = dars.getMaghtaDars();
            }
            else {
                maghtaDars1 = maghtaDars;
            }
            if (zarfiat.isEmpty()){
                zarfiatDars = dars.getZarfiat();
            }
            else {
                zarfiatDars = zarfiat;
            }

        }
        else {
            return false;
        }
        dars.setName(nameDars);
        dars.setZarfiat(zarfiatDars);
        dars.setMaghtaDars(maghtaDars1);
        dars.setDaneshkade(daneshKadeDars);
        dars.setOstad(ostadDars);
        dars.setPishniaz(pishniazDars);
        dars.setTedadVahed(tedadVahedDars);
        return true;


    }

    public ArrayList<Daneshjoo> getDaneshjooDarkhastEnseraf() {
        return daneshjooDarkhastEnseraf;
    }

    public void setDaneshjooDarkhastEnseraf(ArrayList<Daneshjoo> daneshjooDarkhastEnseraf) {
        this.daneshjooDarkhastEnseraf = daneshjooDarkhastEnseraf;
    }

    public ArrayList<Daneshjoo> getDaneshjooDarkhastMinor() {
        return daneshjooDarkhastMinor;
    }

    public void setDaneshjooDarkhastMinor(ArrayList<Daneshjoo> daneshjooDarkhastMinor) {
        this.daneshjooDarkhastMinor = daneshjooDarkhastMinor;
    }
}

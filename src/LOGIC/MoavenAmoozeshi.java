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
    public boolean hazfDaneshjooEnserafi(String id){
        for (Daneshjoo i:
             daneshjooDarkhastEnseraf) {
            if (i.getId().equals(id)){
                daneshjooDarkhastEnseraf.remove(i);
                AzayeDaneshgah.getAzayeDaneshgahs().remove(i);
                return true;
            }
        }
        return false;
    }
    public ArrayList<ArrayList<String>> checkDaneshjooha(){
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        for (AzayeDaneshgah i:
             AzayeDaneshgah.getAzayeDaneshgahs()) {
            if (i instanceof Daneshjoo && ((Daneshjoo) i).getDaneshKade().equals(this.getDaneshKade())){
                for (Dars j:
                     ((Daneshjoo) i).getDars()) {
                    arrayLists.add(new ArrayList<>());
                    for (ArrayList<String> l:
                            arrayLists) {
                        if (l.isEmpty()){
                            l.add(i.getId());
                            l.add(i.getName());
                            l.add(j.getOstad().getId());
                            l.add(j.getOstad().getName());
                            l.add(j.getId());
                            l.add(j.getName());
                            l.add(((Daneshjoo) i).getListNomaratMovaghat().get(j));

                        }
                    }
                }
            }
        }
        return arrayLists;
    }
    public String getKholaseDars(String id){
        String moadelkol1 = "0.0";
        String modelbeddonfail1 = " 0.0";
        String passshodeha = "0";
        String failshodeha = "0";
        ArrayList<String> nomarat = new ArrayList<>();
        int passed = 0;
        int failed = 0;
        double sum = 0.0;
        double sumbedoonfail = 0.0;
        double counterbedoonfail = 0.0;
        double modelbedonfail = 0.0;
        double counter = 0.0;
        double moadelkol = 0.0;
        Dars dars =null;
        for (Dars i:
             Dars.getDoros()) {
            if (i.getId().equals(id)){
                dars = i;
                break;
            }
        }
        if (!(dars == null)){
            for (AzayeDaneshgah i:
                 AzayeDaneshgah.getAzayeDaneshgahs()) {
                if (i instanceof Daneshjoo){
                    try {
                      nomarat.add(((Daneshjoo) i).getListNomaratMovaghat().get(dars));
                    }catch (Exception e){
                        continue;
                    }

                }
            }
            for (String j:
                 nomarat) {
                if (!(j == null)){
                    counter++;
                    double a = Double.parseDouble(j);
                    sum = sum + a;
                    if (a >= 10.0){
                        passed++;
                        counterbedoonfail++;
                        sumbedoonfail = sumbedoonfail + a;
                    }else {
                        failed++;
                    }
                }
            }
            if (!(counter == 0)){
                moadelkol = sum /counter;
                moadelkol1 = String.valueOf(moadelkol);
            }
            if (!(counterbedoonfail == 0)){
                modelbedonfail = sumbedoonfail / counterbedoonfail;
                modelbeddonfail1 = String.valueOf(modelbedonfail);
            }
            passshodeha = String.valueOf(passed);
            failshodeha = String.valueOf(failed);
        }
        return "MODEL KOL DARS : "+moadelkol1+" TEDAD GHABOOLI HA :"+ passshodeha + "\n TEDAD MARDOODIA : "+ failshodeha+" MOADEL BEDOON DARNAZAR GRFTN MARDOODI : " + modelbeddonfail1;
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

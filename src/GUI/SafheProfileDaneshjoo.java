package GUI;



import LOGIC.Controller;

import javax.swing.*;
import java.util.ArrayList;

public class SafheProfileDaneshjoo extends SafheProfileAza{
    SafheVaziatTahsiliDaneshjoo safheVaziatTahsiliDaneshjoo;
    JLabel moadel1;
    JLabel moadel2;
    JLabel ostadRahanama1;
    JLabel ostadRahanama2;
    JLabel salVorod1;
    JLabel salVorod2;
    JLabel maghta1;
    JLabel maghta2;
    JLabel vaziat1;
    JLabel vaziat2;

    public SafheProfileDaneshjoo() {
        super();
        safheVaziatTahsiliDaneshjoo = new SafheVaziatTahsiliDaneshjoo();
        initEzafia();
        alignEzafia();
        GuiController.getInstance().addJpannel(this);
    }
    public void initEzafia(){
        ArrayList<String> arrayList = Controller.getInstance().getEtelatProfileDaneshjoo();
        moadel1 = new JLabel("MOADEL KOL :");
        moadel2 = new JLabel(arrayList.get(0));
        ostadRahanama1 = new JLabel("OSTAD RAHNAMA :");
        ostadRahanama2 = new JLabel(arrayList.get(1));
        salVorod1 = new JLabel("SAL VOROOD :");
        salVorod2 =new JLabel(arrayList.get(2));
        maghta1 = new JLabel("MAGHTA :");
        maghta2 = new JLabel(arrayList.get(3));
        vaziat1 = new JLabel("VAZIAT :");
        vaziat2 = new JLabel(arrayList.get(4));
    }
    public void alignEzafia(){
        moadel1.setBounds(10,600,200,30);
        moadel2.setBounds(200,600,150,30);
        this.add(moadel1);
        this.add(moadel2);
        ostadRahanama1.setBounds(500,300,200,30);
        ostadRahanama2.setBounds(650,300,200,30);
        this.add(ostadRahanama1);
        this.add(ostadRahanama2);
        salVorod1.setBounds(500,400,200,30);
        salVorod2.setBounds(650,400,200,30);
        this.add(salVorod1);
        this.add(salVorod2);
        maghta1.setBounds(500,500,200,30);
        maghta2.setBounds(650,500,200,30);
        this.add(maghta1);
        this.add(maghta2);
        vaziat1.setBounds(500,600,200,30);
        vaziat2.setBounds(650,600,200,30);
        this.add(vaziat1);
        this.add(vaziat2);
    }
}

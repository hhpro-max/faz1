package GUI;

import LOGIC.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SafheProfileOstad extends SafheProfileAza{
    JLabel shomareOtagh1;
    JLabel shomareOtagh2;
    JLabel darakeOstadi1;
    JLabel darakeOstadi2;



    public SafheProfileOstad() {
        super();
        initEzafia();
        alignEzafia();

        GuiController.getInstance().addJpannel(this);
    }
    public void initEzafia(){
        ArrayList<String> arrayList = Controller.getInstance().getEtelatProlfileOstad();
        shomareOtagh1 = new JLabel("SHOMARE OTAGH :");
        shomareOtagh2 = new JLabel(arrayList.get(0));
        darakeOstadi1 = new JLabel("DARAJE OSTADI :");
        darakeOstadi2 =new JLabel(arrayList.get(1));


    }
    public void alignEzafia(){
        shomareOtagh1.setBounds(500,300,200,30);
        shomareOtagh2.setBounds(650,300,200,30);
        this.add(shomareOtagh1);
        this.add(shomareOtagh2);
        darakeOstadi1.setBounds(500,400,200,30);
        darakeOstadi2.setBounds(650,400,200,30);
        this.add(darakeOstadi1);
        this.add(darakeOstadi2);
    }

}

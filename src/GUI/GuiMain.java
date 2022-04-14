package GUI;

import LOGIC.*;
import RESOURCES.ImageResource;
import RESOURCES.ResourceManager;

import javax.swing.*;

public class GuiMain {
    public static void main(String[] args) {
        Ostad ostad = new Ostad("000","000","hossein",new ImageIcon(ResourceManager.get(ImageResource.CAPCHA1)),"freakthisLife@gmail.com");

        Dars chom1 = new Dars("110","riazi1",null,ostad,"riazi");
        Dars chom2 = new Dars("111","riazi2","110",ostad,"riazi");
        Dars chom3 = new Dars("112","riazi3","111",ostad,"riazi");
        Daneshjoo daneshjoo = new Daneshjoo("0","0","sehat",new ImageIcon(ResourceManager.get(ImageResource.CAPCHA2)),"betoche@gmail.com",Vazittahsily.DARHALTAHSIL,ostad,false,"9:00" );
        MoavenAmoozeshi moavenAmoozeshi = new MoavenAmoozeshi("00","00","ali",null,"felanale@rrr.com");

        moavenAmoozeshi.addDaneshjoo("1","1","nasehat",new ImageIcon(ResourceManager.get(ImageResource.CAPCHA3)),"betoche@gmail.com",Vazittahsily.DARHALTAHSIL,ostad,false,"9:00" );
        moavenAmoozeshi.addDaneshjoo("2","2","bisehat",new ImageIcon(ResourceManager.get(ImageResource.CAPCHA4)),"betoche@gmail.com",Vazittahsily.DARHALTAHSIL,ostad,false,"9:00" );


        MainFrame mainFrame = new MainFrame();
        GuiController.setFrame(mainFrame);
    }
}

package GUI;

import LOGIC.*;
import RESOURCES.ImageResource;
import RESOURCES.ResourceManager;

import javax.swing.*;
import java.util.ArrayList;

public class GuiMain {
    public static void main(String[] args) {
        Ostad ostad = new Ostad("000","000","hossein",new ImageIcon(ResourceManager.get(ImageResource.CAPCHA1)),"freakthisLife@gmail.com");

        Dars chom1 = new Dars("110","riazi1",null,ostad,DaneshKade.RIAZI,"2",MaghtaDars.KARSHENASI,"20");

        chom1.getRoozClassDars().add(RoozayeHafte.DOSHANBE);
        chom1.getRoozClassDars().add(RoozayeHafte.CHARSHANBE);
        chom1.setSaatClass("9");
        chom1.setZamanEmtehanPayanterm("1401 11 12");
        Dars chom2 = new Dars("111","riazi2","110",ostad,DaneshKade.RIAZI,"3",MaghtaDars.KARSHENASI,"30");
        Dars chom3 = new Dars("112","riazi3","111",ostad,DaneshKade.RIAZI,"4",MaghtaDars.KARSHENASI,"40");
        chom2.getRoozClassDars().add(RoozayeHafte.SHANBE);
        chom2.getRoozClassDars().add(RoozayeHafte.JOME);
        chom2.setSaatClass("1.5");
        chom2.setZamanEmtehanPayanterm("1401 11 10");
        chom3.getRoozClassDars().add(RoozayeHafte.YEKSHANBE);
        chom3.getRoozClassDars().add(RoozayeHafte.PANJSHANBE);
        chom3.setSaatClass("3");
        chom3.setZamanEmtehanPayanterm("1401 10 10");
        Daneshjoo daneshjoo = new Daneshjoo("0","0","sehat",new ImageIcon(ResourceManager.get(ImageResource.CAPCHA2)),"betoche@gmail.com",Vazittahsily.DARHALTAHSIL,ostad,false,"9:00" );
        MoavenAmoozeshi moavenAmoozeshi = new MoavenAmoozeshi("00","00","ali",null,"felanale@rrr.com");
        daneshjoo.setDaneshKade(DaneshKade.OMRAN);
        daneshjoo.setMoadel("15.5");
        daneshjoo.getDars().add(chom1);
        daneshjoo.getDars().add(chom2);
        daneshjoo.getDars().add(chom3);
        RaiisDaneshkade raiisDaneshkade = new RaiisDaneshkade("1","1","raiisjoon",null,"wth@grail.com");
        moavenAmoozeshi.addDaneshjoo("3","3","nasehat",new ImageIcon(ResourceManager.get(ImageResource.CAPCHA3)),"betoche@gmail.com",Vazittahsily.DARHALTAHSIL,ostad,false,"9:00" );
        moavenAmoozeshi.addDaneshjoo("2","2","bisehat",new ImageIcon(ResourceManager.get(ImageResource.CAPCHA4)),"betoche@gmail.com",Vazittahsily.DARHALTAHSIL,ostad,false,"9:00" );

        moavenAmoozeshi.setDaneshKade(DaneshKade.OMRAN);
        MainFrame mainFrame = new MainFrame();
        GuiController.setFrame(mainFrame);
    }
}

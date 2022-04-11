package GUI;

import LOGIC.AzayeDaneshgah;
import LOGIC.Daneshjoo;
import LOGIC.Ostad;
import LOGIC.Vazittahsily;
import RESOURCES.ImageResource;
import RESOURCES.ResourceManager;

import javax.swing.*;

public class GuiMain {
    public static void main(String[] args) {
        Ostad ostad = new Ostad("0000","0000","hossein");
        ostad.setAkskarbar(new ImageIcon(ResourceManager.get(ImageResource.CAPCHA1)));
        ostad.setEmail("freakthisLife@gmail.com");
        Daneshjoo daneshjoo = new Daneshjoo("0","0","sehat");
        daneshjoo.setVazittahsily(Vazittahsily.DARHALTAHSIL);
        daneshjoo.setOstadRahnama(ostad);
        daneshjoo.setMojavezSabtnam(true);
        daneshjoo.setSaatSabtnam("9:00");
        MainFrame mainFrame = new MainFrame();
        GuiController.setFrame(mainFrame);
    }
}

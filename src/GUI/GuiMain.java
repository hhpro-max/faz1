package GUI;

import LOGIC.AzayeDaneshgah;
import LOGIC.Ostad;
import RESOURCES.ImageResource;
import RESOURCES.ResourceManager;

import javax.swing.*;

public class GuiMain {
    public static void main(String[] args) {
        Ostad ostad = new Ostad("0000","0000","hossein");
        ostad.setAkskarbar(new ImageIcon(ResourceManager.get(ImageResource.CAPCHA1)));
        ostad.setEmail("freakthisLife@gmail.com");
        MainFrame mainFrame = new MainFrame();
        GuiController.setFrame(mainFrame);
    }
}

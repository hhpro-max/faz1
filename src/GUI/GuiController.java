package GUI;



import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GuiController {
    public static Frame frame;

    public static ArrayList<JPanel> jPanels = new ArrayList<>();


    public static GuiController guiController;
    private GuiController(){

    }
    public static GuiController getInstance(){
        if (guiController==null){
            guiController = new GuiController();
        }
        return guiController;
    }


    public void resetJpanels(){
        for (JPanel i:
             jPanels) {
            i.setVisible(false);
        }
        //jPanels.clear();

    }


    public void addJpannel(JPanel jPanel){
        jPanels.add(jPanel);
    }


    public static Frame getFrame() {
        return frame;
    }

    public static void setFrame(Frame frame) {
        GuiController.frame = frame;
    }
}

package GUI;



import java.awt.*;

public class GuiController {
    public static Frame frame;



    public static GuiController guiController;
    private GuiController(){

    }
    public static GuiController getInstance(){
        if (guiController==null){
            guiController = new GuiController();
        }
        return guiController;
    }





    public static Frame getFrame() {
        return frame;
    }

    public static void setFrame(Frame frame) {
        GuiController.frame = frame;
    }
}

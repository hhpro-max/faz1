package GUI;

import javax.swing.*;

public class SafheMoaven extends SafheOstad{

    JMenu sabtkarbar;

    public SafheMoaven(){
        super();
        initEzafi();
    }
    public void initEzafi(){
        sabtkarbar = new JMenu("SABT KARBAR");
        jMenuBar.add(sabtkarbar);
    }
}

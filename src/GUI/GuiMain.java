package GUI;

import LOGIC.*;
import RESOURCES.ImageResource;
import RESOURCES.ResourceManager;
import com.google.gson.Gson;

import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GuiMain {
    public static void main(String[] args) {
        String fileDk99 = "src/EDUFILES/dk99.json";
        String fileDk98 = "src/EDUFILES/dk98.json";
        String fileDa97 = "src/EDUFILES/da97.json";
        String fileDa96 = "src/EDUFILES/da96.json";
        String fileDd95 = "src/EDUFILES/dd95.json";
        String fileDd94 = "src/EDUFILES/dd94.json";

        String fileOs00 = "src/EDUFILES/os00.json";
        String fileOs01 = "src/EDUFILES/os01.json";
        String fileMa00 = "src/EDUFILES/ma00.json";
        String fileMa01 = "src/EDUFILES/ma01.json";
        String fileRd00 = "src/EDUFILES/rd00.json";
        String fileRd01 = "src/EDUFILES/rd01.json";

        String dars1 = "src/EDUFILES/darsStatic.json";
        String dars2 = "src/EDUFILES/darsMoghavematMasaleh.json";
        String dars3 = "src/EDUFILES/darsshimi1.json";
        String dars4 = "src/EDUFILES/darsshimi2.json";
        String dars5 = "src/EDUFILES/darsriazi1.json";
        String dars6 = "src/EDUFILES/darsriazi2.json";
        String dars7 = "src/EDUFILES/darsfizik1.json";
        String dars8 = "src/EDUFILES/darsfizik2.json";
        String dars9 = "src/EDUFILES/darsmadarmanteghii.json";
        String dars10 = "src/EDUFILES/darscompiler.json";

        Gson gson = new Gson();

        Daneshjoo daneshjoo = gson.fromJson(readFileAsString(fileDk99),Daneshjoo.class);
        Daneshjoo daneshjoo1 = gson.fromJson(readFileAsString(fileDk98),Daneshjoo.class);
        DaneshjooArshad daneshjooArshad = gson.fromJson(readFileAsString(fileDa97),DaneshjooArshad.class);
        DaneshjooArshad daneshjooArshad1 = gson.fromJson(readFileAsString(fileDa96),DaneshjooArshad.class);
        DaneshjooDoctor daneshjooDoctor = gson.fromJson(readFileAsString(fileDd95),DaneshjooDoctor.class);
        DaneshjooDoctor daneshjooDoctor1 = gson.fromJson(readFileAsString(fileDd94),DaneshjooDoctor.class);

        Ostad ostad = gson.fromJson(readFileAsString(fileOs00),Ostad.class);
        Ostad ostad1 = gson.fromJson(readFileAsString(fileOs01),Ostad.class);
        MoavenAmoozeshi moavenAmoozeshi = gson.fromJson(readFileAsString(fileMa00),MoavenAmoozeshi.class);
        MoavenAmoozeshi moavenAmoozeshi1 = gson.fromJson(readFileAsString(fileMa01),MoavenAmoozeshi.class);
        RaiisDaneshkade raiisDaneshkade = gson.fromJson(readFileAsString(fileRd00),RaiisDaneshkade.class);
        RaiisDaneshkade raiisDaneshkade1 = gson.fromJson(readFileAsString(fileRd01),RaiisDaneshkade.class);

        Dars dars11 = gson.fromJson(readFileAsString(dars1),Dars.class);
        Dars dars12 = gson.fromJson(readFileAsString(dars2),Dars.class);
        Dars dars13 = gson.fromJson(readFileAsString(dars3),Dars.class);
        Dars dars14 = gson.fromJson(readFileAsString(dars4),Dars.class);
        Dars dars15 = gson.fromJson(readFileAsString(dars5),Dars.class);
        Dars dars16 = gson.fromJson(readFileAsString(dars6),Dars.class);
        Dars dars17 = gson.fromJson(readFileAsString(dars7),Dars.class);
        Dars dars18 = gson.fromJson(readFileAsString(dars8),Dars.class);
        Dars dars19 = gson.fromJson(readFileAsString(dars9),Dars.class);
        Dars dars110 = gson.fromJson(readFileAsString(dars10),Dars.class);

        daneshjoo.getDars().add(dars11);
        daneshjoo.getDars().add(dars12);
        daneshjoo1.getDars().add(dars13);
        daneshjoo1.getDars().add(dars14);
        AzayeDaneshgah.getAzayeDaneshgahs().add(daneshjoo);

        Dars.getDoros().add(dars11);
        Dars.getDoros().add(dars12);










        MainFrame mainFrame = new MainFrame();
        GuiController.setFrame(mainFrame);
    }
    public static String readFileAsString(String file)
    {   String str = "";
        try {
            str = new String(Files.readAllBytes(Paths.get(file)));
        }catch (Exception e){

        }
        return str;
    }
}

import LOGIC.*;
import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        /*Emtehan emtehan = new Emtehan("hossein","hashemi",21,true);
        Gson gson = new Gson();
        String json = gson.toJson(emtehan);
        System.out.println(json);
        String json1 = "{'name': 'khossein', 'family': 'Hashemi', 'age': 21, 'haveShityLife': true}";
        Emtehan emtehan1 = gson.fromJson(json1,Emtehan.class);
        System.out.println(emtehan1.name);

         */

        RaiisDaneshkade ostad = new RaiisDaneshkade("1","1","ali",null,"EMAIL@GMAIL.COM","@(*298","096127",DaneshKade.OMRAN,DarajeOstadi.OSTAD_TAMAM,"1");
        DaneshjooArshad daneshjoo = new DaneshjooArshad("888","888","HADAD ADEL",null,"","712674982","0812983812",DaneshKade.SHIMI,Vazittahsily.DARHALTAHSIL,ostad,true,"9","1401",MaghtaDars.KARSHENASI);
        Gson gson = new Gson();
        ArrayList<RoozayeHafte> roozayeHaftes = new ArrayList<>();
        roozayeHaftes.add(RoozayeHafte.SHANBE);
        roozayeHaftes.add(RoozayeHafte.DOSHANBE);
        Dars dars = new Dars("0","Static","",ostad,DaneshKade.OMRAN,"3",MaghtaDars.KARSHENASI,"30",roozayeHaftes,"9","1401 10 1");
        String json = gson.toJson(dars);
        System.out.println(json);
        String file = "src/EDUFILES/da97.json";

        String json2 = readFileAsString(file);
        Ostad ostad1 = gson.fromJson(json2,Ostad.class);
        System.out.println(ostad1.getName());
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


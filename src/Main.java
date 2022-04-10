import EDUFILES.Emtehan;
import LOGIC.AzayeDaneshgah;
import LOGIC.Ostad;
import com.google.gson.Gson;

import java.util.logging.Logger;


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
        Ostad ostad = new Ostad("2139","iani","hossein");
        for (AzayeDaneshgah i:
                AzayeDaneshgah.azayeDaneshgahs) {
            System.out.println(i.name + i.getId());
        }
    }
}


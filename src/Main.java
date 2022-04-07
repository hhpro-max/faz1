import EDUFILES.Emtehan;
import com.google.gson.Gson;

import java.util.logging.Logger;


public class Main {

    public static void main(String[] args) {
        Emtehan emtehan = new Emtehan("hossein","hashemi",21,true);
        Gson gson = new Gson();
        String json = gson.toJson(emtehan);
        System.out.println(json);
        String json1 = "{'name': 'khossein', 'family': 'Hashemi', 'age': 21, 'haveShityLife': true}";
        Emtehan emtehan1 = gson.fromJson(json1,Emtehan.class);
        System.out.println(emtehan1.name);
    }
}


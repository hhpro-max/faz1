package LOGIC;

public class LoginCheck {
    public static boolean isvalidLogin = false;

    public static String name;
    public static String pass;
    public static AzayeDaneshgah azayeDaneshgah;

    public void check(){
        isvalidLogin = false;
        name = Controller.getInstance().getName();
        pass = Controller.getInstance().getPass();

        for (AzayeDaneshgah i:
             AzayeDaneshgah.getAzayeDaneshgahs()) {
            if (name.equals(i.getId()) && pass.equals(i.getPass())){
                //i.setAkharinzamanvorood(Controller.controller.getZamanvorood());

                azayeDaneshgah = i;
                isvalidLogin = true;
            }
        }
    }
}

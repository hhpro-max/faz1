package LOGIC;

public class LoginCheck {
    public static boolean isvalidLogin = false;

    public static String name;
    public static String pass;

    public void check(){
        this.name = Controller.getInstance().getName();
        this.pass = Controller.getInstance().getPass();

        for (AzayeDaneshgah i:
             AzayeDaneshgah.getAzayeDaneshgahs()) {
            if (name.equals(i.getId()) && pass.equals(i.getPass())){
                isvalidLogin = true;
            }
        }
    }
}

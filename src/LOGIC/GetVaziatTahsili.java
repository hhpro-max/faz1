package LOGIC;

public class GetVaziatTahsili {

    public static GetVaziatTahsili getVaziatTahsili;
    private GetVaziatTahsili(){

    }
    public static GetVaziatTahsili getInstance(){
        if (getVaziatTahsili==null){
            getVaziatTahsili = new GetVaziatTahsili();
        }
        return getVaziatTahsili;
    }

    public String getVaziatTahsili(Vazittahsily vazittahsily){
        String vaZiat = "Namaloom";
        switch (vazittahsily){
            case EKHRAJI:
                vaZiat = "DaneshJoye Ekhraji";
            case ENSERAFI:
                vaZiat = "Daneshjoye Enserafi";
            case MORAKHASI:
                vaZiat = "MoraKhasi";
            case DARHALTAHSIL:
                vaZiat = "DarHalTahsil";
        }
        return vaZiat;
    }

}

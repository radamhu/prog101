package apphelyjegy;

public class Utas {

    private int szék;
    private int mettől;
    private int meddig;
    private int km;
    private boolean végig;
    private int ft; //71 Ft/10 km

    public Utas(String sor) {
        String[] tmp = sor.split(" "); // mindenki a saját adatait szeleteli       
        this.szék = Integer.parseInt(tmp[0]);
        this.mettől = Integer.parseInt(tmp[1]);
        this.meddig = Integer.parseInt(tmp[2]);
        this.km = meddig - mettől;
        setVégig();
        setFt();
    }

    private void setVégig() {
        végig = (meddig - mettől == 172);
    }

    private void setFt() {
        int km10 = km / 10;// megkezdett 10 km-ek
        if (km % 10 != 0) {
            km10 = km10 + 1;
        }
        //kerekítés jön
        ft = km10 * 71;
        int mod = ft % 5; // 0,1,2,3,4        
        if (mod > 2) {
            ft = ft + 5 - mod;
        }else{
           ft = ft - mod; 
        }
    }

    public int getSzék() {
        return szék;
    }

    public int getMettől() {
        return mettől;
    }

    public int getMeddig() {
        return meddig;
    }

    public boolean isVégig() {
        return végig;
    }

    public int getFt() {
        return ft;
    }

    public int getKm() {
        return km;
    }
}

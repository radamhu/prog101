package appfutar;

public class Ut {

    //tagváltozók
    private int nap;
    private int fuvar;
    private int km;
    private int Ft;    
    
    //konstruktor  
    public Ut(String sor) {
        String[] t = sor.split(" ");
        this.nap = Integer.parseInt(t[0]);
        this.fuvar = Integer.parseInt(t[1]);
        this.km = Integer.parseInt(t[2]);
        setFt();
    }    
    
    //public metódusok
    // tagváltozók kijelöl, jobb klikk, insert code, getter  
    public int getNap() {
        return nap;
    }
    
    private void setFt() {
        if (km < 3) {
            this.Ft = 500;
        } else if (km < 6) {
            this.Ft = 700;
        } else if (km < 11) {
            this.Ft = 900;
        } else if (km < 21) {
            this.Ft = 1400;
        } else if (km < 31) {
            this.Ft = 2000;
        }
    }

    public int getFuvar() {
        return fuvar;
    }

    public int getKm() {
        return km;
    }
    
    public void setNap(int nap) {
        this.nap = nap;
    }

    public void setFuvar(int fuvar) {
        this.fuvar = fuvar;
    }

    public void setKm(int km) {
        this.km = km;
    }    

    public int getFt() {
        return Ft;
    }
}

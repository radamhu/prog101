package feladat;

public class Adathordozo {
    public String nev;
    public int kapacitas;

    public Adathordozo(String nev, int kapacitas) {
        this.nev = nev;
        this.kapacitas = kapacitas;
    }

    public String getNev() {
        return nev;
    }

    public int getKapacitas() {
        return kapacitas;
    }
   
    @Override
    public String toString() {
        return "Adathordozo{" + "nev=" + nev + ", kapacitas=" + kapacitas + '}';
    }
    
    public int nagyobbMint(Adathordozo masik) {
        if (kapacitas > masik.kapacitas) {
            return 1;
        }
        return 0;
    }
    
}

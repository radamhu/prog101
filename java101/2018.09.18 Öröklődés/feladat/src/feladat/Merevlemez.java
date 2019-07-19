package feladat;

public class Merevlemez extends Adathordozo{
    int fordulatszam;
    
    public Merevlemez(String nev, int kapacitas, int fordulatszam) {
        super(nev, kapacitas);
        this.fordulatszam = fordulatszam;
    }

    public int getFordulatszam() {
        return fordulatszam;
    }
    
    
    @Override
    public String toString() {
        return "Merevlemez{" + "kapacitas=" + kapacitas + ", " + "fordulatszam=" + fordulatszam + '}';
    }
  
}

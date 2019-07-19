package feladat;

public class Pendrive extends Adathordozo{
    
    int verzio;
    
    public Pendrive(String nev, int kapacitas, int verzio) {
        super(nev, kapacitas);
        this.verzio = verzio;
    }

    public int getVerzio() {
        return verzio;
    }

    
    @Override
    public String toString() {
        return "Pendrive{" + "verzió= " + kapacitas + ", " + " verzio " + verzio + '}';
    }
    
}

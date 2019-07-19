package arus;

/**
 *
 * @author tothj
 */
public class Aru {
    private String nev;
    private int ar;
    private int afakulcs;

    public Aru(String nev, int ar, int afakulcs) {
        this.nev = nev;
        this.ar = ar;
        this.afakulcs = afakulcs;
    }
    
    public int brutto() {
        return (int)Math.round(ar+ar*(afakulcs/100.0));
    }
    
    @Override
    public String toString() {
        return nev + ", bruttó: " + brutto();
    }
    
    public void novel(int szazalek) {
        ar += (int)Math.round(ar * szazalek/100.0);
    }
    
    public int hasonlit(Aru masik) {
        if (brutto() > masik.brutto())
            return 1;
        if (brutto() < masik.brutto())
            return -1;
        return 0;
    }
}

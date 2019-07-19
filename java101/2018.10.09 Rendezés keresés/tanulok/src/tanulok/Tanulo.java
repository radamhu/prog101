package tanulok;

public class Tanulo {
    private String nev;
    private int szulev;
    private double atlag;

    public Tanulo(String nev, int szulev, double atlag) {
        this.nev = nev;
        this.szulev = szulev;
        this.atlag = atlag;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getSzulev() {
        return szulev;
    }

    public void setSzulev(int szulev) {
        this.szulev = szulev;
    }

    public double getAtlag() {
        return atlag;
    }

    public void setAtlag(double atlag) {
        this.atlag = atlag;
    }
    
    @Override
    public String toString() {
        return nev + ", " + szulev + ", " + atlag;
    }
}

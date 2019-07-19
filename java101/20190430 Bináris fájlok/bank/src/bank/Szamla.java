package bank;

public class Szamla {
    private int szamlaszam, egyenleg;

    public Szamla(int szamlaszam, int egyenleg) {
        this.szamlaszam = szamlaszam;
        this.egyenleg = egyenleg;
    }

    public int getSzamlaszam() {
        return szamlaszam;
    }

    public int getEgyenleg() {
        return egyenleg;
    }

    public void setEgyenleg(int egyenleg) {
        this.egyenleg = egyenleg;
    }
}

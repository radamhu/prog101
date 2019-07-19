package alkalmazottDemo;
/**
 * Alkalmazott osztály
 * @author Tóth József
 */
public class Alkalmazott {
    private String nev;
    private int fizetes;
    private int szulev;
    private static int ev = 2017;
    private static int korhatar = 65;

    public Alkalmazott(String nev, int fizetes, int szulev) {
        this.nev = nev;
        this.fizetes = fizetes;
        this.szulev = szulev;
    }
    
    public int getSzulev() {
        return szulev;
    }
    
    public String getNev() {
        return nev;
    }

    public int getFizetes() {
        return fizetes;
    }

/*
    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setFizetes(int fizetes) {
        this.fizetes = fizetes;
    }
*/
    
    public static void setEv (int ev) {
        Alkalmazott.ev = ev;
    }
    
    public static void setKorhatart (int korhatar) {
        Alkalmazott.korhatar = korhatar;
    }
    
    public int evenyugdijig() {
        return korhatar - (ev-szulev);
    }
    
    void novel(int nov) {
        fizetes += nov;
    }

    String adatok() {
        return nev + ": " + evenyugdijig() + " " + fizetes;
    }
}

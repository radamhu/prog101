package kutyak;

/**
 *
 * @author Joe
 */
public class Nev {
    private String nev;
    private int db;

    public Nev(String nev) {
        this.nev = nev;
        this.db = 0;
    }

    public String getNev() {
        return nev;
    }

    public int getDb() {
        return db;
    }

    public void novelDb() {
        this.db++;
    }
    
    
}

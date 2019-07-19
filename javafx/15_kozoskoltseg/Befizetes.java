package kozoskoltseg;

/**
 *
 * @author Joe
 */
public class Befizetes {
    private int befizid;
    private int lakasid;
    private String nev;
    private String datum;
    private int osszeg;

    public Befizetes(int befizid, int lakasid, String nev, 
                     String datum, int osszeg) {
        this.befizid = befizid;
        this.lakasid = lakasid;
        this.nev = nev;
        this.datum = datum;
        this.osszeg = osszeg;
    }

    public int getBefizid() {
        return befizid;
    }

    public void setBefizid(int befizid) {
        this.befizid = befizid;
    }

    public int getLakasid() {
        return lakasid;
    }

    public void setLakasid(int lakasid) {
        this.lakasid = lakasid;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getOsszeg() {
        return osszeg;
    }

    public void setOsszeg(int osszeg) {
        this.osszeg = osszeg;
    }
    
    
}

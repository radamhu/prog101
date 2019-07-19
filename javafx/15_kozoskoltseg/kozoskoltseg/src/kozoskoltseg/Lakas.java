package kozoskoltseg;

/**
 *
 * @author Joe
 */
public class Lakas {
    private int lakasid;
    private String epulet;
    private String ajto;
    private int terulet;
    private String nev;

    public Lakas(int lakasid, String epulet, String ajto, int terulet, String nev) {
        this.lakasid = lakasid;
        this.epulet = epulet;
        this.ajto = ajto;
        this.terulet = terulet;
        this.nev = nev;
    }

    public int getLakasid() {
        return lakasid;
    }

    public void setLakasid(int lakasid) {
        this.lakasid = lakasid;
    }

    public String getEpulet() {
        return epulet;
    }

    public void setEpulet(String epulet) {
        this.epulet = epulet;
    }

    public String getAjto() {
        return ajto;
    }

    public void setAjto(String ajto) {
        this.ajto = ajto;
    }

    public int getTerulet() {
        return terulet;
    }

    public void setTerulet(int terulet) {
        this.terulet = terulet;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }
    
    
}

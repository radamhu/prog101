package nobel;

/**
 *
 * @author tothj
 */

 public class Dij {
    private int evszam;
    private String tipus;
    private String keresztnev;
    private String vezeteknev;

    public Dij(int evszam, String tipus, String keresztnev, String vezeteknev) {
        this.evszam = evszam;
        this.tipus = tipus;
        this.keresztnev = keresztnev;
        this.vezeteknev = vezeteknev;
    }

    public int getEvszam() {
        return evszam;
    }

    public void setEvszam(int evszam) {
        this.evszam = evszam;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public void setKeresztnev(String keresztnev) {
        this.keresztnev = keresztnev;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public void setVezeteknev(String vezeteknev) {
        this.vezeteknev = vezeteknev;
    }
    
    
}

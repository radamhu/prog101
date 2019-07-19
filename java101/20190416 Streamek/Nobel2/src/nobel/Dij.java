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

    public String getTipus() {
        return tipus;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public String getNev() {
        return keresztnev + " " + vezeteknev;
    }

}

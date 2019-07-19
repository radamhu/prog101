package orszagok;

import java.io.Serializable;

/**
 *
 * @author tothj
 */
public class Orszag implements Serializable {
    private String nev, fovaros;

    public Orszag(String nev, String fovaros) {
        this.nev = nev;
        this.fovaros = fovaros;
    }

    public String getNev() {
        return nev;
    }

    public String getFovaros() {
        return fovaros;
    }
}

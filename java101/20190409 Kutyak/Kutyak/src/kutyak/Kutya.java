package kutyak;

/**
 *
 * @author tothj
 */
public class Kutya {
    private int fajtaid, nevid, eletkor;
    private String datum;

    public Kutya(int fajtaid, int nevid, int eletkor, String datum) {
        this.fajtaid = fajtaid;
        this.nevid = nevid;
        this.eletkor = eletkor;
        this.datum = datum;
    }

    public int getFajtaid() {
        return fajtaid;
    }

    public int getNevid() {
        return nevid;
    }

    public int getEletkor() {
        return eletkor;
    }

    public String getDatum() {
        return datum;
    }

    
}

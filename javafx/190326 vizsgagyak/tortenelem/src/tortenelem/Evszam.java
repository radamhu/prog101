package tortenelem;

/**
 *
 * @author Joe
 */
public class Evszam {
    private int id, ev;
    private String esemeny;

    public Evszam(int id, int ev, String esemeny) {
        this.id = id;
        this.ev = ev;
        this.esemeny = esemeny;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEv() {
        return ev;
    }

    public void setEv(int ev) {
        this.ev = ev;
    }

    public String getEsemeny() {
        return esemeny;
    }

    public void setEsemeny(String esemeny) {
        this.esemeny = esemeny;
    }
    
}

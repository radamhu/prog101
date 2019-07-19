package futas;

import java.sql.Date;

/**
 *
 * @author Joe
 */
public class Edzes {
    private int futasID;
    private Date datum;
    private int tav, ido;

    public Edzes(int futasID, Date datum, int tav, int ido) {
        this.futasID = futasID;
        this.datum = datum;
        this.tav = tav;
        this.ido = ido;
    }

    public int getFutasID() {
        return futasID;
    }

    public void setFutasID(int futasID) {
        this.futasID = futasID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getTav() {
        return tav;
    }

    public void setTav(int tav) {
        this.tav = tav;
    }

    public int getIdo() {
        return ido;
    }

    public void setIdo(int ido) {
        this.ido = ido;
    }
}

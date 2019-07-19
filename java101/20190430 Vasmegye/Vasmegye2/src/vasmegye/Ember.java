
package vasmegye;

/**
 *
 * @author bm
 */
public class Ember {
    private int m;
    private int év;
    private int ho;
    private int nap;
    private int s;
    private int k;

    public Ember(int m, int év, int ho, int nap, int s, int k) {
        this.m = m;
        this.év = év;
        this.ho = ho;
        this.nap = nap;
        this.s = s;
        this.k = k;
    }

    public int getM() {
        return m;
    }

    public int getÉv() {
        return év;
    }

    public int getHo() {
        return ho;
    }

    public int getNap() {
        return nap;
    } 
    public String getHoNap() {
        return String.format("%02d%02d", this.ho, this.nap);
    }

    public int getS() {
        return s;
    }

    public int getK() {
        return k;
    }
       public String getEvnegyjegy() {
           if (this.m < 3) {
               return  String.format("19%02d", this.év);
           } else {
                return  String.format("20%02d", this.év);

           }
    }
    public String getSzemszam() {
                 return String.format("%1d-%02d%02d%02d-%03d%1d", this.m,this.év,this.ho,this.nap,this.s,this.k);

    }
    public String getEvHoNap() {
         return String.format("%02d%02d%02d", this.év,this.ho, this.nap);
    }
    @Override
    public String toString() {
        
        return String.format("%1d%02d%02d%02d%03d%1d", this.m, this.év,this.ho, this.nap,this.s,this.k);
    }
}

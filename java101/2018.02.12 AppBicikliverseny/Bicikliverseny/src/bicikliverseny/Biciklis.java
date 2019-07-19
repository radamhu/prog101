package bicikliverseny;
import java.util.*;

public class Biciklis {
    private final String nev;
    private final ArrayList<Integer> km = new ArrayList<>();
    
    public Biciklis (String sor){ // főprogram readline-al beolvas és küldi be a kunstruktorba
        String[] tmp = sor.split("\t"); // saját magunk szplittelünk
        this.nev = tmp[0];
        this.fillKmlista(tmp); // hogy a "km" űrlap egyes celláidab kerüljenek az adatok
    }
    
    private void fillKmlista(String [] tmp) {
        int N  = tmp.length; // lekérem a tömb hosszát
        for (int i = 1; i < N; i++) {
            km.add(Integer.parseInt(tmp[i])); // felfűzte egy objektum listára, kész, jön a következő sor
        }
    }
    
    // Mivel a név és a km[] privát ezért nem érhetőek el
    // Publikus fv-ek kellenek a hozzáférésekhez
    public String getNev() {
        return nev;
    }
    
    public ArrayList<Integer> getKm() {
        return km;
    }
    
    public void setKm(int nap, int ujKm) {
        km.set(nap, ujKm);
    }
    
    @Override 
    // azt mondja a programnak amikor ideér
    // hogy egy metódust felülír
    public String toString() {
        String s, s1 = ""; // egymás mellé felfűzi a sztringet
        s = String.format("%16s ", nev); // berakom 16s helyre a neveket
        // int N = km.length(); 
        // megnézem mindenkinek a km hosszát
        for (int i = 0; i < km.size(); i++) {
            s1 = s1 + String.format("%5d", km.get(i)); // mindig fűzögetem be 5s helyre
        }
        return s + s1; // s a név, és s1 ami a ciklusból feldolgozásra kerül
    }

    void setKm(double nap, double ujKm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

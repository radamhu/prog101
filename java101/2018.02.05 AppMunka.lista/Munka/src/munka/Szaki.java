package munka;

import java.util.*;
// lista adatszerkezetet ez kezeli

public class Szaki { // a konstruktor
    private String nev;
    private ArrayList<Integer> db = new ArrayList<>();
    // 2 private kijelöl + egér jobb klikk <insert code> + constructor ...
    
    public Szaki(String sor) {
        String[] tmp = sor.split(";"); // szeletelés a segéd (tmp) tömbbe
        this.nev = tmp[0]; // beküldött adatsor 0.-ik eleme jön ide
        this.fillPontok(tmp); // feltöltjük az adatokat a listába
    }
    
    private void fillPontok(String[] tmp) { // megkapom a konostruktortól ezt a String tömböt
        int N = tmp.length; // megnézem ennek a hosszát, mert nem mindegyik egyforma
        for (int i = 1; i < N; i++) { // a 0-ás elem a név, ezért kezdem az 1-essel az iteráicót
            db.add(Integer.parseInt(tmp[i])); // db-hez add hozzá, át kell alakítani egész számmá
        }
    }
    
    public String getNev() {
        return nev;
    }
     
    public int szummaDe() { // a délelőtti összeg [1;4] óra
        int s = 0;
        int N = db.size();
        if (N>3) {
            N = 4;
        }
        for (int i = 0; i < N; i++) {
            s = s + db.get(i);
        }
        return s;
    }
    
    public int szummaDu() { // a délutáni összeg [5;8] óra
        int s = 0;
        int N = db.size();
        if (N > 4) { // csak a délutáni adatok kellenek
            for (int i = 4; i < N; i++) {
                s = s + db.get(i);
            }
        }
        return s;
    }
    
    @Override // azt mondja a programnak amikor ideér
    // hogy egy metódust felülír
    public String toString() {
        String s, s1 = ""; // egymás mellé felfűzi a sztringet
        s = String.format("%16s ", nev);
        for (int i = 0; i < db.size(); i++) {
            s1 = s1 + String.format("%5d", db.get(i));
        }
        return s + s1; // s a név, és s1 ami a ciklusból feldolgozásra kerül
    }
}

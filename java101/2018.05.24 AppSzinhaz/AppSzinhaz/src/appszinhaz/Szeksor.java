/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appszinhaz;

/**
 *
 * @author adamr
 */
public class Szeksor {
    private String foglalt;
    private String kategoria;
    
    public Szeksor(String foglalt, String kategoria) {
        this.foglalt = foglalt;
        this.kategoria = kategoria;
    }
    
    public boolean szabad(int szek) {
        return foglalt.charAt(szek) == 'o';
    }
    
    public int eladott() {
        int db = 0;
        for (int i = 0; i < foglalt.length(); i++) {
            if (!szabad(i)) {
                db++;
            }
        }
        return db;
    }
    
    
    // Azt kell meghatároznunk, hogy melyik árkategóriából adták el a legtöbb jegyet az előadásra.
    // Ehhez először meghatározzuk az összes kategória eladásait, majd ebből kiválasztjuk a legnagyobbat.
    // Mivel ötféle árkategória van, egy ötelemű tömbben tárolhatjuk az egyes kategóriák eladásait. Induláskor az elemek értéke 0 lesz.
    // Ezután mindegyik széksor hozzáadja a tömb elemeihez az ott történt eladásokat.
    // Egy ciklussal végigmegyünk a kategoria adattag összes karakterén, és megnöveljük a tömb megfelelő elemét. 
    // Ha például ’2’ karakter következik, akkor a második elemet növeljük meg eggyel.
    // A kategoria.charAt(i)-'0' kifejezéssel az i-dik karakter értékét határozzuk meg. Ebből ki kell vonni 1-et a megfelelő indexhez.

    /**
     * meghatározza, melyik kategóriájú jegyből hányat adtak el
     * @param stat 5 elemű tömb, amelyben számolunk 
     */

    public void arkategoria(int[] stat) {
        for (int i = 0; i < kategoria.length(); i++) {
            if (!szabad(i)) {
                stat[kategoria.charAt(i)-'0'-1]++;
            }
        }
    }
}

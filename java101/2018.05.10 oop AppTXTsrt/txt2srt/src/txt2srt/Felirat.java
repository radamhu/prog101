package txt2srt;

public class Felirat {
    
    private int ido1;
    private int ido2;
    private final String szoveg;
    
    // kötelezően public (ami azt jelenti, hogy más osztályokból és csomagokból is látható),
    // soha nem ad vissza értéket, ezért ennek típusát nem is adhatjuk meg (void sem lehet),
    // neve mindig megegyezik az osztály nevével.

    public Felirat (String s1, String s2) {
        ido1 = Integer.parseInt(s1.substring(0,2))*60 +
                Integer.parseInt(s1.substring(3,5));
        ido2 = Integer.parseInt(s1.substring(8,10))*60 +
                Integer.parseInt(s1.substring(11,13));
        szoveg = s2;
    }
    
    // Mielőtt használnák egy osztályt egy programban, célszerű tesztelni, hogy jól működik-e.
    // Helyezz el egy töréspontot a 29. sorban, majd indítsd el a debuggert (Ctrl+Shift+F5, vagy jobb kattintás és Debug File)! 
    // Ellenőrizd az f1 objektum adattagjait:
    // Megjegyzés: A Felirat osztályt úgy lehetne futtatni, hogy megnyomod a Shift+F6 billentyűket, vagy a jobb kattintás után a Run File parancsot választod.
    //
//    public static void main(String[] args) {
//        Felirat f1 = new Felirat("01:14 - 01:16", "And we are going to grab");
//        f1.eltol(1);
//        System.out.println(f1.getSrt());
//        System.out.println(f1.getSzoveg());
//        
//        Felirat f2 = new Felirat("65:31 - 65:34", "And that's the end od phase 2.");
//        f2.eltol(-1);
//        System.out.println(f2.getSrt());
//        System.out.println(f2.getSzoveg());
//    }
    
    /**
     * szöveg lekérdezése
     * @return szöveg
     */
    public  String getSzoveg() {
        return szoveg;
    }
    
    /**
     * egy időpont átalakítása másodpercről óó:pp:mp-re
     * @param mp az időpont másodpercben
     * @return az óó:pp:mp formátum string
     */
    private String atalakit(int mp) {
        return String.format("%02d:%02d:%02d", mp/3600, (mp % 3600)/60, (mp%60));
    }
    
    /**
     * teljes időzítás átalakítása srt formátumra
     * @return átalakítot időzítés
     */
    public  String getSrt() {
        return atalakit(ido1)+" --> " + atalakit(ido2);
    }
    
    /**
     * felirat elejének és végének eltolása n másodperccel
     * @param n az eltolás másodpercben
     */
    public void eltol(int n) {
        ido1 += n;
        ido2 += n;
    }
}

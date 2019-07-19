/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kektura;

/**
 *
 * @author adamr
 * Osztályok létrehozása
 * Először meg kell terveznünk, hogy milyen adatszerkezetben tároljuk az adatokat. 
 * Minden túraszakasz adatait egy-egy objektumban fogjuk tárolni, és ezekből hozunk majd létre egy listát. 
 * Az objektum típusa Szakasz lesz. 
 * A Szakasz osztály hat adattagot fog tartalmazni a fenti felsorolásnak megfelelően.
 * Az osztályoknak a tömbökkel szemben az az egyik előnyük, hogy különböző típusú adatokat is együtt lehet velük kezelni.
 * Az osztályok metódusai között van egy különleges: a konstruktor. 
 * Amikor létrehozunk az osztály alapján egy új objektumot, akkor a Java automatikusan lefuttatja a konstruktort.
 * A konstruktort általában a kezdőértékek beállítására használjuk. 
 */
public class Szakasz {
    private String eleje;
    private String vege;
    private double tav;
    private int emelkedes;
    private int lejtes;
    private boolean pecsethely;
    
    // Egészítsd ki a Szakasz osztályt egy olyan konstruktorral, 
    // amely egy stringet kap, és ebből beállítja az adattagok kezdőértékeit:

    public Szakasz(String sor) {
        String[] s = sor.split(";");
        eleje = s[0];
        vege = s[1];
        tav = Double.parseDouble(s[2].replace(",", "."));  // parseDouble() metódus csak tizedespontot fogad el 
        emelkedes = Integer.parseInt(s[3]);
        lejtes = Integer.parseInt(s[4]);
        pecsethely = s[5].equals("i");
    }
    
    // Mielőtt használnák egy osztályt egy programban, célszerű tesztelni, hogy jól működik-e.
    // Helyezz el egy töréspontot a 10. sorban, majd indítsd el a debuggert (Ctrl+Shift+F5, vagy jobb kattintás a SzakaszTeszt osztályra és Debug File)! 
    // Ellenőrizd az sz1 objektum adattagjait, majd kapcsold ki a töréspontot!
    // Megjegyzés: A Felirat osztályt úgy lehetne futtatni, hogy megnyomod a Shift+F6 billentyűket, vagy a jobb kattintás után a Run File parancsot választod.
    //
//    public static void main(String[] args) {
//        Szakasz sz1 = new Szakasz("Sumeg, vasutallomas; Sumeg, buszpalyaudvar;1,208;16;6;n");
//        System.out.println(sz1.toString());
//    }
    
    // Objektum kiíratása
    // Minden objektumnak van egy toString() metódusa. 
    // Ez azonban csak az objektum nevét és egy címet ad meg, így nem sok mindenre használható.
    // Mivel a programban több helyen is ki kell majd íratnunk egy-egy szakasz adatait, 
    // célszerű ezt az (Object osztálytól) örökölt metódust felülírni egy használhatóval. 
    @Override
    public String toString() {
        return String.format("%s;%s;%.3f;%d;%d;%s",eleje, vege, tav,emelkedes, lejtes, pecsethely?"i":"n");
    }
    
    /**
     * Megadja a szakasz hosszat
     * @return tav
     */
    public  double getTav() {
        return tav;
    }
    
    /**
     * A szakaszokon belüli emelkedés és lejtés különbsége
     * @return szintváltozás
     */
    public int szintvaltozas() {
        return emelkedes - lejtes;
    }
    
    /**
     * Megvizsgálja hogy hiányos-e a végpont
     * @return igaz/hamis
     */
    public boolean hianyos() {
        return pecsethely && !vege.contains("pecsetelohely");
    }
}

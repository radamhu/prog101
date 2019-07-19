/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valasztas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author t1
 */
public class Valasztas {

    /**
     * @param args the command line arguments
     */
    
    static ArrayList<Jelolt> jeloltek = new ArrayList<>();
    static Map<String, Integer> partok = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        // 1.feladat
        Scanner be = new Scanner(new File("szavazatok.txt"));
        while (be.hasNextLine()) {            
            jeloltek.add(new Jelolt(be.nextLine()));
        }
        be.close();
        // 2.feladat
        // tmp.length vagy array.size - teljes méret
        System.out.println("2. feladat");
        System.out.println("A helyhatósági választásokra "
                + jeloltek.size() + "képviselőjelölt indult.");
        // 3. feladat
        System.out.println("3. feladat");
        Scanner bill = new Scanner(System.in);
        System.out.print("Vezeték és utónév: ");
        int sz = szavazat_keres(bill.nextLine());
        if (sz > -1 ) {
            System.out.println("Szavazatok száma: " + sz);
        } else {
            System.out.println("Ilyen nevű képviselőjelölt nem "
                    + "szerepel a nyilvántartásban");
        }
        // 4. feladat
        // összegzés tétel
        int osszes = 0;
        // összeadjuk az összes szavazatot, majd az egyes pártok szavazatait
        for (Jelolt j : jeloltek) {
            // csak a köetkező kell a 4-eshez
            osszes += j.getSzavazat();
            // ez kell az 5-öshöz
            Integer szdb =  partok.get(j.getPart());
            // megnézi hogy a hasmap-be van e már érték
            // nyilván nem lesz, ezért fel kell tölteni az elős értékkel a hasmap-et
            // nem lehet +=, csak = mert ha nincs azaz 0, ahhoz nem tudunk hozzáadni
            if (szdb == null) {
                szdb = j.getSzavazat();
            } else {
                szdb += j.getSzavazat();
            }
            partok.put(j.getPart(), szdb);
        }
        System.out.println("4. feladat");
        System.out.printf("A választáson %d állampolgár, "
                + " a jogosultak %.2f%%-a vett részt.\n" , 
                osszes, 100.0*osszes/12345);
        // 5. feladat
        System.out.println("5. feladat");
        System.out.println("A pártokra leadott szavazatok aránya:");
        for (String p : partok.keySet()) {
            System.out.printf("%s = %.2f%%\n", part_nev(p),
                    100.0*partok.get(p)/osszes);
        }
        
        // 6 .feladat
        // itt a listát rendezem
        System.out.println("6 .feladat");
        System.out.println("A legtöbb szavazatot katpák:");
        // csökkenő sorrendbe tettük a listát
        Collections.sort(jeloltek, (a,b) -> b.getSzavazat() - a.getSzavazat());
        int legtobb = jeloltek.get(0).getSzavazat();
        int i = 0;
        // listát addig  íratom ki ameddig nem egyenlő a legtöbbel 
        // 
        while (jeloltek.get(i).getSzavazat() == legtobb) {            
            System.out.println(jeloltek.get(i).getNev() + " "
            + jeloltek.get(i).getPart());
            i++;
        }
        
        // 7. feladat
        // listába lemegyek odáig ameddig nem találok 
        PrintWriter ki = new PrintWriter("kepviselok.txt");
        for (int kerulet = 1; kerulet < 8; kerulet++) {
            i = 0;
            while (jeloltek.get(i).getKerulet() != kerulet) {                
                i++;
            }
            ki.println(kerulet + " " + jeloltek.get(i).getNev()
                            + " " + jeloltek.get(i).getPart());
        }
        ki.close();
    }
    
    // lineráis keresés, ha nem találunk semmit, -1et adunk vissza
    private static int szavazat_keres(String nev) {
        for (int i = 0; i < jeloltek.size(); i++) {
            Jelolt j = jeloltek.get(i);
            if (j.getNev().equals(nev)) {
                return j.getSzavazat();
            }
        }
        return -1;
    }
    // case után nincs break, mert most return-al kilépünk
    private static String part_nev(String rov) {
        switch (rov) {
            case "GYEP":
                return "Gyümölcsevők pártja";
            case "HEP":
                return "Húsevők pártja";
            case "TISZ":
                return "Tejivók pártja";
            case "ZEP":
                return "Zöldségevők pártja";
            default:
                return "Függetlne jelöltek";
        }
    }
}

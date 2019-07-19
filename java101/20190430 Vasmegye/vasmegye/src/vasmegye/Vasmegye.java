package vasmegye;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Születések Vas megyében (komplex feladat)
 * @author tothj
 */
public class Vasmegye {
    static List<Szam> szamok = new ArrayList<>(); 
    static Map<Integer, Integer> stat = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        // 2-4. feladat
        System.out.println("2. feladat: Adatok beolvasása, tárolása");
        System.out.println("4. feladat: Ellenőrzés");
        Scanner be = new Scanner(new File("vas.txt"));
        while (be.hasNextLine()) {
            Szam sz = new Szam(be.nextLine());
            if (sz.cdvEll()) 
                szamok.add(sz);
            else
                System.out.println("\tHibás a " + sz.getSzam() 
                                 + " személyi azonosító!");
        }
        be.close();
        // 5. feladat
        System.out.println("5. feladat: Vas megyében a vizsgált időszakban "
                           + szamok.size() + " csecsemő született.");
        // 6-7. feladat
        int fdb = 0;
        int minev = 3000;
        int maxev = 0;
        for (Szam sz : szamok) {
            if (sz.getFiu())
                fdb++;
            if (sz.getEv() < minev)
                minev = sz.getEv();
            if (sz.getEv() > maxev)
                maxev = sz.getEv();
        }
        System.out.println("6. feladat: Fiúk száma: " + fdb);
        System.out.println("7. feladat: A vizsgált időszak: "
                           + minev + " - " + maxev);
        // 8. feladat
        System.out.print("8. feladat: ");
        boolean volt = false;
        for (Szam sz : szamok) {
            if (sz.getEv() % 4 == 0 && sz.getDatum().equals("0224")) {
                System.out.println("Szökőnapon született baba!");
                volt = true;
                break;
            }
        }
        if (!volt)
            System.out.println("Szökőnapon NEM született baba!");
        // 9. feladat
        for (Szam sz : szamok) {
            Integer db = stat.get(sz.getEv());
            if (db == null)
                db = 1;
            else
                db++;
            stat.put(sz.getEv(), db);
        }
        System.out.println("9. feladat: Statisztika");
        for (Integer i : stat.keySet()) {
            System.out.println("\t" + i + " - " + stat.get(i) + " fő");
        }
    }
}

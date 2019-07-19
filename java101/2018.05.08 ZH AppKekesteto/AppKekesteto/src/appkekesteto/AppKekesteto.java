package appkekesteto;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ádám Roland
 */
public class AppKekesteto {
    
    //Globális változók
    static RandomAccessFile f;
    private static final ArrayList<Adat> adatok = new ArrayList<>();
    
    // Adatok beolvasása
    // másolás listába (sor,i) 
    static void f1(String fNev) {
        System.out.println("1. Feladat");
        System.out.println("Adatok beolvasása...");
        try {
            f = new RandomAccessFile(fNev, "r");
            String sor;
            // for (int i = 0; i < 24; i++) {
            // sor = f.readLine();
            // adatok.add(new Adat(sor, i));
            // }
            int i = 0;
            while ((sor = f.readLine()) != null) {
                adatok.add(new Adat(sor, i));
                i++;
            }
        } catch (IOException e) {
            System.out.println("Hiba");
        }
        System.out.println();
    }
    
    // Hány órakor volt a legmelegebb? Tudjuk, hogy csak egyszer volt!
    // Hány órakor - int óra
    // maximum (maxIndex) kiválasztás
    static void f2() {
        int maxHomerseklet = 0;
        int maxHomersekletIndex = 0;
        System.out.println("2. Feladat:");

        for (int i = 1; i < adatok.size(); i++) {
            if (maxHomerseklet < adatok.get(i).getHomerseklet()) {
                maxHomerseklet = adatok.get(i).getHomerseklet();
                maxHomersekletIndex = i;
            }
        }
        System.out.println("A legmelegebb: " + maxHomersekletIndex + " órakkor volt, " + maxHomerseklet + " fok");
        System.out.println();
    }
    
    // Mikor és mekkora sebességgel fújt a legerősebben a szél? Ha többször is előfordult, akkor az összes időt írja ki a program! 
    // maximum kiválasztás
    // kiválogatás
    static void f3() {
        System.out.println("3. Feladat");
        int max = adatok.get(0).getSzelerosseg();

        for (int i = 1; i < adatok.size(); i++) {
            if (max < adatok.get(i).getSzelerosseg()) {
                max = adatok.get(i).getSzelerosseg();
            }
        }

        for (int i = 0; i < adatok.size(); i++) {
            if (max == adatok.get(i).getSzelerosseg()) {
                System.out.println(i + " órakkor " + max + " km/h");
            }
        }
        
        System.out.println();
    }
    
    // Az eny.txt fájlba: hány órakor milyen sebességgel fújt ÉNY-i szél?
    // kiválogatás fájlba
    static void f4(String fNev) {
        System.out.println("4.Feladat");
        System.out.println("ÉNY-i szél fájlba írása: ");
        try {
            f = new RandomAccessFile(fNev, "rw");
            for (int i = 0; i < adatok.size(); i++) {
                if (adatok.get(i).getSzelirany().equals("ÉNY")){                    
                    f.writeBytes(i + " kor, " + adatok.get(i).getSzelerosseg() + " km/h\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Hiba");
        }
        System.out.println();
    }
    
    // Hányszor volt borús az ég?
    // megszámlálás
    static void f5() {
        System.out.println("\n5. feladat");
        int N = adatok.size();
        int db = 0;
        for (int i = 0; i < N; i++) {
            if (adatok.get(i).getIdokep().equals("borult")) {
                db++;
            }
        }
        System.out.println("\t" + db + "-szor volt borus az ido!");
    }
    
    // Mennyi volt a napi hőingás? 
    // (A napi hőingás: a nap legmagasabb és legalacsonyabb hőmérséklet közötti különbség)
    // maximum + minimum kiválasztás 
    static void f6() {
        System.out.println("\n6. feladat");
        int N = adatok.size();
        int max = adatok.get(0).getHomerseklet();
        int min = adatok.get(0).getHomerseklet();
        for (int i = 0; i < N; i++) {
            if (adatok.get(i).getHomerseklet() > max) {
                max = adatok.get(i).getHomerseklet();
            }
            if (adatok.get(i).getHomerseklet() < min) {
                min = adatok.get(i).getHomerseklet();
            }
        }
        System.out.println("\t a napi hőingás: " + (max - min) + " fok");
    }
    
    // Hányszor volt fagypont (0°C)?
    // megszámlálás
    static void f7() {
        System.out.println("\n7. feladat");
        int N  = adatok.size();
        int db = 0;
        for (int i = 0; i < N; i++) {
            if (adatok.get(i).getHomerseklet() == 0) {
                db++;
            }
        }
        System.out.println("\t a fagypontok száma: " + db);
    }
    
    // Hányszor emelkedett a hőmérséklet az előző órához képest? 
    // megszámlálás
    static void f8() {
        System.out.println("\n8. feladat");
        int N = adatok.size();
        int db = 0;
        for (int i = 0; i < N-1; i++) {
            if (adatok.get(i).getHomerseklet() < adatok.get(i+1).getHomerseklet()) {
                db++;
            }
        }
        System.out.println("\t" + db + " alkalommal emelkedett a hőmérséklet");
    }
    
    // Milyen irányból fújt a szél, amikor a legmelegebb volt? (E, EK, K, DK, stb..) 
    // maximum (maxIndex) kiválasztás
    static void f9() {
        System.out.println("\n9. feladat");
        int N = adatok.size();
        int max = adatok.get(0).getHomerseklet();
        String szel = adatok.get(0).getSzelirany();
        for (int i = 0; i < N; i++) {
            if (adatok.get(i).getHomerseklet() > max) {
                max = adatok.get(i).getHomerseklet();
                szel = adatok.get(i).getSzelirany();
            }
        }
        System.out.println("\t a legmelegebb órában " + szel + "-i szél volt");
    }
    
    //  Mennyi volt a nappali (napkelte és napnyugta között) átlaghőmérséklet, ha tudjuk, hogy 7:01-kor volt nap- kelte és 16:48-kor volt napnyugta?
    // kiválogatás(összegzés + megszámlálás)
    static void f10() {
        System.out.println("\n10. feladat");
        int N = adatok.size();
        double avg = 0.0D;
        double db = 0.0D;
        adatok.get(0).getHomerseklet();
        for (int i = 0; i < N; i++) {
            if (adatok.get(i).getNapszak().equals("nappal")) {
                avg += adatok.get(i).getHomerseklet();
                db += 1.0D;
            }
        }
        System.out.println(String.format("\t%18s %2.2f %8s", "a nappali �tlag h�m�rl�klet:", Double.valueOf(avg / db), "fok volt" ));        
    }
    
    // A változóan felhős napokon milyen sebességű és irányú szél fújt, és ekkor hány % volt a levegő páratartalma?
    // kivalogatás
    static void f11() {
        System.out.println("\n11. feladat");
        int N = adatok.size();
        for (int i = 0; i < N; i++) {
            if (adatok.get(i).getIdokep().equals("felhos")) {
                System.out.println(String.format("\t%8s %3s %4s",  
                    Integer.valueOf((adatok.get(i)).getSzelerosseg()), 
                    (adatok.get(i)).getSzelirany(), 
                    (adatok.get(i)).getParatartalom()));
            };
        }
    }
    
   // Igaz-e, hogy a legkisebb légnyomásnál volt a legerősebb a szél?
   // maximum + minimum kiválasztás
   // eldöntés (Igaz/Hamis)
    static void f12() {
        System.out.println("\n12. feladat");
        int N = adatok.size();
        int max = adatok.get(0).getSzelerosseg();
        int min = adatok.get(0).getLegnyomas();
        for (int i = 0; i < N; i++) {
            if (adatok.get(i).getSzelerosseg() > max) {
                max = adatok.get(i).getSzelerosseg();
            }
            if (adatok.get(i).getLegnyomas() < min) {
                min = adatok.get(i).getLegnyomas();
            }
        }
        String s = "Hamis";
        for (int i = 0; i < N; i++) {
            if ((adatok.get(i).getSzelerosseg() == max) && (adatok.get(i).getLegnyomas() == min)) {
                s = "igaz";
            }
        }
        System.out.println("\t" + s + ", hogy a legkisebb légnyomásnál volt a legerősebb a szél");
    }
    
    public static void main(String[] args) {
        f1("adatok.txt");
        f2();
        f3();
        f4("eny.txt");
        f5();
        f6();
        f7();
        f8();
        f9();
        f10();
        f11();
        f12();
    }
}

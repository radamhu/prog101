package tti_feladat;

import java.io.*;
import java.util.Scanner;
import javafx.beans.binding.Bindings;

public class TTI_feladat {
    static String t[][] = new String[37][4];
    static RandomAccessFile f;
    
    static void adatokBe(String f_neve){ // Paraméteres beolvasás
        try {
            f = new RandomAccessFile(f_neve, "r");
            int N = t.length;
            for (int i = 0; i<N; i++) {
                t[i] = f.readLine().split("\t"); 
            }
            f.close();
        } catch (IOException e) {
            System.out.println("Baj van babám");
        }
        System.out.println(" " + f_neve + " beolvasása ... kész!");
        System.out.println();
    }
    
    // Összegzés
    static int szumma(String[] tmp) {
        int N = tmp.length;
        int s = 0;
        for (int i = 0; i < N; i++) {
            s += Integer.parseInt(tmp[i]);
        }
        return s;
    }
    
    // Maxmimum
    static int maximum(String[] tmp) {
        int N = tmp.length;
        int max = Integer.parseInt(tmp[0]);
        for (int i = 1; i < N; i++) {
            if (Integer.parseInt(tmp[i]) > max) {
                max = Integer.parseInt(tmp[i]);
            }
        }
        return max;
    }
    
    // minimum
    static int minimum(String tmp[]) {
        int N = tmp.length;
        int min = Integer.parseInt(tmp[0]);
        for (int i = 1; i < N; i++) {
            if (Integer.parseInt(tmp[i]) < min) {
                min = Integer.parseInt(tmp[i]);
            }
        }
        return min;
    }
    
    static double tti(String[] tmp) {
        double val = 0.0D;
        int kg = Integer.parseInt(tmp[3]);
        double cm = Integer.parseInt(tmp[2]) / 100.D;
        val = kg / (cm *cm);
        return val;
    }
    
    // Kik magasabbak az osztály átlagmagasságánál 10 cm-el?
    static void magasabbak() {
        // Átlagmagasság meghatározása
        // egy segédtömbbe (cm[37]) átmásolni a magasságokat
        String[] cm = new String[37];
        for (int sor = 0; sor < t.length; sor++) {
            cm[sor] = t[sor][2];  // magasságok
        }
        // a cm[]-t átadni az szumma(tmp[]) függvénynek
        double avg = szumma(cm) / t.length + 10.0D;
        System.out.println(" 1. Magasabbak mint:" + String.format("%4.0f %2s", new Object[] { Double.valueOf(avg), "cm" }));
        // Adatok kiíratása
        // végig tömbön, akik magasabbak az átlagnál 10 cm-el, azokat kiírni.
        for (int sor = 0; sor < t.length; sor++) {
            if (Integer.parseInt(t[sor][2]) > avg) {
                System.out.println(String.format("%18s %2s %6s %2s", new Object[] { t[sor][0], t[sor][1], t[sor][2], "cm" }));
            }
        }
    }
    
    static void legek() {
        System.out.println(" \n. Legek");
        System.out.println(" legnehezebb tanuló(k)");
        // Szélsőértékek meghatározása
        // egy segédtömbbe (kg[37]) átmásolni a testsúlyokat
        String[] kg = new String[37];
        for (int sor = 0; sor < t.length; sor++) {
            kg[sor] = t[sor][3]; // testsúlyok
        }
        for (int sor = 0; sor < t.length; sor++) {
            //  a kg[]-t átadni az maximum(tmp[]) függvénynek
            if (Integer.parseInt(t[sor][3]) == maximum(kg)) {
               // végig tömbön , akik kg_max súlyúak azokat kiírni
               System.out.println(String.format("%18s %6s %2s", new Object[] { t[sor][0], t[sor][3], "kg" })); 
            }
        }
        System.out.println(" legalacsonyabb tanuló(k)");
        //  egy segédtömbbe (cm[37]) átmásolni a magasságokat
        String[] cm = new String[37];
        for (int sor = 0; sor < t.length; sor++) {
            cm[sor] = t[sor][2]; // magasságok
        }
        for (int sor = 0; sor < t.length; sor++) {
            //  a cm[]-t átadni az minimum(tmp[]) függvénynek
            if (Integer.parseInt(t[sor][2]) == minimum(cm)) {
                // végig tömbön, akik cm_min magasak azokat kiírni
                System.out.println(String.format("%18s %6s %2s", new Object[] { t[sor][0], t[sor][2], "cm" }));
            }
        } 
    }
    
    static void tti_file(String f_neve) {
        System.out.println("");
        System.out.println(" 3. TI számítása");
        File f1 = new File(f_neve);
        if (f1.exists()) {
            f1.delete();
        }
        try {
            f = new RandomAccessFile(f_neve, "rw");
            int SorokN = t.length;
            for (int sor = 0; sor < SorokN; sor++) {
                f.writeBytes(String.format("%18s %3.2f\n", new Object[] { t[sor][0], Double.valueOf(tti(t[sor])) }));
            }
            f.close();
        } catch (Exception e) {
            System.out.println("Nem sikerült!");
        }
        System.out.println(" " + f_neve + " írása ... kész!");
        System.out.println("");
    }
    
    static void legkonnyebbLanyok() {
        System.out.println(" 4. Legkönnyebb lány tanulók adatai!");
        int N = 0; // lányok létszáma
        for (int sor = 0; sor < t.length; sor++) {
            if (t[sor][1].equals("L")) {
                N++;
            }
        }
        String[] kg = new String[N]; // a tömb.hossza = a lányok létszáma
        int i = 0; // a lányok kg[] indexe lesz
        for (int sor = 0; sor < t.length; sor++) {
            if (t[sor][1].equals("L")) {
                kg[i] = t[sor][3];
                i++;
            }
        }
        int min_kg = minimum(kg);
        for (int sor = 0; sor < t.length; sor++) {
            if ((t[sor][1].equals("L")) && (Integer.parseInt(t[sor][3]) == min_kg)) {
                System.out.println(String.format("%18s %6s kg %6s cm %8.2f", new Object[] { t[sor][0], t[sor][2], t[sor][3], Double.valueOf(tti(t[sor])) }));
            }
        }
    }
    
    static void stop() {
        System.out.println("\n<<Kilepeshez: ENTER>>");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
  
  public static void main(String[] args) {
    adatokBe("adatok.txt");
    magasabbak();
    legek();
    tti_file("tti.txt");
    legkonnyebbLanyok();
    stop();
  }
}

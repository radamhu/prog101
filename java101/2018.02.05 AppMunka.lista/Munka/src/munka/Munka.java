package munka;

import java.io.*;
import java.util.*;
    
public class Munka {
    
    static RandomAccessFile f;
    static ArrayList<Szaki> szakik = new ArrayList<>();
    // Szaki lesz az osztályom, a szakik meg a nagy szaki lista
    
    static void adatokBe(String f_neve) {
        System.out.println(" 1. Az adatok beolvasás a(z) " + f_neve + " fájlból");
        try {
            f = new RandomAccessFile(f_neve, "r");    
            String sor = f.readLine(); // innentől a konstruktornak a feladata feldolgzoni az adatot
            while (sor != null) { // ha nem üres, átadom a konstruktornak                
                szakik.add(new Szaki(sor)); // hozzáadja a szakik fürthöz
                sor = f.readLine();
            }
            f.close();
        } catch (IOException e) {
            System.err.println("Baj van babám");
        }
        System.out.println("    az adatok.txt beolvasás ... kész!");
        System.out.println();
    }
    
    static void  tblKi() {
        int N = szakik.size(); // egész fürtnek a mérete, 
        // listához csak metódussal lehet hozzéférni
        System.out.println(" \nStatisztika:");
        for (int i = 0; i < N; i++) {
            System.out.println(szakik.get(i).toString());
            // a szakik i-eik elemét
        }
    }
    
    static void szummaDe_Du() {
        int N = szakik.size();
        System.out.println("");
        System.out.println("Statisztika délelőtt délután: ");
        for (int i = 0; i < N; i++) {
            System.out.println(
                    String.format(
                            "%16s %5d %5d", 
                            szakik.get(i).getNev(), 
                            szakik.get(i).szummaDe(), 
                            szakik.get(i).szummaDu()));
        }
    }
    
    public static void main(String[] args) {
        adatokBe("adatok.csv");
        tblKi();
        szummaDe_Du();
    }
}

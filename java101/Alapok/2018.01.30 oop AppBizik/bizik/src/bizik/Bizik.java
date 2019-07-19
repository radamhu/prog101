package bizik;

import java.io.*;
import java.util.*;

public class Bizik {
    
    static RandomAccessFile f;
    static ArrayList<Rekordok> tanulok = new ArrayList<>();
    
    static void  feladat1(String f_neve) {
        System.out.println(" 1. Az adatok beolvasás a(z) " + f_neve + " fájlból");
        String tmp[];
        try {
            f = new RandomAccessFile(f_neve, "r");
            
            for (int i = 0; i<9; i++) {
                tmp = f.readLine().split("\t"); 
                tanulok.add(new Rekordok(tmp));
                //System.out.println(tmp[0]);
            }
            f.close();
        } catch (IOException e) {
            System.err.println("Baj van babám");
        }
        System.out.println("    az adatok.txt beolvasás ... kész!");
        System.out.println();
    }
    
    static void teszt() {
        int N = tanulok.size();
        System.out.println("\nStatisztika:");
        for (int i = 0; i < N; i++) {
            System.out.println(tanulok.get(i).toString());
        }
    }
    
    static void waitig() {
        System.out.println("<<Kilépéshez: ENTER>>");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
    
    public static void main(String[] args) {  
        feladat1("adatok.txt");
        teszt();
        // waitig();
    }
}

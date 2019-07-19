package bicikliverseny;

import java.io.*;
import java.util.*;

public class Bicikliverseny {

    static RandomAccessFile f;
    static ArrayList<Biciklis> biciklisek = new ArrayList<>();
    // Szaki lesz az osztályom, a szakik meg a nagy szaki lista

    static void adatokBe(String f_neve) {
        System.out.println(" 1. Az adatok beolvasás a(z) " + f_neve + " fájlból");
        try {
            f = new RandomAccessFile(f_neve, "r");
            String sor = f.readLine(); // innentől a konstruktornak a feladata feldolgzoni az adatot
            while (sor != null) { // ha nem üres, átadom a konstruktornak                
                biciklisek.add(new Biciklis(sor)); // hozzáadja a szakik fürthöz
                sor = f.readLine();
            }
            f.close();
        } catch (IOException e) {
            System.err.println("Baj van babám");
        }
        System.out.println("    az adatok.txt beolvasás ... kész!");
        System.out.println();
    }

    static void Teszt() {
        int N = biciklisek.size();
        for (int i = 0; i < N; i++) {
            System.out.println(
                    String.format(
                            "%16s",
                            biciklisek.get(i).toString()));
        }
    }
    
    static void pontJavitas() {
        int N = biciklisek.size();
        java.util.Scanner sc= new java.util.Scanner(System.in);
        System.out.println("");
        System.out.print("biciklis neve: "); String nEv = sc.nextLine();
        System.out.print("hányadik nap: "); int nap = sc.nextInt();
        System.out.print("új km: "); int ujKm = sc.nextInt();
        nap--;
        int i = 0;
        while (!biciklisek.get(i).getNev().equals(nEv)) {            
            System.out.println(biciklisek.get(i).getNev());
            i++;
        }
        biciklisek.get(i).setKm(nap, ujKm);
    }
    
    static void ENTER() {
        System.out.println("Nyomj egy ENTER-t");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

public static void main(String[] args) {
        adatokBe("bringa.txt");
        Teszt();
        pontJavitas();
        Teszt();
        ENTER();
    }
}

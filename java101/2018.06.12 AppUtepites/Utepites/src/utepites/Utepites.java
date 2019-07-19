package utepites;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Utepites {

    // globális változók
    static RandomAccessFile f;
    private static ArrayList<Auto> autok = new ArrayList<>();
    static java.util.Scanner sc = new java.util.Scanner(System.in);
    
    // Adatok beolvasása
    static void f1(String fNev) {
        System.out.println("\n1. feladat:");
        System.out.println("Adatok beolvasása...");
        try {
            f = new RandomAccessFile(fNev, "r");
            String sor;
            while ((sor = f.readLine()) != null) {
                autok.add(new Auto(sor));
            }
            f.close();
        } catch (IOException e) {
            System.out.println("Hiba");
        }
        System.out.println("\taz " + fNev + " fájl beolvasása ...... kész!");
    }
    
    static void f2() {
        System.out.println("\n2. feladat:");       
        System.out.print("   Adja meg a jármű sorszámát! ");
        int n = sc.nextInt();
        if (((Auto)autok.get(n - 1)).getIrany().equals("A")) {
            System.out.println("\tA jármű B felé haladt");
        } else {
            System.out.println("\tA jármű A felé haladt");
        }        
    }
    
    static void f3() {
        System.out.println("\n3. feladat: ");
        int i = autok.size() - 1;
        while (!((Auto)autok.get(i)).getIrany().equals("A")) {
            i--;
        }
        
        int d = ((Auto)autok.get(i)).getMp_ido();
        i--;
        
        while (!((Auto)autok.get(i)).getIrany().equals("A")) {
            i--;
        }
        d -= ((Auto)autok.get(i)).getMp_ido();
    
        System.out.println("\tB-be tartó utolsó két jármű " + d + " másodperc eltéréssel követte egymást.");
    }
    
      static void f4()
  {
    System.out.println("\n4. feladat: Statisztika");
        int N = autok.size();
        int[] A = new int[10];
        int[] B = new int[10];
        for (int i = 0; i < N; i++) {
            if (((Auto)autok.get(i)).getIrany().equals("A")) {
                A[(((Auto)autok.get(i)).getOra()- 7)] += 1;
            } else {
                B[(((Auto)autok.get(i)).getOra()- 7)] += 1;
            }
        }
        System.out.println("\t\t    A-ból  B-ből");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%11d. óra %6d  %5d\n", i+7, A[i], B[i]);
        }
    }
      
    public static void main(String[] args) {
        f1("adatok.txt");
        f2();
        f3();
        f4();
    }
}

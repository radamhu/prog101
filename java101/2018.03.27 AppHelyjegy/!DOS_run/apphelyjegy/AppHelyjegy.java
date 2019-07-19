package apphelyjegy;

import java.io.*;
import java.util.*;

public class AppHelyjegy {

    static RandomAccessFile f;
    static ArrayList<Utas> utasok = new ArrayList<>();// Lista 

    static void f1(String f_neve) {
        System.out.println("1. feladat: az adatok beolvasása a(z) " + f_neve + " fájlból");
        //első sor: 113 172 71
        try {
            f = new RandomAccessFile(f_neve, "r");

            String sor = f.readLine();
            while (sor != null) {
                utasok.add(new Utas(sor));
                sor = f.readLine();
            }
            f.close();
        } catch (IOException e) {
            System.err.println("HIBA");
        }
        System.out.println("\tA fájl beolvasása ......" + " kész!");
    }

    static void f2() {
        System.out.println("\n2. feladat: utolsó utas");
        int N = utasok.size();
        System.out.println(String.format("%15s %3d", "sorszám: ", N));
        System.out.println(String.format("%15s %3d", "ülés: ", utasok.get(N - 1).getSzék()));
        System.out.println(String.format("%15s %3d", "km: ", utasok.get(N - 1).getKm()));
    }

    static void f3() {
        System.out.println("\n3. feladat: hol ültek, akik végig utaztak");
        int N = utasok.size();
        System.out.print(String.format("%15s", "ülések: "));
        for (int i = 0; i < N; i++) {
            if (utasok.get(i).isVégig()) {
                System.out.print(utasok.get(i).getSzék() + " ");
            }
        }
        System.out.println();
    }

    static void f4() {
        System.out.println("\n4. feladat: 100 km-nél többet utaztak");
        int N = utasok.size();
        System.out.println(
                String.format("%15s   %3s  %6s ", "sorszám", "km", "Ft")
        );
        for (int i = 0; i < N; i++) {
            if (utasok.get(i).getKm() > 100) {
                System.out.println(
                        String.format("%13d  %6d  %6d ",
                                i + 1,
                                utasok.get(i).getKm(),
                                utasok.get(i).getFt())
                );
            }
        }
    }

    static void f5() {
        System.out.println("\n5. feladat: ");
        int N = utasok.size();

        int szum = 0;
        for (int i = 0; i < N; i++) {
            szum = szum + utasok.get(i).getFt();
        }
        System.out.println("\tÖssz bevétel: " + szum + " Ft");

    }

    static void f61() {
        System.out.println("\n6. (+) feladat: ");
        int[] stop = new int[173];
        int N = utasok.size();
        for (int i = 0; i < N; i++) {
            stop[utasok.get(i).getMettől()] = 1;//22
            stop[utasok.get(i).getMeddig()] = 1;//23
        }
        int szum = 0;
        for (int i = 0; i < 172; i++) {
            szum = szum + stop[i];
        }
        System.out.println("\tMegállók száma: " + szum);

    }

    static void f6() {
        System.out.println("\n6. (+) feladat: melyik km-nél van megálló: ");
        int[] stop = new int[173];
        int N = utasok.size();
        for (int i = 0; i < N; i++) {
            stop[utasok.get(i).getMettől()] = 1;
            stop[utasok.get(i).getMeddig()] = 1;
        }
        System.out.print("\t");
        int szum = 0;
        for (int i = 0; i < 173; i++) {
            if (stop[i] != 0) {
                System.out.print(" " + i);
            }
            szum = szum + stop[i];
        }
        System.out.println("\n\t Megállók száma: " + szum);

    }

    static void f7() {
        System.out.println("\n7. (+) feladat:");
        int[] stop = new int[173];
        int N = utasok.size();
        for (int i = 0; i < N; i++) {
            stop[utasok.get(i).getMeddig()] = stop[utasok.get(i).getMeddig()] + 1;
        }
        int maxID = 0;
        for (int i = 0; i < 173; i++) {
            if (stop[i] != 0) {
                //System.out.print(" " + stop[i]);
            }
        }
        for (int i = 0; i < 173; i++) {
            if (stop[i] > stop[maxID]) {
                maxID = i;
            }
        }
        System.out.println("\tA " + maxID + " km-nél szálltak le a legtöbben: " + stop[maxID] + " fő");
    }
    

    static void DOSablak() {
        System.out.print("\n\n<<Kilépéshez: ENTER>>");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    public static void main(String[] args) {
        f1("eladott.txt");     
        f2();
        f3();
        f4();
        f5();
        f6();
        f7();
        DOSablak();        
    }

}

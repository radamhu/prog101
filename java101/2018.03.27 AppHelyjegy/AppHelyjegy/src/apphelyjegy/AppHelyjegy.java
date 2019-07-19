package apphelyjegy;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AppHelyjegy {

    //Globális változók
    private static ArrayList<Utas> utasok = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    //1. feladat: adatokBe
    private static void f1(String fileNev) {
        System.out.printf("1. Az adatok beolvasása a(z) %s fileból\n", fileNev);
        try {
            System.out.print("  A fájl beolvasása ... kész! ");
            RandomAccessFile file = new RandomAccessFile(fileNev, "r");
            String sor;

            while ((sor = file.readLine()) != null) {
                utasok.add(new Utas(sor));
            }

            file.close();
            System.out.println("sikeres!");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();
    }
    
    // 2. Adja meg a legutolsó jegyvásárló sorszámát, ülésének számát és az általa beutazott távolságot! 
    private static void f2() {
        System.out.println("\n2. feladat:  legutolsó jegyvásárló sorszámát, ülésének számát és az általa beutazott távolságot");
        int N = utasok.size();
        System.out.println(String.format("%15s %3d", "sorszám: ", N));
        System.out.println(String.format("%15s %3d", "ülés: ", utasok.get(N - 1).getSzek()));
        System.out.println(String.format("%15s %3d", "km: ", utasok.get(N - 1).getKm()));
    }

    //  3. Listázza ki, kik utazták végig a teljes utat! 
    private static void f3(){
        System.out.println("\n3. feladat:  hol ültek akik végig utaztak");
        int N = utasok.size();
        System.out.print(String.format("%15s", "ülések: "));
        for (int i = 0; i < N; i++) {
            if (utasok.get(i).isVegig()) {
                System.out.print(utasok.get(i).getSzek() + " ");
            }
        }
        System.out.println();
    }    
    
    // 4. Sorszám, megtett út és mennyit fizetett az, aki többet utazott mint100 km.
    private static void f4(){
        System.out.println("\n4. feladat:  100km-nél többet utaztak");
        int N = utasok.size();
        System.out.println(
                String.format("%15s %5s %5s", "sorszám", "km", "Ft"));
        for (int i = 0; i < N; i++) {
            if (utasok.get(i).getKm() > 100) {
                System.out.println(
                        String.format("%13d %6d %6d", 
                                i + 1, 
                                utasok.get(i).getKm(), 
                                utasok.get(i).getFt()));
            }
        }
        System.out.println();

    }
    
    // 5. Határozza meg, hogy a jegyekből mennyi bevétele származott a társaságnak! 
    private static void f5(){
        System.out.println("\n5. feladat:");
        int N = utasok.size();
        int osszes = 0;
        for (int i = 0; i < N; i++) {
            osszes = osszes + utasok.get(i).getFt();
        }
        System.out.println("\tÖsszes bevétel: " + osszes + " Ft");
    }
    
    public static void main(String[] args) {
        f1("eladott.txt");
        f2();
        f3();
        f4();
        f5();
    }
}

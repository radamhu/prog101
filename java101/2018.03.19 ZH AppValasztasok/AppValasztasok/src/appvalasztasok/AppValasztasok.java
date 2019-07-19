package appvalasztasok;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AppValasztasok {

    //Globális változók
    private static ArrayList<Jelolt> jeloltek = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    //1. feladat: adatokBe
    private static void f1(String fileNev) {
        System.out.printf("1. Az adatok beolvasása a(z) %s fileból\n", fileNev);
        try {
            System.out.print("  A fájl beolvasása ... kész! ");
            RandomAccessFile file = new RandomAccessFile(fileNev, "r");
            String sor;
            while ((sor = file.readLine()) != null) {
                jeloltek.add(new Jelolt(sor));
            }

            file.close();
            System.out.println("sikeres!");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();
    }
    
    //2. feladat: függetlenek
    static void f2() {
        System.out.println("2. feladat: a független jelöltek");
        int szavazatok = 0;
        int N = jeloltek.size();
        for (int i = 0; i < N; i++) {
            if (jeloltek.get(i).getPart().equals("függetlenek")) {
                System.out.println(String.format("%20s %5s", jeloltek.get(i).getNev(), jeloltek.get(i).getSzavazatok()));
                szavazatok += jeloltek.get(i).getSzavazatok();
            }
        }
        System.out.println("Összesen: " + szavazatok);
        System.out.println("");
    }
    
    //3. feladat: A 7. körzet győztese 
    static void f3() {
        System.out.println("3. feladat: a 7. körzet győztese");
        int N = jeloltek.size();
        int id = 0;
        int max = 0;
        
        for (int i = 0; i < N; i++) {
            if (jeloltek.get(i).getKorzet() == 7) {
                // System.out.println(jeloltek.get(i).getNev());
                if (max < jeloltek.get(i).getSzavazatok()) {
                    max = jeloltek.get(i).getSzavazatok();
                    id = i;
                }
            }
        }
        System.out.println(String.format("%20s %5s", jeloltek.get(id).getNev(), jeloltek.get(id).getSzavazatok()));
        System.out.println("");
    }

    //4. feladat: képviselő adatai
    static void f4() {
       System.out.println("4. feladat: képviselő adatai");
       System.out.print("Kérem a képviselő nevét (pl: Kupa Huba): ");
       String ScNev = sc.nextLine();
       int N = jeloltek.size();
       for (int i = 0; i < N; i++) {
           if (jeloltek.get(i).getNev().equals(ScNev)) {
               System.out.println("szavazatok száma: " + jeloltek.get(i).getSzavazatok());
           }
       }
       System.out.println();
    }
    
    public static void main(String[] args) {
        f1("szavazatok.txt");
        f2();
        f3();
        f4();
    }
}

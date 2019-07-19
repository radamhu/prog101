package apprgb;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AppRGB {

    //Globális változók
    static RandomAccessFile f;
    private static ArrayList<Pixel> pixelek = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    
    //1. feladat: adatokBe
    // másolás tétele
    private static void f1(String fileNev) {
        System.out.printf("1. Az adatok beolvasása a(z) %s fileból\n", fileNev);
        try {
            System.out.print("  A fájl beolvasása ... kész! ");
            RandomAccessFile file = new RandomAccessFile(fileNev, "r");
            
            for (int s = 1; s < 50; s++) {
                for (int o = 1; o < 50; o++) {
                    String px = file.readLine();
                    pixelek.add(new Pixel(px, s, o)); // konstruktor hívása
                }
            }
            file.close();
            System.out.println("sikeres!");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();
    }
    
    // 2. Egy tetszőleges (input) RGB kódú pixel megtalálható-e a képen, ha igen hol? px(x, y)
    // lineáris keresés
    private static void f2() {
        int N = pixelek.size();
        System.out.println("");
        System.out.println("2. feladat: ");
        System.out.print(String.format("%20s", "Kérem az RGB kódot (pl.: 255 255 0):"));
        String px = sc.nextLine();
        
        int i = 0;
        while ( i<N && !(pixelek.get(i).getRgb().equals(px))) {            
            i++;
            // System.out.println(i);
        }
        if (i < N) {
            System.out.println("Pixelhelye: " + pixelek.get(i).getSor() + pixelek.get(i).getOszlop() );
        } else {
            System.out.println("A pixel nincs a képen");
        }
    }

    // 3. A kép px(35, 11) képpontjának színe milyen RGB kódú és hányszor szerepel a 35. sorban, illetve a 11. oszlopban.
    // kiválasztás, megszámlálás
    private static void f3() {
        int N = pixelek.size();
        System.out.println("");
        System.out.println("3. feladat: ");
        System.out.print(String.format("%20s", " a 35. sor 11. képpontjának kódja, hányszor szerepel ez a kód az adott sorban ill. oszlopban: "));
        
        int i = 0;
        while (!(pixelek.get(i).getSor() == 35 && pixelek.get(i).getOszlop() == 11)) {            
            i++;
        }
        
        String px = pixelek.get(i).getRgb();
        int sDB = 0;
        int oDB = 0;
        for (i = 0; i < N; i++) {
            if (pixelek.get(i).getSor() == 35 && pixelek.get(i).getRgb().equals(px)) {
                sDB++;
            }
            if (pixelek.get(i).getOszlop() == 11 && pixelek.get(i).getRgb().equals(px)) {
                oDB++;
            }
        }
        System.out.println("");
        System.out.println(px + "\n" + sDB + "\n" + oDB);
    }
    
    // 4. feladat: A vörös, zöld és kék színek közül melyik szín fordul elő legtöbbször a képen?
    // megszámlálás (tömbbe), maximum kiválasztás
    private static void f4() {
        int N = pixelek.size();
        System.out.println("");
        System.out.println("4. feladat: ");
        System.out.print(String.format("%20s", "A vörös, kék és zöld színek közül a leggyakoribb: "));
  
        int rgbDB[] = {0, 0, 0};
        for (int i = 0; i < N; i++) {
            switch (pixelek.get(i).getRgb()) {
                case "255 0 0":
                    rgbDB[0]++;
                    break;
                case "0 255 0":
                    rgbDB[1]++;
                    break;
                case "0 0 255":
                    rgbDB[2]++;
                    break;
            }
        }
        String color[] = {"vörös", "zöld", "kék"};
        int max = 0;
        String c = "";
        for (int i = 0; i < 3; i++) {
            if (rgbDB[i] > max) {
                max = rgbDB[i];
                c = color[i];
            }
        }
        System.out.println("\n" + rgbDB[0] + " " + rgbDB[1] + " " + rgbDB[2]);
        System.out.println(c + "\n" + max);
    }
    
    public static void main(String[] args) {
        f1("kep.txt");
        // f2();
        f3();
        f4();
    }
}

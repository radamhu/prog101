package homerseklet;

import java.io.*;
import java.util.Arrays;

public class Homerseklet {
    
    static String t[][] = new String[10][7];
    static RandomAccessFile f;
    
    static void adatokBe(String f_neve){ // 
        try {
            f = new RandomAccessFile(f_neve, "r");
            int sorokN = t.length;
            for (int sor = 0; sor<sorokN; sor++) {
                t[sor] = f.readLine().split("\t"); //egyből a tömb sorainak feltöltése
            }
            f.close();
        } catch (IOException e) {
            System.out.println("Baj van babám");
        }
        System.out.println("    az homersekletek.txt beolvasás ... kész!");
        System.out.println();
    }
    
    static  int szumma (String t1[]) {
        int N = t1.length, s = 0;
        for (int i = 0; i < N; i++) {
            s += Integer.parseInt(t1[i]);
        }
        return s;
    }
    
    static int maximum (String t1[]) {
        int max=(Integer.parseInt(t1[0]));
        int N = t1.length;
        for (int i = 0; i < N; i++) {
            if ((Integer.parseInt(t1[i]))>max) {
                max=(Integer.parseInt(t1[i]));
            }
        }
        return max;
    }

    static int minimum (String t1[]) {
        int min=(Integer.parseInt(t1[0]));
        int N = t1.length;
        for (int i = 0; i < N; i++) {
            if ((Integer.parseInt(t1[i]))<min) {
                min=(Integer.parseInt(t1[i]));
            }
        }
        return min;
    }
    
    static int negativDB (String t1[]) {
        int db2=0;
        int N = t1.length;
        for (int i = 0; i < N; i++) {
            if ((Integer.parseInt(t1[i])) < 0) {
                db2++;
            }
        }
        return db2;
    }
    
    static void adatokKi(String f_neve){ // 
        try{
            f = new RandomAccessFile(f_neve,"rw");
            int N =t.length;
            for (int sor =0; sor<N; sor++){
                f.writeBytes((sor+1)+". het"+"\n");
                f.writeBytes(String.format("%10s %5s","osszeg:",szumma(t[sor])+"\n")); // fájl írása
                f.writeBytes(String.format("%10s %5s","maximum:",maximum(t[sor])+"\n")); // fájl írása
                f.writeBytes(String.format("%10s %5s","minimum:",minimum(t[sor])+"\n")); // fájl írása
                f.writeBytes(String.format("%10s %5s","negativ:",negativDB(t[sor])+"\n")); // fájl írása
            }
            f.close();
        }catch(IOException e){
            System.out.println("Baj van babám");
        }
        System.out.println("\t"+ f_neve+" írása ......"+" kész!");
    }
    
    public static void main(String[] args) {
        adatokBe("homersekletek.txt");
        adatokKi("statisztika.txt");
    }
    
}

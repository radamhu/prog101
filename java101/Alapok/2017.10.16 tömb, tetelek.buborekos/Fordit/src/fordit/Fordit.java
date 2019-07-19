package fordit;

import java.util.Random;
import java.util.Scanner;

public class Fordit {
    
    static int[] sor = {1,2,3,4,5,6,7,8,9};
    static Scanner bill = new Scanner(System.in);
    
    static void kiir() {
        for (int i = 0; i < sor.length; i++) {
            System.out.print(sor[i] + " ");
        }
        System.out.println("");
    }
    
    static void megfordit(int n) {
        int x;
        for (int i = 0; i < n/2; i++) {
            x = sor[i];
            sor[i] = sor[n-i-1];
            sor[n-i-1] = x;
        }
    }
    
    static int beolvas() {
        int be;
        do {            
            System.out.print("hányat fordítsak meg? ");
            be = bill.nextInt();
        } while (be < 2 || be > 9);
        return be;
    }
    
    static void kever(int hanyszor) {
        Random vg = new Random();
        int db;
        for (int i = 0; i < hanyszor; i++) {
            db = vg.nextInt(8) + 2;
            megfordit(db);
        }
    }
    
    static boolean kesz() {
        for (int i = 0; i < 9; i++) {
            if (sor[i] != i+1) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        //kever(50);
        megfordit(beolvas());
        kiir();
        if (kesz()) {
            System.out.println("Kész!");
        } else {
            System.out.println("Nincs kész!");
        }
    }
}

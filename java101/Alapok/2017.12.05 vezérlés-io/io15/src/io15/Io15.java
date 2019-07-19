package io15;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Io15 {

    static  String t[]=new String[10];
    
    static void f1(){ // 
        RandomAccessFile f; String sor;
        try {
            f = new RandomAccessFile("io_15.txt", "r");
            sor=f.readLine();
            t=sor.split(",");
            f.close();
        } catch (IOException e) {
            System.out.println("Hiba");
        }
        System.out.println("    az io_15.txt beolvasás ... kész!");
        System.out.println();
    }
    
    static void f2(){
        
        int N1=0, N = t.length;
        System.out.println("Statisztika: ");
        
        for (int i = 0; i < N; i++) {
            N1=N1+(Integer.parseInt(t[i]));
        }
        System.out.println("    összeg: "+N1);
        
        int min=(Integer.parseInt(t[0]));
        for (int i = 0; i < N; i++) {
            if ((Integer.parseInt(t[i]))<min) {
                min=(Integer.parseInt(t[i]));
            }
        }
        System.out.println("    minimum: "+min);
        
        int max=(Integer.parseInt(t[0]));
        for (int i = 0; i < N; i++) {
            if ((Integer.parseInt(t[i]))>max) {
                max=(Integer.parseInt(t[i]));
            }
        }
        System.out.println("    maximum: "+max);
        
        int db=0;
        N = t.length;
        for (int i = 0; i < N; i++) {
            if ((Integer.parseInt(t[i])) == 8) {
                db++;
            }
        }
        System.out.println("    8-as db: "+db);
        
        int db2=0;
        N = t.length;
        for (int i = 0; i < N; i++) {
            if ((Integer.parseInt(t[i])) < 0) {
                db2++;
            }
        }
        System.out.println("    negatívok db: "+db2);
        
        N = t.length;
        boolean van100as = false;
        for (int i = 0; i < N; i++) {
            if ((Integer.parseInt(t[i])) == 100) {
                van100as = true;
            }
        }
        if (van100as) {
            System.out.println(" 100-as van");
        } else {
            System.out.println(" 100-as nincs");
        }
    }
    
    public static void main(String[] args) {
        f1();
        f2();
    }
    
}

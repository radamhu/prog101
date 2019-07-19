package io_11;

import java.io.*;

public class Io_11 {
    
    static  String t[]=new String[10];
    
    static void f1(){ // tudjuk, h 10 sorból álló a fájl
        RandomAccessFile f;
        try {
            f = new RandomAccessFile("io_11.txt", "r");
            for (int i = 0; i < 10; i++) {
                t[i]=f.readLine();
            }
            f.close();
            System.out.println("1. feladat");
            System.out.println("    az io_11.txt beolvasás ... kész!");
        } catch (IOException e) {
            System.out.println("Hiba");
        }
    }
    
    static void f2() {
        System.out.println("2. feladat");
        int s = 0, N = t.length;
        for (int i = 0; i < N; i++) {
            s=s+(Integer.parseInt(t[i]));
        }
        System.out.println("    összeg: "+s);
        
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
        
    }
    
    public static void main(String[] args) {
        f1();
        f2();
    }
}

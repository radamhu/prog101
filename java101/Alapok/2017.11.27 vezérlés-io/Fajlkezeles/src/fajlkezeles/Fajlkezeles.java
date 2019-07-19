package fajlkezeles;

import java.io.*;

public class Fajlkezeles {
    static  String t[]=new String[10];
    static void f1(){ // tudjuk, h 10 sorból álló a fájl
        RandomAccessFile f;
        try {
            f = new RandomAccessFile("adatok.txt", "r");
            for (int i = 0; i < 10; i++) {
                t[i]=f.readLine();
            }
            f.close();
        } catch (IOException e) {
            System.out.println("Hiba");
        }
    }
    
    static void f2(){
        int N = t.length;
        for (int i = 0; i < N; i++) {
            System.out.println(t[i]);
        }
    }
    
    public static void main(String[] args) {
        f1();
        f2();
    }
}

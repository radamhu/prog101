package io14;
import java.io.*;
import java.util.Arrays;

public class Io14 {
    
    static  String t[]=new String[10];
    
    static void f1(){ // 
        RandomAccessFile f; String sor;
        try {
            f = new RandomAccessFile("io_14.txt", "r");
            sor=f.readLine();
            t=sor.split(",");
            f.close();
        } catch (IOException e) {
            System.out.println("Hiba");
        }
        System.out.println("    az io_14.txt beolvasás ... kész!");
        System.out.println();
    }
    
static void f2() {
        
        int N1, N = t.length;
        for (int i = 0; i < N; i++) {
            N1 = Integer.parseInt(t[i]);
            for (int j = 0; j < N1+1; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        f1();
        f2();
    }
    
}

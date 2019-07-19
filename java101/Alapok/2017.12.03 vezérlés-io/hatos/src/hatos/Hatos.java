package hatos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Hatos {
    
    static int[][] szamok = new int[400][6];
    static int db = 0;
    static int [] stat = new int[46];
    
    static void feltolt(String s) {
        Scanner olvas = new  Scanner(s);
        for (int i = 0; i < 6; i++) {
            szamok[db][i] = olvas.nextInt();
        }
    }

    static void statisztika() {
        // megszámlálás
        for (int i = 0; i < db; i++) {
            for (int j = 0; j < 6; j++) {
                stat[szamok[i][j]]++;
            }
        }
               
        // listázás
        for (int i = 1; i < 46; i++) {
            System.out.println(stat[i] + " ");
            if (i % 10 == 0) 
                System.out.print("");
        }
        System.out.println("");
    }
    
    static void legtobbszor() {
        int szam = 1;
        int max = stat[1];
        for (int i = 0; i < 46; i++) {
            if (stat[i] > max) {
                max = stat[i];
                szam = i;
            }
        }
        System.out.println("Legtöbbször húzott: " + szam);
    }
    
    public static void main(String[] args) throws Exception{
        File fbe = new  File("hatos.txt");
        Scanner be = new Scanner(fbe);
        while (be.hasNextLine()) {            
            String sor = be.nextLine();
            feltolt(sor);
            db++;
        }
        be.close();
        statisztika();
        legtobbszor();
    }
}

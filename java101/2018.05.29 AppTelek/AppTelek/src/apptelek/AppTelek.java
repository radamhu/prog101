package apptelek;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class AppTelek
{
    //Globális változók
    static RandomAccessFile f;
    static ArrayList<Telek> telkek = new ArrayList();

    // Adatok beolvasása
    // másolás <Telek> telkek
    // a szokásos módon egy sor kiolvasása és a konstruktor hívása. A szeletelés a class feladata!
    static void f1(String fNev) {
        System.out.println("\n1. feladat:");
        System.out.println("\taz adatok beolvasása a(z) " + fNev + " fájlból.");
        try
        {
          f = new RandomAccessFile(fNev, "r");
          int i = 0;
          String sor;
          while ((sor = f.readLine()) != null) {
            telkek.add(new Telek(sor));
          }
          f.close();
        }
        catch (IOException e)
        {
          System.err.println("HIBA");
        }
            System.out.println("\taz " + fNev + " fájl beolvasása ...... kész!");
    }

    // A lakótelep avatására futóversenyt hirdetnek. Hány métert kell annak futnia, aki körbe futja a tele-pet? 
    // A kiszámított távolságot írassa ki a képernyőre!
    // összegzés
    // végig a listá: 160 + szélességek összege!
    static void f2() {
        System.out.println("\n2. feladat:");
        int SZumma = 160;
        for (int i = 0; i < telkek.size(); i++) {
            SZumma += ((Telek)telkek.get(i)).getSz();
        }
        System.out.println("\ta futás: " + SZumma + " m hossú!!!");
    }
  
    static void f3()
    {
      System.out.println("\n3. feladat:");
      int db = 0;
      for (int i = 0; i < telkek.size(); i++) {
        if ((((Telek)telkek.get(i)).getHsz() % 2 == 0) && (((Telek)telkek.get(i)).getSz() < 21)) {
          db++;
        }
      }
      System.out.println("\t" + db + " telekre vonatkozik a beépítés");
    }
  
    static void f4()
    {
      System.out.println("4. feladat:");
      int minIndex = 0;
      int maxIndex = 0;
      for (int i = 1; i < telkek.size(); i++)
      {
        if ((((Telek)telkek.get(i)).getHsz() % 2 == 1) && (((Telek)telkek.get(minIndex)).getT() > ((Telek)telkek.get(i)).getT())) {
          minIndex = i;
        }
        if ((((Telek)telkek.get(i)).getHsz() % 2 == 1) && (((Telek)telkek.get(maxIndex)).getT() < ((Telek)telkek.get(i)).getT())) {
          maxIndex = i;
        }
      }
      int db = Math.abs(((Telek)telkek.get(minIndex)).getHsz() - ((Telek)telkek.get(maxIndex)).getHsz()) / 2;
      System.out.println("\t   legkisebb telek hsz: " + ((Telek)telkek.get(minIndex)).getHsz() + " területe:  " + ((Telek)telkek.get(minIndex)).getT() + " m2");
      System.out.println("\t legnagyobb telek hsz: " + ((Telek)telkek.get(maxIndex)).getHsz() + " területe: " + ((Telek)telkek.get(maxIndex)).getT() + " m2");
      System.out.println("\t     köüztk lévő házak: " + (db - 1));
    }
  
    public static void main(String[] args)
    {
      f1("adatok.txt");  
      f2();
      f3();
      f4();
    }
}

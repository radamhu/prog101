package apptarsalgo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;
import sun.security.pkcs11.Secmod;

public class AppTarsalgo {

    //Globális változók
    static RandomAccessFile f;
    private static ArrayList<Adat> adatok = new ArrayList<>();
    static java.util.Scanner sc = new java.util.Scanner(System.in);

    // Adatok beolvasása
    // tétel: másolás
    static void f1(String fNev) {
        System.out.println("\n1. feladat:");
        System.out.println("Adatok beolvasása...");
        try {
            f = new RandomAccessFile(fNev, "r");
            String sor;
            while ((sor = f.readLine()) != null) {
                adatok.add(new Adat(sor));
            }
            f.close();
        } catch (IOException e) {
            System.out.println("Hiba");
        }
        System.out.println("\taz " + fNev + " fájl beolvasása ...... kész!");
    }
    
    /*
    * Írja a képernyőre annak a személynek az azonosítóját, aki a vizsgált időszakon belül először lépett be az ajtón, 
    * és azét, aki utoljára távozott a megfigyelési időszakban!
    * tétel: kiválasztás
    * Először be: a lista 0. elemének a getId() metódusa
    * Utlojára ki: a lista végéről előre, amíg !(getHova()  ”ki”)
    */
    static void f2() {
        System.out.println("\n 2. feladat:");
        System.out.println("\t  Az első belépő: " + ((Adat)adatok.get(0)).getId());
        int i = adatok.size() - 1;
        while (!((Adat)adatok.get(i)).getHova().equals("ki")) {
          i--;
        }
        System.out.println("\tAz utolsó kilépő: " + ((Adat)adatok.get(i)).getId());
    }
    
    // Határozza meg a fájlban szereplő személyek (41 fő) közül, ki hányszor haladt át a társalgó ajtaján 
    // A meghatározott értékeket azonosító szerint növekvő sorrendben írja az athaladas.txt fájlba! 
    // Soronként egy személy azonosítója, és tőle egy szóközzel elválasztva az áthaladások száma szerepeljen!
    // tétel: kiválogatás tömbbe
    // új ID[42] //az ID[0] üres marad
    // 1.végig a listán : ID[getId()]++ //az ID[] feltöltése
    // 2.végig az ID[]-n: ha ID[i]!=0 akkor fájlba: (i, ” ”, ID[i])
    static void f3(String f_neve) {
        System.out.println("\n3. feladat:");
        int[] id = new int[42];
        int N = adatok.size();
        for (int i = 0; i < N; i++) {
            id[((Adat)adatok.get(i)).getId()] += 1;
        }
        File f1 = new File(f_neve);
        if (f1.exists()) {
            f1.delete();
        }
        try {
            f = new RandomAccessFile(f_neve, "rw");
            for (int i = 0; i < id.length; i++) {
                if (id[i] != 0 ) {
                    f.writeBytes( i + "" + id[i] + "\n");
                }
            }
            f.close();
        } catch (Exception e) {
            System.err.println("Nem jött létre a fájl!");
        }
        System.out.println("\ta " + f_neve + " fájl kiírása ..... készh!");
    }
    
    // Írja a képernyőre azon személyek azonosítóját, akik a vizsgált időszak végén a társalgóban tartózkodtak!
    // tétel: kiválogatás tömbbe
    // új ID[42]
    // 1.végig a listán: 
    //      ha getHova() <-> ”be” akkor ID[getId()]++ 
    //      ha getHova() <-> ”ki” akkor ID[getId()]--
    // 2.végig az ID[]-n: ha ID[i]!=0, akkor ki(i, ” ”)/
    static void  f4() {
        System.out.println("\n4. feladat:");
        int[] id = new int[42];
        int N = adatok.size();
        for (int i = 0; i < N; i++) {
            if (((Adat)adatok.get(i)).getHova().equals("be")) {
                id[((Adat)adatok.get(i)).getId()] += 1;
            }
            if (((Adat)adatok.get(i)).getHova().equals("ki")) {
                id[((Adat)adatok.get(i)).getId()] -= 1;
            }
        }
        System.out.print("\tA végén a társalgóban voltak: " );
        for (int i = 0; i < id.length; i++) {
            if (id[i] != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");
    }
    
    // Hányan voltak legtöbben egyszerre a társalgóban? 
    // Írja a képernyőre azokat az időpontak (óra:perc), amikor a legtöbben voltak bent.
    // göngyölítés tömbbe, ha „be” akkor az előző+1, különben előző-1
    // tétel: maximum (maxIndex) kiválasztás
    // új ID[N] //N=lista.mérete
    // ID[0]=1 //először bementek
    // 1.végig a listán: ha getHova()  ”be” akkor ID[i]=ID[i-1]+1 különben ID[i]=ID[i-1]-1
    // 2. max = maximum(ID[]) //ez már játékos gyermektorna 
    // 3. végig az ID[]-n: ha ID[i]= max akkor ki:( getÓra(),”:”,getPerc(),ID[i] )
    static void f5() {
        System.out.println("\n 5. feladat:");
        int N = adatok.size();
        int[] id = new int[N];
        id[0] = 1;
        for (int i = 1; i < N; i++) {
            if (((Adat)adatok.get(i)).getHova().equals("be")) {
                id[i] = (id[(i - 1)] + 1);
            } else {
                id[i] = (id[(i - 1)] - 1);
            }
        }
        int maxIndex = 0;
        for (int i = 1; i < N; i++) {
            if (id[maxIndex] < id[i]) {
                maxIndex = i;
            }
        }
        for (int i = 0; i < N; i++) {
            if (id[i] == id[maxIndex]) {
                int hh = ((Adat)adatok.get(i)).getOra();int pp = ((Adat)adatok.get(i)).getPerc();
                System.out.format("\t%2d:%2d-kor %2d fő volt a dohányzóban\n", new Object[] { Integer.valueOf(hh), Integer.valueOf(pp), Integer.valueOf(id[i]) });
            }
        }
    }
    
    public static void main(String[] args) {
        f1("adatok.txt");
        f2();
        f3("athaladas.txt");
        f4();
        f5();
    }
}

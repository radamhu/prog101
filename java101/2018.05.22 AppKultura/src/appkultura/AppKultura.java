package appkultura;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;
import sun.security.pkcs11.Secmod;

/**
 *
 * @author Ádám Roland
 */

public class AppKultura {
    
    //Globális változók
    static RandomAccessFile f;
    private static ArrayList<Tanulo> tanulok = new ArrayList<>();
    static java.util.Scanner sc = new java.util.Scanner(System.in);

    // Adatok beolvasása
    // másolás tétele
    // A szokásos módon egy sor kiolvasása és a konstruktor hívása.
    // A szeletelés a class feladata!
    static void f1(String fNev) {
        System.out.println("1. Feladat");
        System.out.println("Adatok beolvasása...");
        try {
            f = new RandomAccessFile(fNev, "r");
            String sor;
            while ((sor = f.readLine()) != null) {
                tanulok.add(new Tanulo(sor));
            }
            f.close();
        } catch (IOException e) {
            System.out.println("Hiba");
        }
        // System.out.println();
    }
    
    // Hányszor voltak a diákok moziban, és hányszor színházban összesen?
    // összegzés
    static void f2() {
        System.out.println("");
        System.out.println("2. Feladat");
        int N = tanulok.size();
        int szinhazOssz = 0;
        int moziOssz = 0;
        for (int i = 0; i < N; i++) {
            szinhazOssz += tanulok.get(i).getSzinhaz();
            moziOssz += tanulok.get(i).getMozi();
        }
        System.out.println("\tSzinhaz: " + szinhazOssz);
        System.out.println("\tMozi: " + moziOssz);

    }
    
    // Ki olvasta a legtöbb oldalt a hónapban?
    // maximum kiválasztás
    // Végig a listán mindenkinél az getOldal() metódussal kell a maximumot keresni, és ha nagyobb, akkor a maxIndexet menteni
    static void f3() {
        System.out.println("");
        System.out.println("3. Feladat");
        int N = tanulok.size();
        int maxIndex = 0;
        for (int i = 1; i < N; i++) {
            if (tanulok.get(maxIndex).getOldal() < tanulok.get(i).getOldal()) {
                maxIndex = i;
            }
        }
        System.out.println("\tTanulo neve: " + tanulok.get(maxIndex).getNev());
        System.out.println("\tOldalak száma: " + tanulok.get(maxIndex).getOldal());
    }
    
    // Az A vagy B osztályokba járnak többen?
    // megszámlálás
    // Végig a listán mindenkinél az getOsztály() metódussal kell megszámolni a létszámot, majd a két érték közül a nagyobbat kiírni!
    static void f4() {
        System.out.println("");
        System.out.println("4. Feladat");
        int N = tanulok.size();
        int Aoszt = 0;
        int Boszt = 0;
        
        for (int i = 0; i < N; i++) {
            if (tanulok.get(i).getOsztaly().equals("A")) {
                Aoszt = Aoszt+1;
            } else {
                Boszt = Boszt+1;
            }
        }
        System.out.println("\tA: " + Aoszt);
        System.out.println("\tb: " + Boszt);
        if (Aoszt > Boszt) {
            System.out.println("\taz A létszáma nagyobb");
        } else {
            System.out.println("\taz B létszáma nagyobb");
        }
        
    }
    
    // Az „A” osztályokba járók átlagosan hányszor voltak moziban, kéttizedes pontossággal.
    // összegzés, átlagszámítás
    // Végig a listán mindenkinél az getOsztály() metódussal kell megszámolni az „A”-s tanulók létszámát, közben a getMozi()-kat összegezni.
    // Ki → getMozi()/getOsztály() két tizedessel!
    static void f5() {
        System.out.println("");
        System.out.println("5. Feladat");
        int N = tanulok.size();
        double Aoszt = 0;
        int db = 0;
        
        for (int i = 0; i < N; i++) {
            if (tanulok.get(i).getOsztaly().equals("A")) {
                Aoszt = Aoszt + tanulok.get(i).getMozi();
                db++;
            }
        }
        System.out.println(String.format("%s%5.2f","\tAz A átlagos mozi látogatása: ", Aoszt/db ));
            
    }
    
    // Melyik évfolyamba és hányan járnak a legtöbben?
    // megszámlálás tömbbe, maximum kiválasztás
    // új létszám[4] :egészszám
    // Végig a listán mindenkinél az getÉvfolyam() metódussal kell beleszámolni az tanulók létszámát a létszám tömbbe!
    // Maximum kiválasztás a létszám tömbből (maxIndex)
    // Ki → évfolyam =létszám[maxIndex+9]
    static void f6() {
        System.out.println("");
        System.out.println("6. Feladat");
        int N = tanulok.size();
        int letszam[] = {0,0,0,0};
        for (int i = 0; i < N; i++) {
            letszam[Integer.parseInt(tanulok.get(i).getEvfolyam())-9] = letszam[Integer.parseInt(tanulok.get(i).getEvfolyam())-9]+1;
        }
        System.out.println(String.format("\t%s%d%s %d%s","Maximum: ",Maximum(letszam)+9," évfolyam", letszam[Maximum(letszam)], " tanuló" ));
    }
    
    static int Maximum(int t1[]){
        int max = 0;
        int N = t1.length;
        for (int i = 0; i < N; i++) {
            if (t1[i] > t1[max]) {
                max = i;
            }
        }
        return max;
    }

    // Van-e olyan diák, aki semmilyen előadást nem látogatott a hónapban, ha van, akkor írd ki nevét, ha
    // több ilyen van, akkor mindenkiét, ha nincs, akkor „Nincs ilyen diák” felírat jelenjen meg!
    // kiválogatás kigyűjtéssel
    // Végig a listán mindenkinél az getSzínház() és getMozi() metódussal megvizsgálni az értékeket.
    // Ha getSzínház()=0 és getMozi()=0,
    // akkor: Ki → getNév()
    // Ha nem volt kiírás,
    // akkor: Ki: → „Nincs ilyen diák”
    static void f7() {
        kiir("\n 7. feladat:");
        int N = tanulok.size();int flag = 0;
        for (int i = 0; i < N; i++) {
            if ((((Tanulo)tanulok.get(i)).getMozi() == 0) && (((Tanulo)tanulok.get(i)).getSzinhaz() == 0)) {
                kiir(((Tanulo)tanulok.get(i)).getNev());
                flag++;
            }
        }
        if (flag == 0) {
            kiir("Nincs ilyen di�k");
        }
    }
    
    static void kiir(String sor) {
        String[] tmp = sor.split(";");
        for (int i = 0; i < tmp.length; i++) {
            System.out.print(String.format("\t%-12s", new Object[] { tmp[i] }));
        }
        System.out.println();
    }
    
      public static void main(String[] args) {
        f1("adatok.txt");
        f2();
        f3();
        f4();
        f5();
        f6();
        f7();
    }
}

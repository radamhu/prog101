package appfutar;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ádám Roland
 */

public class AppFutar {
    
    //Globális változók
    static RandomAccessFile f;
    private static ArrayList<Ut> utak = new ArrayList<>();
    static java.util.Scanner sc = new java.util.Scanner(System.in);

    // Adatok beolvasása
    // A szokásos módon egy sor kiolvasása és a konstruktor hívása.
    // A szeletelés a class feladata!

    static void f1(String fNev) {
        System.out.println("1. Feladat");
        System.out.println("Adatok beolvasása...");
        try {
            f = new RandomAccessFile(fNev, "r");
            String sor;
            while ((sor = f.readLine()) != null) {
                utak.add(new Ut(sor));
            }
            f.close();
        } catch (IOException e) {
            System.out.println("Hiba");
        }
        System.out.println();
    }
    // 2(): Kérjen be a felhasználótól egy tetszőleges napot és fuvarszámot.
    // Írja ki a képernyőre, ennek a fuvarnak az adatait!
    // tétel: lineáris keresés
    static void f2() {
        System.out.println("2. Feladat");
        System.out.println("Adatok beolvasása...");
        int N = utak.size();
        System.out.print("\tKérem a napot (1-7): ");
        int nap = sc.nextInt();
        System.out.print("\tKérem a fuvarszámot: ");
        int fuvar = sc.nextInt();
        int i = 0;    
        while (i < N && !(utak.get(i).getNap() == nap && utak.get(i).getFuvar() == fuvar)) {
            i++;
        }
        if (i < N) {
            System.out.println(nap + ".nap " + fuvar + ".útja: " + utak.get(i).getKm() + " km");
        } else {
            System.out.println("Nincs ilyen adat");
        }
    }
    
    // f3(): Tudjuk, hogy a futár minden héten tart legalább egy szabadnapot.
    // Írja ki a képernyőre, hogy a hét hányadik napjain nem dolgozott a futár!
    // tétel: kiválogatás tömbbe
    static void f3() {
        System.out.println("");
        System.out.println("3. feladat:");
        int[] napok = new int[8];
        int N = utak.size();
        for (int i = 0; i < N; i++) {
            int k = utak.get(i).getNap();
            napok[k]++;
        }
        for (int i = 1; i < 8; i++) {
            if (napok[i] == 0) {
                System.out.println("az " + i + ". napon nem dolgozott");
            }
        }
    }
    
    // 4(): Írja ki a képernyőre, hogy a hét melyik napján volt a legtöbb fuvar! Amennyiben több nap is azonos,
    // maximális számú fuvar volt, elegendő ezek egyikét kiírnia.
    // tétel: kiválogatás tömbbe, max kiválasztás
    static void f4() {
        System.out.println("");
        System.out.println("4. feladat:");
        int[] napok = new int[8];
        int N = utak.size();
        for (int i = 0; i < N; i++) {
            int k = utak.get(i).getNap();
            napok[k]++;
        }
        int maxIndex = 0;
        for (int i = 1; i < 8; i++) {
            if (napok[i] > napok[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println(maxIndex + ". napon " + napok[maxIndex] + " fuvar volt");
    }

    // f5(): Számítsa ki és írja a km.txt állományba, hogy az egyes napokon hány kilométert kellett tekerni!
    // tétel: összegzés tömbbe
    static void f5(String f_neve) {
        kiir("\n 5. feladat:");
        int[] napok = new int[8];
        int N = utak.size();
        for (int i = 0; i < N; i++) {
            int index = utak.get(i).getNap();
            napok[index] = napok[index] + utak.get(i).getKm();
        }
        File f1 = new File(f_neve);
        if (f1.exists()) {
            f1.delete();
        }
        try {
            f = new RandomAccessFile(f_neve, "rw");
            for (int i = 1; i < 8; i++) {
                f.writeBytes(i + ". nap: " + napok[i] + " km" + "\n");
            }
            f.close();
        } catch (IOException e) {
            System.err.println("Nem j��tt l��tre a f��jl!");
        }
        kiir("a " + f_neve + " f��jl ki��r��sa ......" + " k��sz!");
    }

    // f6(): A futár az egyes fuvarokra az út hosszától függően sávosan kap fizetést az alábbi szerint:
    // Kérjen be a felhasználótól egy tetszőleges napot és fuvarszámot, és határozza meg, hogy mennyi Ft jár érte!
    // tétel: lineáris keresés
    static void f6() {
        kiir("\n 6. feladat:");
        int N = utak.size();
        System.out.print("\tK��rem a napot (1-7): ");
        int nap = sc.nextInt();
        System.out.print("\tK��rem a fuvarsz��mot: ");
        int fuvar = sc.nextInt();
        int i = 0;
        while (i < N && !(utak.get(i).getNap() == nap && utak.get(i).getFuvar() == fuvar)) {
            i++;
        }
        if (i < N) {
            kiir(nap + ".nap " + fuvar + ".��tja: " + utak.get(i).getFt() + " Ft");
        } else {
            kiir("Nincs ilyen adat");
        }
    }
    
    // Határozza meg, és írja ki a képernyőre, hogy a futár mekkora összeget kap a heti munkájáért!
    // tétel: összegzés
    static void f7() {
        kiir("\n 7. feladat:");
        int N = utak.size();
        int sz = 0;
        for (int i = 0; i < N; i++) {
            sz=sz+utak.get(i).getFt();              
        }        
        kiir("a heti b��r: "+sz+ " Ft");

    }

    // Mekkora összeget kapott a pénteki utolsó fuvarért?
    // tétel: megszámlálás, kiválasztás
    static void f8() {
        kiir("\n 8. feladat:");
        int N = utak.size();
        int db = 0;
        for (int i = 0; i < N; i++) {
            if (utak.get(i).getNap() == 5) {
                db++;
            }
        }
        int i = 0;
        while ( !(utak.get(i).getNap() == 5 && utak.get(i).getFuvar() == db)) {
            i++;
        }
        kiir("az 5.nap utols�� ("+db+".) ��tja: " + utak.get(i).getFt() + " Ft");

    }

    static void kiir(String sor) {
        String tmp[] = sor.split(";");
        for (int i = 0; i < tmp.length; i++) {
            System.out.print(String.format("\t%-12s", tmp[i]));
        }
        System.out.println();
    }

    static void DOSablak() {
        System.out.print("\n\n<<Kil��p��shez: ENTER>>");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
    
    public static void main(String[] args) {
        f1("adatok.txt");
        f2();
        f3();
        f4();
    }
}

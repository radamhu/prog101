package appszem;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class AppSzem {
    
    static RandomAccessFile f;
    static ArrayList<Szemely> szemelyek = new ArrayList<>();
    // static ArrayList<String[]> nok = new ArrayList<String[]>();
    static ArrayList<String> nok = new ArrayList<String>();
    
    static void adatokBe(String f_neve) {
        System.out.println(" 1. Az adatok beolvasás a(z) " + f_neve + " fájlból");
        try {
            f = new RandomAccessFile(f_neve, "r");
            String sor = f.readLine(); // innentől a konstruktornak a feladata feldolgzoni az adatot
            while (sor != null) { // ha nem üres, átadom a konstruktornak                
                szemelyek.add(new Szemely(sor)); // hozzáadja a szakik fürthöz
                sor = f.readLine();
            }
            f.close();
        } catch (IOException e) {
            System.err.println("Baj van babám");
        }
        System.out.println("    az adatok.txt beolvasás ... kész!");
        System.out.println();
    }
    
    static void noiNevsor(String f_neve) {
        int N = szemelyek.size();
        for (int i = 1; i < N; i++) {
            if (szemelyek.get(i).getNeme() == 'n') {
                nok.add(szemelyek.get(i).getNev());
            }
        }
        rendezes();
        adatokKi(f_neve);
    }

    static void csere(int i, int j) {
        String tmp = (String)nok.get(i);
        nok.set(i, nok.get(j));
        nok.set(j, tmp);
    }

    static void rendezes() {    
        System.out.println("\n2. Rendez�s n�vsorba");
        int N = nok.size();
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                int x = ((String)nok.get(j)).compareTo((String)nok.get(minIndex));
                if (x < 0) {
                    minIndex = j;
                }
            }
        csere(i, minIndex);
        } 
    }  

    static void nev_szuldatom() {      
        System.out.println("\n3. n�v, sz�let�sid�tum:");
        int N = szemelyek.size();
        for (int i = 0; i < N; i++) {
            System.out.println(((Szemely)szemelyek.get(i)).getKiiras());
        }       
    }
    
            
    static void adatokKi (String f_neve) {
        File f1 = new File(f_neve);
        if (f1.exists()) {
            f1.delete();
        }
        try {
            f = new RandomAccessFile(f_neve, "rw");
            int N = nok.size();
            for (int i = 0; i < N; i++) {
                f.writeBytes(nok.get(i) + "\n");
            }
            f.close();
        } catch (Exception e) {
            System.out.println(" Baj van!");
        }
        System.out.println(f_neve + " írása ...... " + " kész!");
    }
    
    public static void main(String[] args) {
        adatokBe("szemszam.txt");
        noiNevsor("nokAZ.txt");
        nev_szuldatom();
    }
}

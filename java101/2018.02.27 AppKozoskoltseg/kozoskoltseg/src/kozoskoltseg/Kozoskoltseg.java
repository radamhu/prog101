package kozoskoltseg;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Kozoskoltseg {
    
    static RandomAccessFile f;
    static ArrayList<Lako> hazlakoi = new ArrayList<>();
    
    static void adatokBe(String f_neve) {
        System.out.println(" 1. Az adatok beolvasás a(z) " + f_neve + " fájlból");
        try {
            f = new RandomAccessFile(f_neve, "r");
            String sor = f.readLine(); // innentől a konstruktornak a feladata feldolgzoni az adatot
            while (sor != null) { // ha nem üres, átadom a konstruktornak                
                hazlakoi.add(new Lako(sor)); // hozzáadja a szakik fürthöz
                sor = f.readLine();
            }
            f.close();
        } catch (IOException e) {
            System.err.println("Baj van babám");
        }
        System.out.println("    az adatok.txt beolvasás ... kész!");
        System.out.println();
    }
    
    static void rendezes(){
        System.out.println("\n2. Rendezés névsorba");
        int N = hazlakoi.size();
        for (int i = 0; i < N ; i++){
            int min = i;
            for (int j = i +1 ; j < N ; j++){
                int x = hazlakoi.get(j).getNev().compareTo(hazlakoi.get(min).getNev());
                if (x < 0) {
                    min = j;
                }
            }
            csere(i, min);
        }
    }
    
    static void csere (int i,int j){
        Lako tmp = hazlakoi.get(i);
        hazlakoi.set(i, hazlakoi.get(j));
        hazlakoi.set(j, tmp);
    }
    
    static void adatokKi (String f_neve, String s) {
        File f1 = new File(f_neve);
        if (f1.exists()) {
            f1.delete();
        }
        try {
            f = new RandomAccessFile(f_neve, "rw");
            f.writeBytes(s);
            f.close();
        } catch (Exception e) {
            System.out.println(" Baj van!");
        }
        System.out.println(f_neve + " írása ...... " + " kész!");
    }
    
    static void szamla () {
        System.out.println("\nA számlák:");
        int N = hazlakoi.size();
        for (int i = 0; i < N; i++) {
            String nev = hazlakoi.get(i).getNev();
            String s = hazlakoi.get(i).getSzamla();
            System.out.print("\n"+nev + "\n" + s);
            adatokKi(nev+".txt",s);
        }
    }
    
    public static void main(String[] args) {
        adatokBe("koltsegek.txt");
        rendezes();
        szamla();
    }
}

package apptanc;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class AppTanc {
    
    static RandomAccessFile f;
    static ArrayList<Elem> lista = new ArrayList<>();
    static java.util.Scanner sc = new java.util.Scanner(System.in);
    
    static void adatokBe(String f_neve) {
        System.out.println("\n1. Az adatok beolvasás a(z) " + f_neve + " fájlból");
        try {
            f = new RandomAccessFile(f_neve, "r");
            String tanc, lany, fiu; 
            //  előltesztelő ciklussal fájl beolvasása
            while ((tanc = f.readLine()) != null) { 
                lany = f.readLine();
                fiu = f.readLine();
                lista.add(new Elem(tanc, lany, fiu)); 
            }
            f.close();
        } catch (IOException e) {
            System.err.println("Baj van babám");
        }
        System. out.println("    az adatok.txt beolvasás ... kész!");
        System.out.println();
    }
    
    // melyik volt az elsőként és melyik az utolsóként bemutatott tánc neve!
    // elem kiírás (hozzáférés a lista i. eleméhez)
    static void f2() {
        System.out.println("\n2. melyik volt az elsőként és melyik az utolsóként bemutatott tánc neve!");
        int N = lista.size();
        System.out.println("    Az első tánc: " + lista.get(0).getTanc());
        System.out.println("    Az utolsó tánc: " + lista.get(N-1).getTanc());
    }
    
    // Hány pár és kik mutatták be a sambát?
    // kiválogatás kigyűjtéssel, megszámlálás tétele   
    static void  f3() {
        System.out.println("\n3. Hány pár és kik mutatták be a sambát?");
        int N = lista.size();
        int db = 0;
        for (int i = 0; i < N; i++) {
            if (lista.get(i).getTanc().equals("samba")) {
                System.out.println("    " + lista.get(i).getLany() + " és " + lista.get(i).getFiu());
                db++;
            }
        }
        System.out.println("");
        System.out.println("    Összesen " + db + " pár táncolt sambát");
    }
    
    // Írassa ki a vilma.txt állományba, hogy Vilma mely táncokban szerepelt!
    // kiválogatás fájlba tétele
    static void adatokKi(String f_neve) {
        System.out.println("\n4.Írassa ki a vilma.txt állományba, hogy Vilma mely táncokban szerepelt!");
        File f1 = new File(f_neve);
        if (f1.exists()) {
            f1.delete();
        }
        try {
            f = new RandomAccessFile(f_neve, "rw");
            int N = lista.size();
            for (int i = 0; i < N; i++) {
                if (lista.get(i).getLany().equals("Vilma")) {
                    f.writeBytes(lista.get(i).getTanc() + "\n");
                }
            }
            f.close();
        } catch (Exception e) {
            System.out.println(" Baj van!");
        }
        System.out.println("    " + f_neve + " írása ...... " + " kész!");
    }
    
    // Kérje be egy tánc nevét, hogy az adott táncot Vilma kivel mutatta be!
    // keresés tétele
    static void f5() {
        System.out.println("\n5. Kérje be egy tánc nevét, hogy az adott táncot Vilma kivel mutatta be");
        int N = lista.size();
        System.out.print("\tKérem a tánc nevét (pl.: samba) ");
        String tanc = sc.nextLine();
        int i = 0;
        while (i < N  && !(lista.get(i).getTanc().equals(tanc)) && lista.get(i).getLany().equals("Vilma")) {            
            i++;
        }
        if (i < N) {
            System.out.println("\tA " + tanc + " bemutatóján Vilma párja " + lista.get(i).getFiu() + " volt.");
        } else {
            System.out.println("Vilma nem táncolt" + tanc + "-t.");
        }
    }

    public static void main(String[] args) {
        adatokBe("adatok.txt");
        f2();
        f3();
        adatokKi("vilma.txt");
        f5();
    }
}

package helsinki2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.SignStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Helsinki2017 {
    
    static ArrayList<Versenyzo> indulok = new ArrayList<>();
    static HashMap<String,Integer> orszag_db = new HashMap<>();
    
    // Egy sor beolvasása után először meg kell keresni a versenyzőt a listában a neve alapján. 
    static int keres(String nev) {
        for (int i = 0; i < indulok.size(); i++) {
            if (indulok.get(i).getNev().equals(nev)) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) throws IOException {
        
        // beolvasás
        Scanner rbe = new Scanner(new File("rovidprogram.csv"));
        rbe.nextLine();
        while (rbe.hasNextLine()) {
            indulok.add(new Versenyzo(rbe.nextLine()));
        }
        rbe.close();
        
        // Ezután be kell olvasni a döntő adatait is, és ezekkel kiegészíteni a versenyzők adatait.
        Scanner dbe = new Scanner(new File("donto.csv"));
        dbe.nextLine();
        while (dbe.hasNextLine()) {            
            String[] s = dbe.nextLine().split(";");
            int i = keres(s[0]);
            if (i>-1) {
                indulok.get(i).hozzaad(s[2], s[3], s[4]);
            }
        }
        // Indulók száma
        System.out.println("A rövid programban "+indulok.size()+" induló volt");
        
        // a magyar versenyző bejutott-e a döntőbe. 
        int index = 0;
        while (!indulok.get(index).getOrszag().equals("HUN")) {            
            index++;
        }
        if (indulok.get(index).isBejutott()) {
            System.out.println("A magyar versenyző bejutott a körbe");
        } else {
            System.out.println("A magyar versenyző nem jutott be a körbe");
        }
        
        // megadja egy versenyző összpontszámát. 
        // Eközben arra kell figyelni, hogy a hibapontokat le kell vonni az összegből
        Scanner bill = new Scanner(System.in);
        System.out.print("Kérem a versenyző nevét: ");
        index = keres(bill.nextLine());
        if (index > -1 ) {
            System.out.println("A versenyző összpontszáma: " + indulok.get(index).Osszpontszam());
        } else {
            System.out.println("Ilyen nevű induló nem volt.");
        }
        
        // országonként hány jutott tovább?
        for (int i = 0; i < indulok.size(); i++) {
            if (indulok.get(i).isBejutott()) {
                String orszag = indulok.get(i).getOrszag();
                Integer db = orszag_db.get(orszag);
                if (db == null) {
                    db = 1;
                } else {
                    db++;
                }
            }
        }
        // ez egy for each ciklus
        for (String s : orszag_db.keySet()) {
            if (orszag_db.get(s) > 1) {
                System.out.println(s + ": " + orszag_db.get(s) + " versenyző");
            }
        }
        
        // vegeredmeny kiirasa
        Collections.sort(indulok, (t1, t2) -> Double.compare(t2.Osszpontszam(), t1.Osszpontszam()));
        
        PrintWriter ki = new PrintWriter("vegeredmeny.csv");
        for (int i = 0; i < indulok.size(); i++) {
            ki.println((i+1)+";"+indulok.get(i).getEredmeny());
        }
        ki.close();
    }
}

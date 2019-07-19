package kutyak;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author tothj
 */
public class Kutyak {

    static ArrayList<Nev> nevek = new ArrayList<>();
    static ArrayList<Fajta> fajtak = new ArrayList<>();
    static ArrayList<Kutya> kutyak = new ArrayList<>();
    static HashMap<String, Integer> hany = new HashMap<>();
    static HashMap<String, Integer> mikor = new HashMap<>();
    
    public static void main(String[] args) {
        // 2. feladat
        int ndb = 0;
        try (Scanner be = new Scanner(new File("KutyaNevek.csv"))) {
            be.nextLine();
            while (be.hasNextLine()) {
                String[] s = be.nextLine().split(";");
                nevek.add(new Nev(s[1]));
                ndb++;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // 3. feladat
        System.out.println("3. feladat: Kutyanevek száma: " + ndb);
        // 4. feladat
        try (Scanner be = new Scanner(new File("KutyaFajtak.csv"))) {
            be.nextLine();
            while (be.hasNextLine()) {
                String[] s = be.nextLine().split(";");
                if (s.length == 3)
                    fajtak.add(new Fajta(s[1],s[2]));
                else
                    fajtak.add(new Fajta(s[1],""));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // 5. feladat
        try (Scanner be = new Scanner(new File("Kutyak.csv"))) {
            be.nextLine();
            while (be.hasNextLine()) {
                String[] s = be.nextLine().split(";");
                Kutya k = new Kutya(Integer.parseInt(s[1]),
                              Integer.parseInt(s[2]),
                              Integer.parseInt(s[3]),
                              s[4]);
                kutyak.add(k);
                nevek.get(k.getNevid()-1).novelDb();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // 6. feladat
        int kdb = 0, kev = 0;
        for (Kutya k : kutyak) {
            kev += k.getEletkor();
            kdb++;
        }
        System.out.println("6. feladat: Kutyák átlag életkora: " 
                + Math.round((double)kev/kdb*100)/100.0);
        // 7. feladat
        Kutya legidosebb = null;
        int ev = 0;
        for (Kutya k : kutyak) {
            if (k.getEletkor() > ev) {
                legidosebb = k;
                ev = k.getEletkor();
            }
        }
        System.out.println("7. feladat: Legidősebb kutya neve és fajtája: "
                           + nevek.get(legidosebb.getNevid()-1).getNev() + ", "
                           + fajtak.get(legidosebb.getFajtaid()-1).getFajta());
        // 8. feladat
        for (Kutya k : kutyak) {
            if (k.getDatum().equals("2018.01.10")) {
                String fajta = fajtak.get(k.getFajtaid()-1).getFajta();
                Integer db = hany.get(fajta);
                if (db == null) {
                    db = 1;
                } else {
                    db++;
                }
                hany.put(fajta, db);
            }
        }
        System.out.println("8. feladat: Január 10-én vizsgált kutyafajták:");
        for (String fajta : hany.keySet()) {
            System.out.println("\t" + fajta + " " + hany.get(fajta) + " kutya");
        }
        // 9. feladat
        for (Kutya k : kutyak) {
            String datum = k.getDatum();
            Integer db = mikor.get(datum);
            if (db == null) {
                db = 1;
            } else {
                db++;
            }
            mikor.put(datum, db);
        }
        int max = 0;
        String datum = "";
        for (String d : mikor.keySet()) {
            if (mikor.get(d) > max) {
                datum = d;
                max = mikor.get(d);
            }
        }
        System.out.println("9. feladat: Legjobban leterhelt nap: "
                + datum + ": " + max + " kutya");
        // 10. feladat
        System.out.println("10. feladat: névstatisztika.txt");
        ArrayList<Nev> masolat = new ArrayList<>(nevek);
        Collections.sort(masolat, (a,b) -> Integer.compare(b.getDb(), a.getDb()));
        
        try (PrintWriter ki = new PrintWriter("névstatisztika.txt")) {
            for (Nev n : masolat) {
                if (n.getDb() == 0)
                    break;
                ki.println(n.getNev() + ":" + n.getDb());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

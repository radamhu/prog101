package nobel;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author tothj
 */
public class Nobel {

    static ArrayList<Dij> lista = new ArrayList<>();
    static HashMap<String, Integer> hanyszor = new HashMap<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 2. feladat
        try (Scanner be = new Scanner(new File("nobel.csv"))) {
            be.nextLine();
            while (be.hasNextLine()) {
                String[] s = be.nextLine().split(";");
                Dij d;
                if (s.length == 4) {
                    d = new Dij(Integer.parseInt(s[0]), s[1], s[2], s[3]);
                } else {
                    d = new Dij(Integer.parseInt(s[0]), s[1], s[2], "");
                }
                lista.add(d);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // 3. feladat
        System.out.print("3. feladat: ");
        for (int i = 0; i < lista.size(); i++) {
            Dij d = lista.get(i);
            if (d.getKeresztnev().equals("Arthur B.")
                    && d.getVezeteknev().equals("McDonald")) {
                System.out.println(d.getTipus());
                break;
            }
        }
        // 4. feladat
        System.out.print("4. feladat: ");
        for (int i = 0; i < lista.size(); i++) {
            Dij d = lista.get(i);
            if (d.getEvszam() == 2017
                    && d.getTipus().equals("irodalmi")) {
                System.out.println(d.getKeresztnev()
                           + " " + d.getVezeteknev());
                break;
            }
        }
        // 5. feladat
        System.out.println("5. feladat:");
        for (int i = 0; i < lista.size(); i++) {
            Dij d = lista.get(i);
            if (d.getEvszam() < 1990) {
                break;
            }
            if (d.getVezeteknev().isEmpty()
                    && d.getTipus().equals("béke")) {
                System.out.println("\t" + d.getEvszam()
                                 + ": " + d.getKeresztnev());
            }
        }
        // 6. feladat
        System.out.println("6. feladat:");
        for (int i = 0; i < lista.size(); i++) {
            Dij d = lista.get(i);
            if (d.getVezeteknev().contains("Curie")) {
                System.out.println("\t" + d.getEvszam()
                                 + ": " + d.getKeresztnev()
                                  + " " + d.getVezeteknev()
                                  + "(" + d.getTipus() + ")");
            }
        }
        // 7. feladat
        System.out.println("7. feladat: ");
        for (int i = 0; i < lista.size(); i++) {
            String tipus = lista.get(i).getTipus();
            Integer db = hanyszor.get(tipus);
            if (db == null) {
                db = 1;
            } else {
                db++;
            }
            hanyszor.put(tipus, db);
        }
        for (String tipus : hanyszor.keySet()) {
            System.out.printf("\t%-25s%3d db\n", tipus, hanyszor.get(tipus));
        }
        // 8. feladat
        System.out.println("8. feladat: orvosi.txt");
        try (PrintWriter ki = new PrintWriter("orvosi.txt")) {
            for (int i = lista.size()-1; i >=0 ; i--) {
                Dij d = lista.get(i);
                if (d.getTipus().equals("orvosi"))
                    ki.println(d.getEvszam() + ":" 
                             + d.getKeresztnev() + " " + d.getVezeteknev());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

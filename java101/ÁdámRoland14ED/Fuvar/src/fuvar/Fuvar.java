/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuvar;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author t1
 */
public class Fuvar {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Taxis> fuvarok = new ArrayList<>();
            
    public static void main(String[] args) {
        // TODO code application logic here
        
        // 2. feladat        
        int ndb = 0;
        try (Scanner be = new Scanner(new File("fuvar.csv"))) {
            be.nextLine();
            while (be.hasNextLine()) {
                String[] s = be.nextLine().split(";");
                Taxis t;
                t = new Taxis(
                        Integer.parseInt(s[0]), 
                        s[1], 
                        Integer.parseInt(s[2]), 
                        Double.parseDouble(s[3].replaceFirst(",", ".")), 
                        Double.parseDouble(s[4].replaceFirst(",", ".")),
                        Double.parseDouble(s[5].replaceFirst(",", ".")),
                        s[6]);
                fuvarok.add(t);
                ndb++;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        // 3. feladat
        System.out.println("3. feladat: " + ndb + " fuvar");
        
        // 4. feladat
        System.out.print("4. feladat: ");
        double bev = 0;
        int db = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            if (fuvarok.get(i).getTaxi_id()==6185) {
                db++;
                bev+=fuvarok.get(i).getBevetel();
            }
        }
        System.out.printf(String.format("%d%s%2.2f%s%n",db, " fuvar alatt: ", bev, "$"));
        
        // 5. feladat
        System.out.println("5. feladat:");
        Collections.sort(fuvarok, (a, b) -> b.getFizetes_modja().compareTo(a.getFizetes_modja()));
        int szam=1;
        for (int i = 1; i < fuvarok.size(); i++) {
            if (fuvarok.get(i).getFizetes_modja().equals(fuvarok.get(i-1).getFizetes_modja())) {
                szam++;
            } else {
                System.out.println(String.format("%d%s%s ", szam, fuvarok.get(i-1).getFizetes_modja(), " fuvar"));
            }
        }
        
        // 6. feladat
        System.out.print("6. feladat: ");
        double xy = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            xy += fuvarok.get(i).getTavolsag();
        }
        xy = xy*1.6;
        System.out.println(xy + "km");
        
        // 7. feladat
        System.out.println("7. feladat: Leghosszabb fuvar: ");
        int length = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            if (fuvarok.get(i).getIdotartam() > fuvarok.get(length).getIdotartam()) {
                length = i;
            }
        }
        System.out.println("Fuvar hossza: " + fuvarok.get(length).getIdotartam() + " másodperc");
        System.out.println("Taxi azonosítója: " + fuvarok.get(length).getTaxi_id());
        System.out.println("Megtett távolság: " + fuvarok.get(length).getTavolsag() + " km");
        System.out.println("Viteldjí: " + fuvarok.get(length).getViteldíj() + "$");
        
        // 8 .feladat
        System.out.println("8. feladat: hibak.txt");
        try (PrintWriter ki = new PrintWriter("hibak.txt")) {
            for (int i = fuvarok.size()-1; i >=0 ; i--) {
                Taxis t = fuvarok.get(i);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}

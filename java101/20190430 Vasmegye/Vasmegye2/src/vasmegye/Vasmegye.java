package vasmegye;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Vasmegye {

    static ArrayList<Ember> emberek = new ArrayList<>();
    static ArrayList<Ember> joemberek = new ArrayList<>();

    static void kiir() {
        for (int i = 0; i < emberek.size(); i++) {
            System.out.println(emberek.get(i).toString());
        }
    }

    static void feladat() {
        System.out.println("1. feladat - kész");
        System.out.print("2. feladat adatbeolvasás");
        try (Scanner be = new Scanner(new File("vas.txt"))) {
            while (be.hasNextLine()) {
                String s = be.nextLine();
                emberek.add(new Ember(
                        Integer.parseInt(s.substring(0, 1)),
                        Integer.parseInt(s.substring(2, 4)),
                        Integer.parseInt(s.substring(4, 6)),
                        Integer.parseInt(s.substring(6, 8)),
                        Integer.parseInt(s.substring(9, 12)),
                        Integer.parseInt(s.substring(12, 13))));
            }
        } catch (IOException be) {
            System.out.println("Nem tudtam beolvasni");
        }
        System.out.println(" - adatok beolvasva.");
        System.out.println("4. feladat ellenőrzés.");
        for (int i = 0; i < emberek.size(); i++) {
            if (CdvEll(emberek.get(i).toString()) == false) {
                System.out.println("   Hibás a " + emberek.get(i).getSzemszam() + " azonosító!");
            } else {
                joemberek.add(new Ember(emberek.get(i).getM(), emberek.get(i).getÉv(), emberek.get(i).getHo(), emberek.get(i).getNap(), emberek.get(i).getS(), emberek.get(i).getK()));
            }
        }
        System.out.println("   Hibás számok törölve!");
        System.out.println("6. feladat ");
        int fiuk = 0;
        for (int i = 0; i < joemberek.size(); i++) {
            if (joemberek.get(i).getM() == 1 | joemberek.get(i).getM() == 3) {
                fiuk++;
            }
        }
        System.out.println("   Fiúk száma: " + fiuk);
        System.out.println("7. feladat ");
        Collections.sort(joemberek, (Ember a, Ember b) -> a.getEvnegyjegy().compareTo(b.getEvnegyjegy()));
        System.out.println(String.format("%s %s - %s", "   Vizsgált időszak:", joemberek.get(0).getEvnegyjegy(), joemberek.get(joemberek.size() - 1).getEvnegyjegy()));
        System.out.println("8. feladat ");
        int v = 0;
        while (v < joemberek.size()) {
            if (Integer.parseInt(joemberek.get(v).getEvnegyjegy())%4 == 0 &  joemberek.get(v).getHoNap().equals("0224")) {
                System.out.println("   Született gyermek szökőnapon!");
                break;
            }
            v++;
        }
        if (v == joemberek.size()) {
            System.out.println("   Nem született gyermek szökőnapon!");
        }
        System.out.println("9. feladat statisztika");
        Collections.sort(joemberek, (Ember a, Ember b) -> a.getEvnegyjegy().compareTo(b.getEvnegyjegy()));
        int evszul = 1;
        for (int i = 1; i < joemberek.size(); i++) {
            //       System.out.println(joemberek.get(i).getEvHoNap());
            if (joemberek.get(i).getEvnegyjegy().equals(joemberek.get(i - 1).getEvnegyjegy())) {
                evszul++;
            } else {
                System.out.println(String.format("   %4s - %d%s", joemberek.get(i - 1).getEvnegyjegy(), evszul, " fő."));
                evszul = 1;
            }
        }
        System.out.println(String.format("   %s - %d%s", joemberek.get(joemberek.size() - 1).getEvnegyjegy(), evszul, " fő."));
    }

    static Boolean CdvEll(String s) {
        int osszeg = 0;
        for (int v = 0; v < 10; v++) {
            osszeg = osszeg + Integer.parseInt(s.substring(v, v + 1)) * (10 - v);
        }
        if (osszeg % 11 == Integer.parseInt(s.substring(10, 11))) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        feladat();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kektura;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author adamr
 */
public class Kektura {

    /**
     * A főprogramban létrehozzuk a listát, 
     * beolvassuk az adatokat, 
     * kiírjuk a szakaszok számát, 
     * majd kiszámítjuk a teljes hosszt:
     */
    static ArrayList<Szakasz> szakaszok = new  ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        // beolvasas
        Scanner be = new Scanner(new File("kektura.csv"));
        int magassag = Integer.parseInt(be.nextLine());
        while (be.hasNextLine()) {            
            szakaszok.add(new Szakasz(be.nextLine()));
        }
        be.close();
        
        // szakaszok száma
        System.out.println("Szakaszok száma: " + szakaszok.size());
        
        // teljes hossza
        double hossz = 0;
        for (Szakasz sz : szakaszok) {
            hossz += sz.getTav();
        }
        System.out.printf("Túra teljes hossza: %.3f km\n", hossz);
        
        // Leghosszabb szakaszok
        // Készítünk egy másolatot a listáról, mert később az eredeti sorrendben is szükségünk lesz rá.
        // A másolatot csökkenő sorrendbe rendezzük.
        // Kiíratjuk a csökkenő sorrendbe rendezett lista első három elemét.
        // Lambda kifjezések
        ArrayList<Szakasz> masolat = new ArrayList<>(szakaszok);
        Collections.sort(masolat, (a,b) -> a.getTav() >b.getTav() ? -1 : a.getTav()== b.getTav() ? 0 : 1);
        
        // legmagasabb vegpont
        // maximum kiváalsztás
        int vpmagassag = magassag;
        int legmagasabb = magassag;
        int hol = -1;
        for (int i = 0; i < szakaszok.size(); i++) {
            vpmagassag += szakaszok.get(i).szintvaltozas();
            if (vpmagassag > legmagasabb) {
                legmagasabb = vpmagassag;
                hol = i;
            }
        }
        System.out.println("Legmagasabb végpont: " + legmagasabb);
        System.out.println(szakaszok.get(hol).toString());
        
        // Hiányos állomásnevek
        // megszamlalas
        // Készíts a Szakasz osztályban logikai értéket visszaadó metódust hianyosNev azonosítóval, 
        // amelynek segítségével minősíteni tudod a túraszakaszok végpontjainak a nevét! 
        // Hiányos állomásneveknek minősítjük azokat a végpontneveket, amelyek pecsételőhelyek, 
        // de a „pecsetelohely” karakterlánc nem található meg a nevükben. 
        // Ebben az esetben logikai igaz értéket adjon vissza a metódus, egyébként pedig hamisat!
        // A megoldáshoz felhasználunk egy új metódust. A stringek contains() metódusa megadja, hogy a paraméterként kapott string szerepel-e abban a stringben, amelyikre meghívtuk.
        int db = 0;
        System.out.println("Hiányos állomásnevek:");
        for (Szakasz sz : masolat) {
            if (sz.hianyos()) {
                System.out.println(sz.toString());
                db++;
            }
        }
        if (db == 0) {
            System.out.println("Nincs hiányos állomásnév!");
        }
    }
}

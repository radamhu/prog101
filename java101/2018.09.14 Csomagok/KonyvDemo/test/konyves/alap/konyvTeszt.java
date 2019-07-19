/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konyves.alap;

/**
 *
 * @author t1
 */
public class konyvTeszt {
    public static void main(String[] args) {
        konyv k1 = new konyv("Ken Follet","A katedrális", 798, 3600);
        konyv k2 = new konyv("Arthur Hailey","Autóváros", 539, 930);
        System.out.println(k1.toString());
        System.out.println(k2.toString());
        System.out.println("k1 k2: " + konyv.hosszabb(k1, k2));
        System.out.println("k2 k1: " + konyv.hosszabb(k2, k1));
    }
}

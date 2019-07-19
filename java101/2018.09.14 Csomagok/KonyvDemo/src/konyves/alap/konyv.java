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
public class konyv {
    private String iro;
    private String cim;
    private int oldalszam;
    private int ar;

    public konyv(String iro, String cim, int oldalszam, int ar) {
        this.iro = iro;
        this.cim = cim;
        this.oldalszam = oldalszam;
        this.ar = ar;
    }
    
    @Override
    public String toString() {
        return iro + ", " + cim + ", " + oldalszam + ", " + ar;
    }
    
    public static int hosszabb(konyv a, konyv b) {
        return a.oldalszam - b. oldalszam;
    }
    
    
}

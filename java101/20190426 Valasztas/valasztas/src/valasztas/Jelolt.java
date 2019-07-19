/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valasztas;

/**
 *
 * @author t1
 */
public class Jelolt {
    private int kerulet;
    private int szavazat;
    private  String nev;
    private String part;

    public Jelolt(String sor) {
        String tmp[] = sor.split(" ");
        kerulet = Integer.parseInt(tmp[0]);
        szavazat = Integer.parseInt(tmp[1]);
        nev = tmp[2] + tmp[3];
        part = tmp[4];
        if (part.equals("-")) {
            part="független";
        }
    }

    public int getKerulet() {
        return kerulet;
    }

    public void setKerulet(int kerulet) {
        this.kerulet = kerulet;
    }

    public int getSzavazat() {
        return szavazat;
    }

    public void setSzavazat(int szavazat) {
        this.szavazat = szavazat;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }
    
    
}

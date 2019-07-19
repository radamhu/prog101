/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appszinkep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author adamr
 */
public class AppSzinkep {

    /**
     * @param args the command line arguments
     */
    
    static final int MERET = 50;
    static Keppont[][] kep = new Keppont[MERET + 1][MERET + 1];
    
    static void megjelenit() {
        int i, j;
        for (i = 1; i <= MERET; i++) {
            for (j = 1; j <= MERET; j++) {
                System.out.print(kep[i][j].szinjel());
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        // beolvasás
        Scanner be = new Scanner(new File("kep.txt"));
        int sor, oszlop;
        for ( sor = 1; sor <= MERET; sor++) {
            for ( oszlop = 1; oszlop <= MERET; oszlop++) {
                kep[sor][oszlop] = new Keppont(be.nextLine());
            }
        }
        be.close();
        
        megjelenit();
        
        // szerepel-e
        Scanner bill = new Scanner(System.in);
        System.out.println("Szinkod (200 96 64)");
        String kod = bill.nextLine();
        boolean van = false;
        for ( sor = 1; sor < MERET; sor++) {
            for ( oszlop = 1; oszlop < MERET; oszlop++) {
                if (kep[sor][oszlop].getSzin().equals(kod)) {
                    van = true;
                    break;
                }
            }
            if (van) {
                break;
            }
        }
        if (van) {
            System.out.println("Van ilyen szinű pont");
        }
        else {
            System.out.println("Nincs ilyen szinu pont");
        }
        
        // 35/8 szin hányszor szerepel
        kod = kep[35][8].getSzin();
        int dbs = 0;
        for (oszlop = 1;  oszlop <= MERET; oszlop++) {
            if (kep[35][oszlop].getSzin().equals(kod)) {
                dbs++;
            }
        }
        int dbo = 0;
        for (sor = 1; sor <= MERET; sor++) {
            if (kep[sor][8].getSzin().equals(kod)) {
                dbo++;
            }
        }
        System.out.println(kod + " sorban: " + dbs+" oszlopban: "+dbo);
        
        // Melyik szin fordul elő legtöbbször
        // megszámolom és maximum
        int vdb = 0;
        int zdb = 0;
        int kdb = 0;
        for ( sor = 1; sor <= MERET; sor++) {
            for (oszlop = 1; oszlop <= MERET; oszlop++) {
                kod = kep[sor][oszlop].getSzin();
                if (kod.equals("255 0 0")) {
                    vdb++;
                } else if (kod.equals("0 255 0")) {
                    zdb++;
                } else if (kod.equals("0 0 255")) {
                    kdb++;
                }
            }
        }
        System.out.println("A legtöbbször előforduló szín: ");
        int max = vdb;
        String szin = "vörös";
        if (zdb > max) {
            max = zdb;
            szin = "zöld";
        }
        if (kdb > max) {
            szin = "kek";
        }
        System.out.println(szin + " " + max);
        
        // Keret készítése
        for ( sor = 1; sor <= MERET; sor++) {
            for ( oszlop = 1; oszlop <= MERET; oszlop++) {
                if (sor <= 3 || sor >= 48 || oszlop <= 3 || oszlop >= 48) {
                    kep[sor][oszlop].setSzin("0 0 0");
                }
            }
        }
        megjelenit();
        
        // fájlba írás
        PrintWriter ki = new  PrintWriter("keretes.txt");
        for (sor = 1; sor <= MERET; sor++) {
            for ( oszlop = 1; oszlop <= MERET; oszlop++) {
                ki.println(kep[sor][oszlop].getSzin());
            }
        }
        ki.close();
    }
}

package appszinhaz;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author adamr
 */
public class AppSzinhaz {
    static final int MERET = 15;
    static Szeksor[] nezoter = new Szeksor[MERET];
    
    
    public static void main(String[] args) throws IOException{
        // Adatok beolvasása
        Scanner be1 = new Scanner(new File("foglaltsag.txt"));
        Scanner be2 = new Scanner(new File("kategoria.txt"));
        for (int i = 0; i < MERET; i++) {
            nezoter[i] = new Szeksor(be1.nextLine(), be2.nextLine());
        }
        be1.close();
        be2.close();
        
        // Foglaltság lekérdezése
        Scanner bill = new Scanner(System.in);
        System.out.print("Sor és székszám: ");
        int sor = bill.nextInt() - 1;
        int szek = bill.nextInt() - 1;
        if (nezoter[sor].szabad(szek)) {
            System.out.println("szabad");
        } else {
            System.out.println("foglalt");
        }
        
        // eladott jegyek száma
        int db = 0;
        for (Szeksor sz : nezoter) {
            db += sz.eladott();
        }
        System.out.println("Eladott jegyek száma: " + db);
        
        // eladások kategóriánként
        int[] kat = {0,0,0,0,0};
        for (Szeksor sz : nezoter) {
            sz.arkategoria(kat);
        }
        
        // legtobb eladás
        int legtobb = kat[0];
        int hol = 0;
        for (int i = 0; i < 5; i++) {
            if (kat[i] > legtobb) {
                legtobb = kat[i];
                hol = i;
            }
        }
        System.out.println("A legtöbb eladás a " + (hol+1) + " kategóriában volt.");
    }
}

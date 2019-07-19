package vetelkedo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class Vetelkedo {
    
    static Integer[] pontok = new Integer[10];
    static int db = 0;
    
    public static void main(String[] args) {
        // beolvasás
        Scanner bill = new Scanner(System.in);
        System.out.print("Pontok: ");
        while (bill.hasNextInt() && db < pontok.length) {            
            pontok[db++] = bill.nextInt();
        }
        // tömb másolása
        Integer[] masolat = Arrays.copyOf(pontok, db);
        // tömb rendezése
        Arrays.sort(masolat, Collections.reverseOrder());
        // pontszám meghatározása
        int osszeg = 0;
        for (int i = 0; i < masolat.length -1; i++) {
            osszeg += masolat[i];
        }
        System.out.println("A pontszáma: " + osszeg);
    }
}

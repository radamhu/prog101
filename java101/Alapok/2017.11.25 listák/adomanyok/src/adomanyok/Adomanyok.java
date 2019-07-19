package adomanyok;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Adomanyok {
    
    static ArrayList<Integer> utalasok = new ArrayList<>();
    
    public static void main(String[] args) {
        // beolvasas
        Scanner bill = new Scanner(System.in);
        System.out.print("Utalások: ");
        while (bill.hasNextInt()) {            
            utalasok.add(bill.nextInt());
        }
        // összeg meghatározása
        int osszeg = 0;
        for (Integer i : utalasok ) {
            osszeg += i;
        }
        System.out.println("A befolyt összeg: " + osszeg);
        // lista rendezése
        Collections.sort(utalasok, Collections.reverseOrder());
        System.out.println(utalasok);
        // első három elem másolása
        ArrayList<Integer> masolat = new ArrayList<>(utalasok.subList(0, 3));
        System.out.println("A legnagyobbik" + masolat);
        
        System.out.println("A legkissebb adomány: " +  utalasok.get(utalasok.size()-1));
        
        System.out.println("Átlag: " + utalasok.size());
    }
}

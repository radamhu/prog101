package kitalal;
import java.util.Random;
import java.util.Scanner;

public class Kitalal {

    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in);
        Random vel = new Random();
        final int HATAR = 100;
        int tipp, lepes, szam;
        szam = vel.nextInt(HATAR) + 1;
        lepes = 0;
        System.out.println("Gondoltam egy számot 1 és "+HATAR+" között");
        System.out.println("Találd ki!");
        do {            
            System.out.print("Tipp: ");
            tipp = bill.nextInt();
            lepes++;
            if (tipp < szam) {
                System.out.println("Ennél nagyobb!");
            } else if (tipp > szam) {
                System.out.println("Ennél kissebb!");
            }
        } while (tipp != szam);
        System.out.println("Gratulálok "+lepes+" lépésben");
    }
}

package hatul;

import java.util.Scanner;

public class Hatul {

    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in);
        int jegy;
        do {            
            System.out.println("Az osztályzat: ");
            jegy = bill.nextInt();
        } while (jegy < 1 || jegy > 5);
        switch (jegy) {
            case 1:
                System.out.println("Elégtelen");
                break;
            case 2:
                System.out.println("Elégséges");
                break;
            case 3:
                System.out.println("Közepes");
                break;
            case 4:
                System.out.println("jó");
                break;
            case 5:
                System.out.println("jeles");
                break;
        }
    }
}

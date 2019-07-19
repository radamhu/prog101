package darts;

import java.util.Scanner;

public class Darts {

    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in);
        System.out.println("Darts játék");
        int pont = 0;
        int db = 0;
        int legnagyobb = 0;
        int legkissebb = 60;
        int dobas;
        while (pont != 301) {            
            System.out.println("Pont: " + pont);
            System.out.print("Dobás: ");
            dobas = bill.nextInt();
            db++;
            if (pont + dobas <= 301) {
                pont += dobas;
                if (dobas > legnagyobb) {
                    legnagyobb = dobas;
                }
                if (dobas < legkissebb){
                    legkissebb = dobas;
                }
            }
        }
        System.out.println("Nyertél!");
        System.out.println("Megszámlálás tétele: A dobások száma: " + db);
        System.out.println("Keresés tétele: A legnagyobb dobás: " + db);
        System.out.println("Keresés tétele: A legkissebb dobás: " + db);
    }
}

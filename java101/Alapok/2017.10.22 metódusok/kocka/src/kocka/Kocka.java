package kocka;
import java.util.Random;
import java.util.Scanner;
public class Kocka {

    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in);
        Random kocka = new Random();
        int jatekos, gep;
        do {
            jatekos = kocka.nextInt(6) + 1;
            System.out.println("A játékos dobása: " + jatekos);
            gep = kocka.nextInt(6) + 1;
            System.out.println("A gép dobása: " + gep);
            if (jatekos > gep) {
                System.out.println("A játékos nyert!");
            } else if (jatekos < gep) {
                System.out.println("A gép nyert!");
            }
            else {
                System.out.println("Döntetlen!");
            }
            System.out.print("Még egy játék (i/n)? ");
        } while (bill.nextLine().charAt(0) != 'n');
    }
}

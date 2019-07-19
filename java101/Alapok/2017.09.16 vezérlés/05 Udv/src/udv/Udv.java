package udv;

import java.util.Scanner;

public class Udv {
    
    public static void main(String[] args) {
        System.out.println("Mi a neved?");
        Scanner bill = new Scanner(System.in,"Cp1250");
        String nev = bill.nextLine();
        System.out.println("Üdvözöllek " + nev + "!");
    }
    
}

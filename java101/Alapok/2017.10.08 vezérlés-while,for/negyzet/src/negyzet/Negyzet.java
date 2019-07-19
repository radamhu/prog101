package negyzet;

import java.util.Scanner;
        
public class Negyzet {
    
    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in);
        System.out.print("Az első szám: ");
        double x = bill.nextDouble();
        while (x !=0 ) {            
            System.out.println("A szám négyzete: " + Math.pow(x, 2));
            System.out.println("A következő szám: ");
            x = bill.nextDouble();
        }
    }
}

package kozososzto;

import java.util.Scanner;

public class Kozososzto {

    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in);
        System.out.print("a szám: ");
        int a = bill.nextInt();
        System.out.print("b szám: ");
        int b = bill.nextInt();
        if (a < b) {
            int s;
            s = a;
            a = b;
            b = s;
        }
        int m = a % b;
        while (m >0) {            
           a = b;
           b = m;
           m = a % b;
        }
        System.out.println("b: " + b);
    }
}

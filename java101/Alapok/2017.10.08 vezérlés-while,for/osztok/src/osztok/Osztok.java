package osztok;

import java.util.Scanner;

public class Osztok {

    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in);
        int n;
        System.out.println("Adj meg egy osztót: ");
        n = bill.nextInt();
        //int i = 1;
        //while (i <= n) {            
        //    if (n%i == 0) {
        //        System.out.print(i + " ");
        //    }
        //    i++;
        //}
        for (int j = 1; j < n; j++) {
            if (n % j == 0) {
                System.out.print(j + "");
            }
        }
        System.out.println("");
    }
}

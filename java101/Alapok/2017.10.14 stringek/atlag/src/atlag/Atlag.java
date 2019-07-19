package atlag;
import java.util.Scanner;
public class Atlag {
    
    static double szamol(String s) {
        int db = 0;
        int osszeg = 0;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c > '1' && c <= '5') {
                db++;
                osszeg += (int)c - (int)'0';
            }
        }
        if (db >0) {
            return (double)osszeg / db;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in);
        System.out.println("Átlag számítás");
        String be;
        while (true) {            
            System.out.print("Osztályzatok: ");
            be = bill.nextLine();
            if (be.equals("")) {
                break;
            }
            System.out.printf("Átlag: %.2f\n", szamol(be));
        }
    }
    
}

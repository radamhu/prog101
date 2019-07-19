package palindroma;
import java.util.Scanner;
public class Palindroma {
    
    static boolean vizsgalat(String s) {
        int bal = 0;
        int jobb = s.length()-1;
        
        while (bal < jobb) {            
            if (s.charAt(bal) != s.charAt(jobb))
                return false;
        bal++;
        jobb--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in, "Cp1250");
        System.out.print("Szöveg: ");
        String be = bill.nextLine().toUpperCase().replace(" ", "");
        System.out.println("Átalakítva: " + be);
        if (vizsgalat(be)) {
            System.out.println("Palindróma!");
        } else {
            System.out.println("Nem palindróma!");
        }
    }
}

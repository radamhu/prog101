package tuvudsz;
import java.util.Scanner;
public class Tuvudsz {
    
    static void kiir(String s) {
        final String MH = "AÁEÉIÍOÓÖŐUÚÜŰ";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c);
            if (MH.indexOf(c) > -1 ) 
                System.out.println("V" + c);
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        System.out.print("Szöveg: ");
        Scanner bill = new Scanner(System.in, "Cp1250");
        String mit = bill.nextLine().toUpperCase();
        
        kiir(mit);
    }
}

package atbas;
import java.util.Scanner;
public class Atbas {
    static final String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    static String atalakit(String s){
        String uj = "";
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            switch (c) {
                case 'Á':
                    c = 'A'; break;
                case 'É':
                    c = 'E'; break;
                case 'Í':
                    c = 'I'; break;
                case 'Ó':
                    c = 'O'; break;
                case 'Ö':
                    c = 'O'; break;
                case 'Ú':
                    c = 'U'; break;
            }
            if (ABC.indexOf(c) > -1) {
                uj += c;
            }
        }
        return uj;
    }
    
    static String kodol(String s) {
        String uj = "";
        char c;
        int n;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            n = ABC.indexOf(c);
            uj += ABC.charAt(ABC.length()-1-n);
        }
        return uj;
    }
    
    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in, "Cp1250");
        String be;
        while (true) {            
            System.out.print("Nyílt szöveg: ");
            be = bill.nextLine().toUpperCase();
            if (be.equals("")) {
                break;
            }
            String at = atalakit(be);
            System.out.println("Átalakítva: " + at);
            String kodolt = kodol(at);
            System.out.println("Kódolva: " + kodolt);
        }
    }
}

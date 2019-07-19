package szethuz;
import java.util.Scanner;
public class Szethuz {
    public static void main(String[] args) {
        System.out.print("Szöveg: ");
        Scanner bill = new Scanner(System.in,"Cp1250");
        String s = bill.nextLine();
        
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i)+ " ");
        }
        System.out.println("");
    }
}

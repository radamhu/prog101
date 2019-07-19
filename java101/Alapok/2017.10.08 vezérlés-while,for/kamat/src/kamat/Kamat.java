package kamat;
import java.util.Scanner;
public class Kamat {

    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in);
        System.out.println("Kamat számító program");
        System.out.print("Az induló összeg: ");
        double osszeg = bill.nextDouble();
        System.out.print("Kamat százalék: ");
        double kamat = bill.nextDouble()/100;
        System.out.print("A betét éve: ");
        int ev1 = bill.nextInt();
        System.out.print("A kivétet éve: ");
        int ev2 = bill.nextInt();
        
        for (int i = ev1+1; i <= ev2; i++) {
            osszeg += osszeg * kamat;
            System.out.println( i + " " + osszeg );
        }
        System.out.println("A kapott összeg: " + Math.round(osszeg));
        for (int j = 100; j <= 200; j+=2) {
            System.out.println("");
        }
    }
}

package nap;
import java.util.Scanner;
public class Nap {
    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in);
        System.out.println("Nap sorszáma: ");
        int nap = bill.nextInt();
        
        switch (nap) {
            case 1:
                System.out.println("hétfő");
                break;
            case 2:
                System.out.println("kedd");
                break;
            case 3:
                System.out.println("szerda");
                break;
            case 4:
                System.out.println("csütörtök");
                break;
            case 5:
                System.out.println("péntek");
                break;
            case 6:
                System.out.println("szombat");
                break;
            case 7:
                System.out.println("vasárnap");
                break;
        }
    }
}

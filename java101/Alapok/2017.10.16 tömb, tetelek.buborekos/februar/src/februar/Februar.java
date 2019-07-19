package februar;
import java.util.Scanner;
public class Februar {
    static Scanner bill = new Scanner(System.in);
    static int feb[] = {2,1,5,-3,3,2,8,-5,1,2,2,-5,0,5,
                 -3,5,-3,3,-21,1,-9,-2,1,1,-9,-12,0,-5};

    static double atlag() {
        int osszeg = 0;
        for (int i = 0; i < feb.length; i++)
            osszeg += feb[i];
        return (double)osszeg/feb.length;
    }
    
    static int minimum() {
        int min = feb[0];
        for (int i = 0; i < feb.length; i++)
            if (feb[i] < min)
                min = feb[i];
        return min;
    }

    static int maximum() {
        int max = feb[0];
        for (int i = 0; i < feb.length; i++)
            if (feb[i] > max)
                max = feb[i];
        return max;
    }
    
    public static void main(String[] args) {
        char v;
        boolean kilep = false;
        do {
            System.out.println("1-Átlag 2-Min 3-Max 4-Fagy"
                             + "5-Javít 6-Diagram 0-Kilép");
            System.out.print("Választás: ");
            v = bill.nextLine().charAt(0);
            switch (v) {
                case '1':
                    System.out.println("Átlag: " + atlag());
                    break;
                case '2':
                    System.out.println("Minimum: " + minimum());
                    break;
                case '3':
                    System.out.println("Maximum: " + maximum());
                    break;
                case '4':
                    System.out.println("Fagyos napok: ");
                    break;
                case '5':
                    System.out.println("Javítás: ");
                    break;
                case '6':
                    System.out.println("Diagram: ");
                    break;
                default:
                    kilep = true;
                    break;
            }
        } while (!kilep);
    }
}

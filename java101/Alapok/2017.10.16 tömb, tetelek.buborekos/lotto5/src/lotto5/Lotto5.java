package lotto5;
import java.util.Random;
public class Lotto5 {

    public static void main(String[] args) {
        // sorsolás
        Random vg = new Random();
        boolean szelveny[] = new boolean[91];
        int szam;
        int db = 0;
        while (db < 5) { 
            szam = vg.nextInt(90)+1;
            if (!szelveny[szam]) {
                szelveny[szam] = true;
                db++;
            }
        }
        
        // kiírás
        System.out.print("A számok: ");
        for (int i = 1; i < szelveny.length; i++) {
            if (szelveny[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println("");
    }
}

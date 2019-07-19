package caesar2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author tothj
 */
public class Caesar2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in);
        System.out.print("Bemenő fájl: ");
        String fbe = bill.next();
        System.out.print("Kimenő fájl: ");
        String fki = bill.next();
        System.out.print("Kulcs: ");
        int kulcs = bill.nextInt();
        
        try (FileInputStream be = new FileInputStream(fbe);                
             FileOutputStream ki = new FileOutputStream(fki)) {
            Kodolo k = new Kodolo(kulcs);
            k.masol(be, ki);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}

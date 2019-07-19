package szerkeszt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Szerkeszt {

    public static void main(String[] args) throws IOException {
        Scanner bill = new Scanner(System.in,"Cp1250");
        System.out.print("A fájl neve: ");
        String nev = bill.nextLine();
        // fájl megnyitása
        FileWriter f = new FileWriter(nev+".txt", true);
        PrintWriter p = new PrintWriter(f);
        //írás fájlba
        System.out.println("Írd be a sorokat! Vége: *");
        while (true) {            
            String sor = bill.nextLine();
            if (sor.equals("*")) 
                break;
            p.println(sor);
        }
        
        Scanner sc = new Scanner(new File("alma.txt"));
        while (sc.hasNextLine()) {            
            String sor = sc.nextLine();
            System.out.println(sor);
        }
        
        //fájl bezárása
        p.close();
    }
}

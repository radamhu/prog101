package konyves;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import konyves.alap.konyv;

public class KonyvDemo {
    static ArrayList<konyv> konyvek = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // Scanner be = new Scanner(new File("konyvek.txt"));
        Scanner be = new Scanner(new File(args[0]));
        while (be.hasNextLine()) {
            String s[] = be.nextLine().split(",");
            konyvek.add(new konyv(s[0],s[1],Integer.parseInt(s[2]),Integer.parseInt(s[3])));
        }
        be.close();
        System.out.println("Könyvek:");
        for (konyv k : konyvek) {
            System.out.println(k.toString());
        }
        int legh = 0;
        for (int i = 1; i <konyvek.size(); i++) {
            if (konyv.hosszabb(konyvek.get(i), konyvek.get(legh)) >0) {
                legh = i;
       
            }
     
        }
        System.out.println("\nLeghosszabb:");
        System.out.println(konyvek.get(legh).toString());
    }
    
}

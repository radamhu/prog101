package txt2srt;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Txt2srt {
    
    static ArrayList<Felirat> feliratok = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        // beolvasás
        Scanner be = new Scanner(new File("feliratok.txt"));
        String s1, s2;
        int max = 0;
        String tmp = "";
        while (be.hasNextLine()) {            
            s1 = be.nextLine();
            s2 = be.nextLine();
            feliratok.add(new Felirat(s1, s2));
            if (s2.length()> max) {
                max = s2.length();
                tmp = s2;
            }
        }
        
        System.out.println("Feliratok száma: " + feliratok.size());
        be.close();
        
        System.out.println("\t" + tmp);
        System.out.println("\t" + max);
        
        // kiírás srt formátumban
        PrintWriter ki = new PrintWriter("felirat.srt");
        for (int i = 0; i < feliratok.size(); i++) {
            ki.println(i+1);
            ki.println(feliratok.get(i).getSrt());
            ki.println(feliratok.get(i).getSzoveg());
            ki.println();
            feliratok.get(i).eltol(1);
        }
        ki.close();
    }
}

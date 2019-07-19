/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodolas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author t1
 */
public class Kodolas {
  
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        Caesar c = new Caesar();
        
        File fbe = new File("vers.txt");
        Scanner be = new Scanner(fbe);
        FileWriter fki = new FileWriter("ki.txt");
        PrintWriter ki = new PrintWriter(fki);
        
        String sor;
        while (be.hasNextLine()) {
            sor = be.nextLine();
            ki.println(c.titkosit(sor, 3));
        }
        
        be.close();
        ki.close();
        
        // System.out.println(c.titkosit("íöüóőúéáú", 0));
        // System.out.println(c.titkosit("ABC", 1));
        // System.out.println(c.titkosit("ABC", -1));
    }
    
}

package teendok;

import java.util.ArrayList;
import java.util.Scanner;
import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

public class Teendok {
    
    static ArrayList<String> lista = new ArrayList<>();
    
    static private void kiir() {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i+1) + ". " + lista.get(i));;
        }
    }
    
    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in,"cp1250");
        System.out.print("> ");
        String be = bill.nextLine();
        while (!be.equals("")) {            
            if (be.charAt(0) == '*') {
                lista.add(0, be.substring(1));
            } 
            else if (be.charAt(0) == '-') {
                int n = Integer.parseInt(be.substring(1));
                if (n <= lista.size()) {
                    lista.remove(n);
                }
            }    
            else {
                lista.add(be);
            }
            kiir();
            System.out.println("Méret: " + lista.size());
            System.out.print("> ");
            be = bill.nextLine();
        }
    }
}

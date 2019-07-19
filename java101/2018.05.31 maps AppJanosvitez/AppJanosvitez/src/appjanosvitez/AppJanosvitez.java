package appjanosvitez;

import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

public class AppJanosvitez {
    
    /*
    * A kapott szóból csak a betűket veszi, a többit (pl. írásjeleket) pedig eltávolítja, és kisbetűssé alakítja a szót:
    */
    static private String tisztit(String s) {
        String abc = "aábccsddzdzseéfggyhiíjkllymnnyoóöőprsszttyuúüűvzzs";
        s = s.toLowerCase();
        String t = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (abc.indexOf(c) > -1 ) {
                t += c;
            }
        }
        return t;
    }
    
    public static void main(String[] args) {
        TreeMap<String, Integer> gyakoriság = new TreeMap<>();
        
        // beolvasás
        try (Scanner be = new Scanner(new File("janos_vitez.txt"))) {
            while (be.hasNext()) {                
                String szo = tisztit(be.next());
                if (szo.isEmpty()) {
                    continue;
                }
                Integer db = gyakoriság.get(szo);
                if (db == null) {
                    db = 1;
                } else {
                    db++;
                }
                gyakoriság.put(szo, db);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (String szo : gyakoriság.keySet()) {
            if (gyakoriság.get(szo) > 1) {
                System.out.println(szo + " " + gyakoriság.get(szo));
            }
        }
    }
}

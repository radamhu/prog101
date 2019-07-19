package konyvek;

import java.util.HashSet;
import java.util.Set;

public class Konyvek {

    public static void main(String[] args) {
        Set<Konyv> k1 = new HashSet<>();        
        Set<Konyv> k2 = new HashSet<>();
        
        k1.add(new Konyv("Rejtő Jenő","A szőke ciklon"));
        k1.add(new Konyv("Jules Verne","80 nap alatt a föld körül"));
        k1.add(new Konyv("Ken Follett","Tű a szénakazalban"));
        k1.add(new Konyv("Ken Follett","A katedrális"));
        
        k2.add(new Konyv("Jules Verne","80 nap alatt a föld körül"));
        k2.add(new Konyv("Rejtő Jenő","Vesztegzár a Grand Hotelben"));
        k2.add(new Konyv("Ken Follett","A katedrális"));
        k2.add(new Konyv("Winston Groom","Forrest Gump"));
        k2.add(new Konyv("Fekete István","Tüskevár"));
        
        System.out.println("Ezek a közösek:\n");
        for (Konyv k : k1) {
            if (k2.contains(k)) {
                System.out.println(k);
            }
        }
              
        System.out.println("Csak az elsőnek van meg:\n");
        for (Konyv k : k1) {
            if (!k2.contains(k)) {
                System.out.println(k);
            }
        }
        
        System.out.println("Csak a másodiknak van meg:\n");
        for (Konyv k : k2) {
            if (!k1.contains(k)) {
                System.out.println(k);
            }
        }
    }
}
